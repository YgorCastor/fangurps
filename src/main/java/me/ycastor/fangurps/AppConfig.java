package me.ycastor.fangurps;

import javax.inject.Singleton;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.oath.cyclops.jackson.CyclopsModule;

import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Replaces;

@Factory
public class AppConfig {

    @Singleton
    @Replaces(XmlMapper.class)
    public XmlMapper xmlMapper() {
        return XmlMapper.xmlBuilder()
                        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                        .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
                        .enable(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)
                        .enable(SerializationFeature.INDENT_OUTPUT)
                        .addModule(new CyclopsModule())
                        .build();
    }

}
