package pl.pwr.ite.aizo.model;

import lombok.Getter;

public class DefaultSortOptions {

    public static final int[] SORT_SIZES = { 10_000, 20_000, 30_000, 40_000, 50_000, 60_000, 70_000 };
    public static final int[] QUICK_SORT_SIZES = { 1_000, 2_000, 3_000, 4_000, 5_000, 6_000, 7_000 };

    public static final SortOptions DEFAULT_INTEGER = SortOptions.builder()
            .dataType(SortDataType.Integer)
            .arrayType(ArrayType.SortedAsc)
            .arraySizes(SORT_SIZES)
            .iterations(100)
            .build();

    public static final SortOptions DEFAULT_CHARACTER = SortOptions.builder()
            .dataType(SortDataType.Character)
            .arrayType(ArrayType.FullyRandom)
            .arraySizes(SORT_SIZES)
            .iterations(100)
            .build();

    public static final SortOptions DEFAULT_DOUBLE = SortOptions.builder()
            .dataType(SortDataType.Double)
            .arrayType(ArrayType.FullyRandom)
            .arraySizes(SORT_SIZES)
            .iterations(100)
            .build();

    public static final QuickSortOptions DEFAULT_QUICK_SORT_INTEGER = QuickSortOptions.builder()
            .dataType(SortDataType.Integer)
            .arrayType(ArrayType.FullyRandom)
            .arraySizes(SORT_SIZES)
            .iterations(100)
            .pivotPosition(PivotPosition.Left)
            .build();

    public static final QuickSortOptions DEFAULT_QUICK_SORT_CHARACTER = QuickSortOptions.builder()
            .dataType(SortDataType.Character)
            .arrayType(ArrayType.FullyRandom)
            .arraySizes(SORT_SIZES)
            .iterations(100)
            .pivotPosition(PivotPosition.Random)
            .build();

    public static final ShellSortOptions DEFAULT_SHELL_INTEGER = ShellSortOptions.builder()
            .dataType(SortDataType.Integer)
            .arrayType(ArrayType.FullyRandom)
            .arraySizes(SORT_SIZES)
            .iterations(100)
            .build();

    public static final ShellSortOptions DEFAULT_SHELL_CHARACTER = ShellSortOptions.builder()
            .dataType(SortDataType.Character)
            .arrayType(ArrayType.FullyRandom)
            .arraySizes(SORT_SIZES)
            .iterations(100)
            .build();


}
