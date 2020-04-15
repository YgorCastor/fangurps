package me.ycastor.fangurps.fixtures;

import cyclops.data.Vector;
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
import me.ycastor.fangurps.shared.mapper.DynamicTagWrapper;

@SuppressWarnings("unchecked")
public class FantasyGroundsFixtures {

    public static FGAbility fgAbility() {
        var skill = fgSkillContainer();
        var wrappedSkill = DynamicTagWrapper.<FGSkillContainer>builder().tagName(skill.uid()).value(skill).build();
        var category = FGCategory.<FGSkillContainer>builder()
                .entities(Vector.of(wrappedSkill))
                .name("Skills")
                .baseicon("0")
                .decalicon("0")
                .build();
        return FGAbility.builder().category(category).build();
    }

    public static FGSkillContainer fgSkillContainer() {
        return FGSkillContainer.builder()
                               .locked(FGLocked.builder().value(1).build())
                               .page(FGPage.builder().value("123AB").build())
                               .type(FGType.builder().value("TYPE").build())
                               .subType(FGSubType.builder().value("SUBTYPE").build())
                               .otherLevel(FGOtherLevel.builder().value(1).build())
                               .otherPoints(FGOtherPoints.builder().value(1).build())
                               .skillType(FGSkillType.builder().value("SKILLTYPE").build())
                               .name(FGSkillName.builder().value("SKILLNAME").build())
                               .skillDefault(FGSkillDefault.builder().value("DEFAULT").build())
                               .build();
    }

}
