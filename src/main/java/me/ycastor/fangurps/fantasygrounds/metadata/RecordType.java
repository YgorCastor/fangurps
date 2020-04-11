package me.ycastor.fangurps.fantasygrounds.metadata;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecordType {
    @JacksonXmlProperty(isAttribute = true)
    @Builder.Default
    private String type = "string";
    @JacksonXmlText
    private String value;
}
