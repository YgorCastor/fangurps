package me.ycastor.fangurps.parsers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.ycastor.fangurps.AppConfig;
import me.ycastor.fangurps.gcs.skills.SkillMapper;
import me.ycastor.fangurps.utils.ResourceStringReader;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Story: GCS Skill to FG Ability Converter")
class GCSSkillToFGSkillTest {

    private final ResourceStringReader resourceStringReader = new ResourceStringReader();
    private SkillMapper skillMapper;
    private GCSSkillToFGSkill gcsSkillToFGSkill;

    @BeforeEach
    void setUp() {
        skillMapper = new SkillMapper(new AppConfig().xmlMapper());
        gcsSkillToFGSkill = new GCSSkillToFGSkill();
    }

    @Test
    @DisplayName("Scenario: Parse an GCS Skill to a Fantasy Grounds Ability")
    void parse_Successfully() {
        // Given
        var validGcsSkillXml = resourceStringReader.read("/gcs/skill_valid_small.xml");
        var skillList = skillMapper.xmlToDomain(validGcsSkillXml);

        // when
        var result = gcsSkillToFGSkill.parse(skillList.orElse(null));

        // assert
        assertThat(result.isRight()).isTrue();
        var ability = result.get().orElse(null);
        var categories = ability.getCategory();

        assertThat(categories.getName()).isEqualTo("Skills");
        assertThat(categories.getBaseicon()).isEqualTo("0");
        assertThat(categories.getDecalicon()).isEqualTo("0");

        var fgskills = categories.getEntities();
        assertThat(fgskills).hasSize(1);

        var skill = fgskills.get(0).orElse(null).getValue();
        assertThat(skill.getLocked().getValue()).isEqualTo(1);
        assertThat(skill.getName().getValue()).isEqualTo("Accounting");
        assertThat(skill.getOtherLevel().getValue()).isEqualTo(0);
        assertThat(skill.getOtherPoints().getValue()).isEqualTo(1);
        assertThat(skill.getSubType().getValue()).isEqualTo("Business");
        assertThat(skill.getSkillType().getValue()).isEqualTo("IQ/H");
        assertThat(skill.getType().getValue()).isEqualTo("Skill");
        assertThat(skill.getPage().getValue()).isEqualTo("B174");

        assertThat(skill.getSkillDefault().getValue()).isEqualTo("Skill: Mathematics -5");
    }
}