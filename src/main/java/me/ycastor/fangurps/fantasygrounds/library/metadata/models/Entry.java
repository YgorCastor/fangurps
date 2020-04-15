package me.ycastor.fangurps.fantasygrounds.library.metadata.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Entry {
    @JsonProperty("librarylink")
    private LibraryLink libraryLink;
    private EntryName name;
    @JsonProperty("recordtype")
    private RecordType recordType;
}
