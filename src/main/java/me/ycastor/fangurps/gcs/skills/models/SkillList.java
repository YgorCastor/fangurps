
package me.ycastor.fangurps.gcs.skills.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import cyclops.data.Vector;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillList {
    @JsonProperty("skill_container")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Vector<SkillContainer> skillContainer;
    @JacksonXmlElementWrapper(useWrapping = false)
    private Vector<Skill> skill;
    @JacksonXmlElementWrapper(useWrapping = false)
    private Vector<Skill> technique;
}
