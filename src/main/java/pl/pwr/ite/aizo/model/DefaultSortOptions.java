package pl.pwr.ite.aizo.model;

public class DefaultSortOptions {

    private static final int[] SORT_SIZES = { 10_000, 20_000, 40_000, 80_000, 160_000, 320_000, 640_000 };

    public static final SortOptions DEFAULT_INTEGER = SortOptions.builder()
            .dataType(SortDataType.Integer)
            .arraySizes(SORT_SIZES)
            .iterations(100)
            .build();

    public static final QuickSortOptions DEFAULT_QUICK_SORT_INTEGER = QuickSortOptions.builder()
            .dataType(SortDataType.Integer)
            .arraySizes(SORT_SIZES)
            .iterations(100)
            .pivotPosition(PivotPosition.Left)
            .build();

    public static final ShellSortOptions DEFAULT_SHELL_INTEGER = ShellSortOptions.builder()
            .dataType(SortDataType.Integer)
            .arraySizes(SORT_SIZES)
            .iterations(100)
            .gap(5)
            .build();
}
