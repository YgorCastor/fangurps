package me.ycastor.fangurps.fantasygrounds.library.metadata.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import cyclops.data.Vector;
import lombok.Builder;
import lombok.Data;
import me.ycastor.fangurps.shared.mapper.DynamicTagWrapper;

@Data
@Builder
public class LibraryMetadata {
    @JacksonXmlProperty(isAttribute = true)
    private String isStatic;
    @JsonProperty("categoryname")
    private CategoryName categoryName;
    private LibraryName name;
    private Vector<DynamicTagWrapper<Entry>> entries;
}
