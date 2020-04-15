package me.ycastor.fangurps.fantasygrounds.metadata.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.ycastor.fangurps.fantasygrounds.common.models.FGRoot;

@EqualsAndHashCode(callSuper = false)
@Builder
@Data
@JacksonXmlRootElement(localName = "root")
public class FGModDefinition extends FGRoot {
    private String name;
    private String category;
    @Builder.Default
    private String author = "FanGURPS Converter";
    @Builder.Default
    private String ruleset = "GURPS";
}
