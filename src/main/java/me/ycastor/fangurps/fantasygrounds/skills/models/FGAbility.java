package me.ycastor.fangurps.fantasygrounds.skills.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.ycastor.fangurps.fantasygrounds.common.models.FGCategory;

@Data
@Builder
public class FGAbility {
    private FGCategory<FGSkillContainer> category;
}
