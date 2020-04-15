package me.ycastor.fangurps.fantasygrounds;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.extern.slf4j.Slf4j;
import me.ycastor.fangurps.fantasygrounds.actions.ConvertLibraryAction;
import me.ycastor.fangurps.fantasygrounds.library.metadata.FGLibrarySerializer;
import me.ycastor.fangurps.fantasygrounds.library.metadata.LibraryMetadataBuilder;
import me.ycastor.fangurps.fantasygrounds.metadata.ModDefinitionMapper;
import me.ycastor.fangurps.fantasygrounds.metadata.models.FGModDefinition;
import me.ycastor.fangurps.shared.mapper.MappingException;

@Singleton
@Slf4j
public class ModWriter {

    private final FGLibrarySerializer librarySerializer;
    private final ModDefinitionMapper modDefinitionMapper;

    @Inject
    public ModWriter(
            FGLibrarySerializer librarySerializer,
            ModDefinitionMapper modDefinitionMapper
    ) {
        this.librarySerializer = librarySerializer;
        this.modDefinitionMapper = modDefinitionMapper;
    }

    public <T> void write(FGModDefinition modDefinition, ConvertLibraryAction<T> convert) {
        log.info("Writing mod: {}", modDefinition);

        var modDefinitionXml = modDefinitionMapper.domainToXml(modDefinition)
                                                  .fold(rethrow(), mod -> mod);
        var libraryMetadata = LibraryMetadataBuilder.build(convert.getModType(), convert.getLibraryName());
        var library = librarySerializer.toXml(convert.getMod(), convert.getModType().getRecordType(), libraryMetadata)
                                       .fold(rethrow(), lib -> lib);

        writeFile(convert.getOutput(), modDefinitionXml, library);
    }

    private void writeFile(Path path, String modDefinitionXml, String library) {
        try {
            FileOutputStream fos = new FileOutputStream(path.resolve("output.mod").toString());
            ZipOutputStream zos = new ZipOutputStream(fos);

            zos.putNextEntry(new ZipEntry("definition.xml"));
            zos.write(modDefinitionXml.getBytes());
            zos.closeEntry();
            zos.putNextEntry(new ZipEntry("db.xml"));
            zos.write(library.getBytes());
            zos.closeEntry();

            zos.close();
            fos.close();
            log.info("Mod written successfully");
        } catch (IOException e) {
            log.error("Failed to write the ModFile", e);
        }
    }

    private Function<MappingException, String> rethrow() {
        return exception -> {
            throw exception;
        };
    }

}
