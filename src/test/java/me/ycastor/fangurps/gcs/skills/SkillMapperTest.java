package me.ycastor.fangurps.gcs.skills;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.ycastor.fangurps.AppConfig;
import me.ycastor.fangurps.gcs.skills.models.Default;
import me.ycastor.fangurps.gcs.skills.models.Skill;
import me.ycastor.fangurps.gcs.skills.models.SkillContainer;
import me.ycastor.fangurps.gcs.skills.models.SkillList;
import me.ycastor.fangurps.utils.ResourceStringReader;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Story: GCS Skill Mapping")
class SkillMapperTest {
    private final ResourceStringReader resourceStringReader = new ResourceStringReader();

    private SkillMapper skillMapper;

    @BeforeEach
    void setUp() {
        skillMapper = new SkillMapper(new AppConfig().xmlMapper());
    }

    @Test
    @DisplayName("Scenario: Maps an XML to Skill domain successfully")
    public void map_xmlToDomain_Success() {
        String validSkillXml = resourceStringReader.read("/gcs/skill_valid.xml");

        var skillList = skillMapper.xmlToDomain(validSkillXml);

        assertThat(skillList.isLeft()).isFalse();

        SkillList unwrappedList = skillList.get().orElse(null);

        assertThat(unwrappedList.getSkill()).hasSize(1);
        assertThat(unwrappedList.getTechnique()).hasSize(1);
        assertThat(unwrappedList.getSkillContainer()).hasSize(1);

        // Assert Skills
        Skill aSkill = unwrappedList.getSkill().get(0).orElse(null);
        assertThat(aSkill.getDifficulty()).isEqualTo("IQ/H");
        assertThat(aSkill.getName()).isEqualTo("Accounting");
        assertThat(aSkill.getPoints()).isEqualTo(1);
        assertThat(aSkill.getReference().orElse(null)).isEqualTo("B174");
        assertThat(aSkill.getCategories()).contains("Business");
        Default aSkillDefault = aSkill.getADefault().get(0).orElse(null);
        assertThat(aSkillDefault.getModifier()).isEqualTo(-5);
        assertThat(aSkillDefault.getName().orElse(null)).isEqualTo("Mathematics");
        assertThat(aSkillDefault.getSpecialization().orElse(null)).isEqualTo("Statistics");
        assertThat(aSkillDefault.getType()).isEqualTo("Skill");

        // Assert Techniques
        Skill aTechnique = unwrappedList.getTechnique().get(0).orElse(null);
        assertThat(aTechnique.getName()).isEqualTo("Acrobatic Stand");
        assertThat(aTechnique.getDifficulty()).isEqualTo("A");
        assertThat(aTechnique.getPoints()).isEqualTo(1);
        assertThat(aTechnique.getReference().orElse(null)).isEqualTo("MA65");
        Default aTechiqueDefault = aTechnique.getADefault().get(0).orElse(null);
        assertThat(aTechiqueDefault.getModifier()).isEqualTo(-6);
        assertThat(aTechiqueDefault.getName().orElse(null)).isEqualTo("Acrobatics");
        assertThat(aTechiqueDefault.getSpecialization().isPresent()).isFalse();
        assertThat(aTechiqueDefault.getType()).isEqualTo("Skill");

        // Assert Skill Containers
        SkillContainer skillContainer = unwrappedList.getSkillContainer().get(0).orElse(null);
        assertThat(skillContainer.getName()).isEqualTo("Expert Skill");
        Skill skillContainerSkill = skillContainer.getSkill().get(0).orElse(null);
        assertThat(skillContainerSkill.getDifficulty()).isEqualTo("IQ/H");
        assertThat(skillContainerSkill.getName()).isEqualTo("Expert Skill");
        assertThat(skillContainerSkill.getPoints()).isEqualTo(1);
        assertThat(skillContainerSkill.getReference().orElse(null)).isEqualTo("F135");
        assertThat(skillContainerSkill.getCategories()).contains("Knowledge", "Scholarly");
        String specialization = skillContainerSkill.getSpecialization().orElse(null);
        assertThat(specialization).isEqualTo("Bardic Lore");
        assertThat(skillContainerSkill.getADefault()).isEmpty();
    }


}