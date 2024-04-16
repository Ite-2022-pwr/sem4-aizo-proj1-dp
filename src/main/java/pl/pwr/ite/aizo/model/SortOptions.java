package pl.pwr.ite.aizo.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class SortOptions {

    public SortOptions() {
    }

    private SortDataType dataType;

    private int[] arraySizes;

    private int iterations;

}
