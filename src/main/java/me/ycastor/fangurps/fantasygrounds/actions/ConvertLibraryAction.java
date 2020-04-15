package me.ycastor.fangurps.fantasygrounds.actions;

import java.nio.file.Path;

import lombok.Builder;
import lombok.Data;
import me.ycastor.fangurps.fantasygrounds.skills.FGModType;

@Data
@Builder
public class ConvertLibraryAction<T> {
    private final FGModType modType;
    private final String libraryName;
    private final Path output;
    private final T mod;
}
