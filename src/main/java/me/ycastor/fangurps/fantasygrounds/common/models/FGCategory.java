package me.ycastor.fangurps.fantasygrounds.common.models;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import cyclops.data.Vector;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FGCategory<T> {
    @JacksonXmlProperty(isAttribute = true)
    private String name;
    @JacksonXmlProperty(isAttribute = true)
    private String baseicon;
    @JacksonXmlProperty(isAttribute = true)
    private String decalicon;

    @Builder.Default
    private Vector<T> entities = Vector.empty();
}
