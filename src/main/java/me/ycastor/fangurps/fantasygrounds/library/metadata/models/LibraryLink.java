package me.ycastor.fangurps.fantasygrounds.library.metadata.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LibraryLink {
    @JacksonXmlProperty(isAttribute = true)
    @Builder.Default
    private String type = "string";
    @JsonProperty("class")
    private Clazz clazz;
    @JsonProperty("recordname")
    private RecordName recordName;
}
