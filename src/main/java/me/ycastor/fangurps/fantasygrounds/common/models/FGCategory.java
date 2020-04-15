package me.ycastor.fangurps.fantasygrounds.common.models;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import cyclops.data.Vector;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import me.ycastor.fangurps.shared.mapper.DynamicTagWrapper;

@Builder
@Data
public class FGCategory<T> {
    @JacksonXmlProperty(isAttribute = true)
    private String name;
    @JacksonXmlProperty(isAttribute = true)
    private String baseicon;
    @JacksonXmlProperty(isAttribute = true)
    private String decalicon;

    @Builder.Default
    @JacksonXmlElementWrapper(useWrapping = false)
    private Vector<DynamicTagWrapper<T>> entities = Vector.empty();
}
