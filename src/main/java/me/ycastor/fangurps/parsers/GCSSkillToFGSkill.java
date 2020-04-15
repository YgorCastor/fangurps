package me.ycastor.fangurps.parsers;

import java.util.stream.Collectors;

import javax.inject.Singleton;

import cyclops.control.Either;
import cyclops.data.Vector;
import lombok.extern.slf4j.Slf4j;
import me.ycastor.fangurps.fantasygrounds.common.models.FGCategory;
import me.ycastor.fangurps.fantasygrounds.common.models.FGLocked;
import me.ycastor.fangurps.fantasygrounds.common.models.FGPage;
import me.ycastor.fangurps.fantasygrounds.skills.models.FGAbility;
import me.ycastor.fangurps.fantasygrounds.skills.models.FGOtherLevel;
import me.ycastor.fangurps.fantasygrounds.skills.models.FGOtherPoints;
import me.ycastor.fangurps.fantasygrounds.skills.models.FGSkillContainer;
import me.ycastor.fangurps.fantasygrounds.skills.models.FGSkillDefault;
import me.ycastor.fangurps.fantasygrounds.skills.models.FGSkillName;
import me.ycastor.fangurps.fantasygrounds.skills.models.FGSkillType;
import me.ycastor.fangurps.fantasygrounds.skills.models.FGSubType;
import me.ycastor.fangurps.fantasygrounds.skills.models.FGType;
import me.ycastor.fangurps.gcs.skills.models.Default;
import me.ycastor.fangurps.gcs.skills.models.Skill;
import me.ycastor.fangurps.gcs.skills.models.SkillList;
import me.ycastor.fangurps.shared.mapper.DynamicTagWrapper;

@Singleton
@Slf4j
public class GCSSkillToFGSkill implements Parser<SkillList, FGAbility> {

    @Override
    public Either<ParsingException, FGAbility> parse(SkillList source) {
        try {
            log.info("Parsing '{}' to '{}'", SkillList.class, FGAbility.class);

            var skills = source.getSkill().map(this::parseSkill);
            var techniques = source.getTechnique().map(this::parseSkill);
            var skillContainer = source.getSkillContainer().flatMap(gcsContainer -> gcsContainer.getSkill().map(this::parseSkill));
            var allSkills = skills.appendAll(techniques)
                                  .appendAll(skillContainer)
                                  .map(sk -> DynamicTagWrapper.<FGSkillContainer>builder().tagName(sk.uid()).value(sk).build());
            var category = FGCategory.<FGSkillContainer>builder().entities(allSkills).name("Skills").baseicon("0").decalicon("0").build();
            var ability = FGAbility.builder().category(category).build();

            return Either.right(ability);
        } catch (Exception ex) {
            var parsingException = new ParsingException(SkillList.class, FGAbility.class, ex);
            log.error("Parsing failure: ", parsingException);
            return Either.left(parsingException);
        }
    }

    private FGSkillContainer parseSkill(Skill skill) {
        return FGSkillContainer.builder()
                               .locked(FGLocked.builder().value(1).build())
                               .name(FGSkillName.builder().value(skill.getName()).build())
                               .otherPoints(FGOtherPoints.builder().value(skill.getPoints()).build())
                               .skillType(FGSkillType.builder().value(skill.getDifficulty()).build())
                               .otherLevel(FGOtherLevel.builder().value(0).build())
                               .subType(parseCategories(skill.getCategories()))
                               .skillDefault(parseDefaults(skill.getADefault()))
                               .type(FGType.builder().value("Skill").build())
                               .page(FGPage.builder().value(skill.getReference().orElse("")).build())
                               .build();
    }

    private FGSubType parseCategories(Vector<String> categories) {
        var subTypes = String.join(",", categories);
        return FGSubType.builder().value(subTypes).build();
    }

    private FGSkillDefault parseDefaults(Vector<Default> defaults) {
        var aDefault = defaults.map(gcsDefault -> String.format("%s: %s %d", gcsDefault.getType(),
                                                                gcsDefault.getName().orElse(""),
                                                                gcsDefault.getModifier()))
                               .collect(Collectors.joining(";"));
        return FGSkillDefault.builder().value(aDefault).build();
    }

}
