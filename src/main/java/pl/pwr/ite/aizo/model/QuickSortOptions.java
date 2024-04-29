package pl.pwr.ite.aizo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pl.pwr.ite.aizo.model.SortOptions;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class QuickSortOptions extends SortOptions {

    private PivotPosition pivotPosition;
}
