package me.ycastor.fangurps.shared.mapper;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import cyclops.data.Vector;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonSerialize(using = DynamicFieldSerializer.class)
public abstract class DynamicContainer<T> extends DynamicTag {
    @JacksonXmlElementWrapper(useWrapping = false)
    private Vector<T> entities;
}
