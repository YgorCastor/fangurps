package me.ycastor.fangurps.fantasygrounds.common.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class FGRoot {
    @JacksonXmlProperty(isAttribute = true)
    private String version = "3.3";
    @JacksonXmlProperty(isAttribute = true)
    private String release = "8|CoreRPG:4";
}
