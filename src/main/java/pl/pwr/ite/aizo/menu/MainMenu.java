package pl.pwr.ite.aizo.menu;

import pl.pwr.ite.aizo.model.ArrayType;
import pl.pwr.ite.aizo.model.SortOptions;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MainMenu {

    private static final Scanner scanner = new Scanner(System.in);
    private static final SortOptions sortOptions = SortOptions.builder()
            .arrayType(ArrayType.FullyRandom)
            .iterations(1)
            .build();

    public static void printMainMenu() {
        while(true) {
            System.out.println("\n");
            printCurrentArray(sortOptions);
            System.out.println("[1] Load data.");
            System.out.println("[2] Generate data.");
            System.out.println("[3] Sort.");
            System.out.println("[4] Exit.");

            switch (scanner.nextInt()) {
                case 1 -> LoadMenu.printLoadDataMenu(sortOptions);
                case 2 -> GenerateMenu.printGenerateMenu(sortOptions);
                case 3 -> SortMenu.printSortMenu(sortOptions);
                case 4 -> {
                    return;
                }
                default -> {
                    System.out.println("Unsupported operation.");
                    MainMenu.printMainMenu();
                }
            }
        }
    }

    public static void printCurrentArray(SortOptions sortOptions) {
        if(
                (sortOptions.getIntData() == null || sortOptions.getIntData().length == 0)
                        && (sortOptions.getCharData() == null || sortOptions.getCharData().length == 0)
                        && (sortOptions.getDoubleData() == null || sortOptions.getDoubleData().length == 0)
        ) {
            System.out.println("No array provided.");
            return;
        }
        System.out.println("Currently loaded array: " + sortOptions.getArraySizes()[0] + " " + sortOptions.getDataType());
    }

}
