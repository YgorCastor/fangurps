package me.ycastor.fangurps.fantasygrounds.library.metadata;

import javax.inject.Inject;
import javax.inject.Singleton;

import cyclops.control.Either;
import me.ycastor.fangurps.fantasygrounds.library.metadata.models.FGLibraryRoot;
import me.ycastor.fangurps.fantasygrounds.library.metadata.models.Library;
import me.ycastor.fangurps.shared.mapper.DynamicTagWrapper;
import me.ycastor.fangurps.shared.mapper.MappingException;

@Singleton
public class FGLibrarySerializer {

    private final FGLibraryRootMapper fgRootMapper;

    @Inject
    public FGLibrarySerializer(FGLibraryRootMapper fgRootMapper) {
        this.fgRootMapper = fgRootMapper;
    }

    public <T> Either<MappingException, String> toXml(T mod, String contentTag, Library library) {
        var content = DynamicTagWrapper.<T>builder().tagName(contentTag).value(mod).build();
        var root = FGLibraryRoot.<T>builder().content(content).library(library).build();
        return fgRootMapper.domainToXml(root);
    }

}
