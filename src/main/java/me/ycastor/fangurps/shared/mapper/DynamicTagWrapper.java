package me.ycastor.fangurps.shared.mapper;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Builder;
import lombok.Data;

@JsonSerialize(using = DynamicFieldSerializer.class)
@Data
@Builder
public class DynamicTagWrapper<T> {
    private String tagName;
    private T value;
}
