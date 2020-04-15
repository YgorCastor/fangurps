package me.ycastor.fangurps.fantasygrounds.library.metadata.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryName {
    @JacksonXmlProperty(isAttribute = true)
    @Builder.Default
    private String type = "string";
    @JacksonXmlText
    private String value;
}
