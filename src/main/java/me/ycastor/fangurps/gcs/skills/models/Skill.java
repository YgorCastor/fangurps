
package me.ycastor.fangurps.gcs.skills.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import cyclops.control.Option;
import cyclops.data.Vector;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Skill {
    @Getter
    private Vector<String> categories;
    @JsonProperty("default")
    @Setter
    @JacksonXmlElementWrapper(useWrapping = false)
    private Vector<Default> aDefault;
    @Getter
    @Setter
    private String difficulty;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Integer points;
    @Setter
    private String reference;
    @Setter
    private String specialization;
    @Setter
    private String techLevel;

    public Option<String> getReference() {
        return Option.ofNullable(reference);
    }

    public Option<String> getSpecialization() {
        return Option.ofNullable(specialization);
    }

    public Option<String> getTechLevel() {
        return Option.ofNullable(techLevel);
    }

    public Vector<Default> getADefault() {
        return aDefault != null ? aDefault : Vector.empty();
    }

    public Vector<String> getCategories() {
        return categories != null ? categories : Vector.empty();
    }
}
