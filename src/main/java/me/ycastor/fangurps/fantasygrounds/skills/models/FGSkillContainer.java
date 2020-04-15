package me.ycastor.fangurps.fantasygrounds.skills.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.ycastor.fangurps.fantasygrounds.common.models.FGLocked;
import me.ycastor.fangurps.fantasygrounds.common.models.FGPage;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FGSkillContainer {
    private FGLocked locked;
    private FGSkillName name;
    @JsonProperty("otherlevel")
    private FGOtherLevel otherLevel;
    @JsonProperty("otherpoints")
    private FGOtherPoints otherPoints;
    @JsonProperty("skilldefault")
    private FGSkillDefault skillDefault;
    @JsonProperty("skilltype")
    private FGSkillType skillType;
    @JsonProperty("subtype")
    private FGSubType subType;
    private FGPage page;
    private FGType type;

    public String uid() {
        return "id-" + name.getValue().hashCode();
    }
}
