
package me.ycastor.fangurps.gcs.skills.models;

import cyclops.control.Option;
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
public class Default {
    @Getter
    @Setter
    private Integer modifier;
    @Getter
    @Setter
    private String type;
    @Setter
    private String name;
    @Setter
    private String specialization;

    public Option<String> getName() {
        return Option.ofNullable(name);
    }

    public Option<String> getSpecialization() {
        return Option.ofNullable(specialization);
    }
}
