package me.ycastor.fangurps.fantasygrounds.library.metadata;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import me.ycastor.fangurps.fantasygrounds.library.metadata.models.FGLibraryRoot;
import me.ycastor.fangurps.shared.mapper.BaseXmlMapper;

@SuppressWarnings("rawtypes")
@Singleton
public class FGLibraryRootMapper implements BaseXmlMapper<FGLibraryRoot> {

    private XmlMapper xmlMapper;

    @Inject
    public FGLibraryRootMapper(XmlMapper xmlMapper) {
        this.xmlMapper = xmlMapper;
    }

    @Override
    public XmlMapper xmlMapper() {
        return xmlMapper;
    }

    @Override
    public Class<FGLibraryRoot> domainClass() {
        return FGLibraryRoot.class;
    }
}
