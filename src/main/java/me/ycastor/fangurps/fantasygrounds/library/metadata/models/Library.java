package me.ycastor.fangurps.fantasygrounds.library.metadata.models;

import lombok.Builder;
import lombok.Data;
import me.ycastor.fangurps.shared.mapper.DynamicTagWrapper;

@Data
@Builder
public class Library {
    private DynamicTagWrapper<LibraryMetadata> libraryMetadata;
}
