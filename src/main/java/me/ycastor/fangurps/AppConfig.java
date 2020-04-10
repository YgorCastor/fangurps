package me.ycastor.fangurps;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.oath.cyclops.jackson.CyclopsModule;

@Singleton
public class AppConfig {

    @Singleton
    public ExecutorService executorService() {
        return Executors.newSingleThreadExecutor();
    }

    @Singleton
    public XmlMapper xmlMapper() {
        return XmlMapper.xmlBuilder()
                        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                        .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
                        .enable(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)
                        .addModule(new CyclopsModule())
                        .build();
    }

}
