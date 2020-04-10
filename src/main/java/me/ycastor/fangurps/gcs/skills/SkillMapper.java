package me.ycastor.fangurps.gcs.skills;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import me.ycastor.fangurps.gcs.skills.models.SkillList;
import me.ycastor.fangurps.shared.mapper.BaseXmlMapper;

@Singleton
public class SkillMapper implements BaseXmlMapper<SkillList> {

    private final XmlMapper xmlMapper;

    @Inject
    public SkillMapper(XmlMapper xmlMapper) {
        this.xmlMapper = xmlMapper;
    }

    @Override
    public XmlMapper xmlMapper() {
        return xmlMapper;
    }

    @Override
    public Class<SkillList> domainClass() {
        return SkillList.class;
    }
}
