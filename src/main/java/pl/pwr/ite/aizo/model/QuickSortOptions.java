package pl.pwr.ite.aizo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import pl.pwr.ite.aizo.model.SortOptions;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class QuickSortOptions extends SortOptions {

    private PivotPosition pivotPosition;
}
