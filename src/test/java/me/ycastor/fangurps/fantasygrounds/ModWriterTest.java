package me.ycastor.fangurps.fantasygrounds;

import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import me.ycastor.fangurps.AppConfig;
import me.ycastor.fangurps.fantasygrounds.actions.ConvertLibraryAction;
import me.ycastor.fangurps.fantasygrounds.library.metadata.FGLibraryRootMapper;
import me.ycastor.fangurps.fantasygrounds.library.metadata.FGLibrarySerializer;
import me.ycastor.fangurps.fantasygrounds.metadata.ModDefinitionMapper;
import me.ycastor.fangurps.fantasygrounds.metadata.models.FGModDefinition;
import me.ycastor.fangurps.fantasygrounds.skills.FGModType;
import me.ycastor.fangurps.fixtures.FantasyGroundsFixtures;

class ModWriterTest {

    private ModWriter modWriter;

    @BeforeEach
    void setUp() {
        var xmlMapper = new AppConfig().xmlMapper();
        var fgLibraryRootMapper = new FGLibraryRootMapper(xmlMapper);
        var fgLibrarySerializer = new FGLibrarySerializer(fgLibraryRootMapper);
        var modDefinitionMapper = new ModDefinitionMapper(xmlMapper);
        modWriter = new ModWriter(fgLibrarySerializer, modDefinitionMapper);
    }

    @Test
    void writeSuccess(@TempDir Path tempDir) {
        // given
        var modDefinition = FGModDefinition.builder().name("Test").build();
        var fgAbility = FantasyGroundsFixtures.fgAbility();
        var action = ConvertLibraryAction.builder()
                                         .libraryName("Test")
                                         .modType(FGModType.ABILITY)
                                         .mod(fgAbility)
                                         .output(tempDir)
                                         .build();

        modWriter.write(modDefinition, action);
    }
}