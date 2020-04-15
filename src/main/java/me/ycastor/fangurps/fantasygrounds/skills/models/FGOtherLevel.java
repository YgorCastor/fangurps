package me.ycastor.fangurps.fantasygrounds.skills.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class FGOtherLevel {
    @JacksonXmlProperty(isAttribute = true)
    @Builder.Default
    private String type = "number";
    @JacksonXmlText
    private Integer value;
}
