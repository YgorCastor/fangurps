package me.ycastor.fangurps.fantasygrounds.metadata;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import me.ycastor.fangurps.fantasygrounds.metadata.models.FGModDefinition;
import me.ycastor.fangurps.shared.mapper.BaseXmlMapper;

@Singleton
public class ModDefinitionMapper implements BaseXmlMapper<FGModDefinition> {

    private final XmlMapper xmlMapper;

    @Inject
    public ModDefinitionMapper(XmlMapper xmlMapper) {
        this.xmlMapper = xmlMapper;
    }

    @Override
    public XmlMapper xmlMapper() {
        return xmlMapper;
    }

    @Override
    public Class<FGModDefinition> domainClass() {
        return FGModDefinition.class;
    }
}
