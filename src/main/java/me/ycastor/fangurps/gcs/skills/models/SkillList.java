
package me.ycastor.fangurps.gcs.skills.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import cyclops.data.Vector;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SkillList {
    @JacksonXmlElementWrapper(useWrapping = false)
    @Builder.Default
    @JsonProperty("skill_container")
    private Vector<SkillContainer> skillContainer = Vector.empty();
    @JacksonXmlElementWrapper(useWrapping = false)
    @Builder.Default
    private Vector<Skill> skill = Vector.empty();
    @JacksonXmlElementWrapper(useWrapping = false)
    @Builder.Default
    private Vector<Skill> technique = Vector.empty();

    public void setSkillContainer(Vector<SkillContainer> skillContainer) {
        this.skillContainer = this.skillContainer.appendAll(skillContainer);
    }

    public void setSkill(Vector<Skill> skill) {
        this.skill = this.skill.appendAll(skill);
    }

    public void setTechnique(Vector<Skill> technique) {
        this.technique = this.technique.appendAll(technique);
    }
}
