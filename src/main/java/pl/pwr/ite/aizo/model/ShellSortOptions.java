package pl.pwr.ite.aizo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class ShellSortOptions extends SortOptions {

    private ShellAlgorithmType shellAlgorithmType;
}
