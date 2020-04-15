package me.ycastor.fangurps.fantasygrounds.skills;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum FGModType {
    ABILITY("GURPS_Skills", "Abilities", "ability");

    private final String libraryType;
    private final String libraryEntry;
    private final String recordType;
}
