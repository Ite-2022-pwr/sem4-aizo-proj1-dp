package pl.pwr.ite.aizo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class SortOptions {

    private SortDataType dataType;

    private ArrayType arrayType;

    private int[] arraySizes;

    private int iterations;

    private int[] intData;

    private char[] charData;

    private double[] doubleData;

}
