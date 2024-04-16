package pl.pwr.ite.aizo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class ShellSortOptions extends SortOptions {

    private Integer gap;
}
