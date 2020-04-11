package me.ycastor.fangurps.fantasygrounds.skills.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.ycastor.fangurps.fantasygrounds.common.models.FGLocked;
import me.ycastor.fangurps.fantasygrounds.common.models.FGPage;
import me.ycastor.fangurps.shared.mapper.DynamicTag;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class FGSkillContainer extends DynamicTag {
    private FGLocked locked;
    private FGSkillName name;
    private FGOtherLevel otherLevel;
    private FGOtherPoints otherPoints;
    private FGSkillDefault skillDefault;
    private FGSkillType skillType;
    private FGSubType subType;
    private FGPage page;
    private FGType type;

    @Override
    public String tagName() {
        return "id-" + uid();
    }

    private Integer uid() {
        return name.getValue().hashCode();
    }
}
