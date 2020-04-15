package me.ycastor.fangurps.fantasygrounds.library.metadata.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecordName {
    @JacksonXmlText
    private String value;
}
