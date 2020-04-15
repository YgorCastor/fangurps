
package me.ycastor.fangurps.gcs.skills.models;

import cyclops.control.Option;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Default {
    private Integer modifier;
    private String type;
    @Builder.Default
    private Option<String> name = Option.none();
    @Builder.Default
    private Option<String> specialization = Option.none();
}
