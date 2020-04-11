package me.ycastor.fangurps.fantasygrounds.common.models;

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
public class FGLocked {
    @JacksonXmlProperty(isAttribute = true)
    @Builder.Default
    private String type = "number";
    @JacksonXmlText
    private Integer value;
}
