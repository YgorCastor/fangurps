package me.ycastor.fangurps.shared.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import cyclops.control.Either;
import cyclops.control.Try;

public interface BaseXmlMapper<T> {

    default Either<MappingException, T> xmlToDomain(String xml) {
        return Try.withCatch(() -> xmlMapper().readValue(xml, domainClass()), JsonProcessingException.class)
                  .asEither()
                  .mapLeft(throwable -> new MappingException(domainClass(), throwable));
    }

    default Either<MappingException, String> domainToXml(T domain) {
        return Try.withCatch(() -> xmlMapper().writeValueAsString(domain), JsonProcessingException.class)
                  .asEither()
                  .mapLeft(MappingException::new);
    }

    XmlMapper xmlMapper();

    Class<T> domainClass();

}
