
package me.ycastor.fangurps.gcs.skills.models;


import cyclops.data.Vector;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SkillContainer {
    private String name;
    @Builder.Default
    private Vector<Skill> skill = Vector.empty();

    public void setSkill(Vector<Skill> skill) {
        this.skill = this.skill.appendAll(skill);
    }
}
