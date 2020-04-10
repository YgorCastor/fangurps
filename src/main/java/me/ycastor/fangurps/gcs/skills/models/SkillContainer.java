
package me.ycastor.fangurps.gcs.skills.models;


import cyclops.data.Vector;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillContainer {
    private String name;
    private Vector<Skill> skill;
}
