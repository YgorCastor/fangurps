package me.ycastor.fangurps.fantasygrounds.metadata;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibraryLink {
    @JacksonXmlProperty(isAttribute = true)
    @Builder.Default
    private String type = "string";
    private Clazz clazz;
    private RecordName recordName;
}
