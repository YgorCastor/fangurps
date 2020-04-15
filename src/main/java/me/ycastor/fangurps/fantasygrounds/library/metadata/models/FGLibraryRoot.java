package me.ycastor.fangurps.fantasygrounds.library.metadata.models;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.ycastor.fangurps.fantasygrounds.common.models.FGRoot;
import me.ycastor.fangurps.shared.mapper.DynamicTagWrapper;

@EqualsAndHashCode(callSuper = false)
@Data
@Builder
@JacksonXmlRootElement(localName = "root")
public class FGLibraryRoot<T> extends FGRoot {
    public DynamicTagWrapper<T> content;
    public Library library;
}
