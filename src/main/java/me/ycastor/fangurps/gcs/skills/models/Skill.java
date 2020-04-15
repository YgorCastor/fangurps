
package me.ycastor.fangurps.gcs.skills.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import cyclops.control.Option;
import cyclops.data.Vector;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Skill {
    @Builder.Default
    private Vector<String> categories = Vector.empty();
    @JsonProperty("default")
    @JacksonXmlElementWrapper(useWrapping = false)
    @Builder.Default
    private Vector<Default> aDefault = Vector.empty();
    private String difficulty;
    private String name;
    private Integer points;
    @Builder.Default
    private Option<String> reference = Option.none();
    @Builder.Default
    private Option<String> specialization = Option.none();
    @Builder.Default
    private Option<String> techLevel = Option.none();
}
