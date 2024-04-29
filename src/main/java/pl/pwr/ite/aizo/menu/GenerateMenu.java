package pl.pwr.ite.aizo.menu;

import pl.pwr.ite.aizo.Main;
import pl.pwr.ite.aizo.model.SortDataType;
import pl.pwr.ite.aizo.model.SortOptions;
import pl.pwr.ite.aizo.service.Generator;

import java.util.Scanner;

public class GenerateMenu {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Generator generator = new Generator();

    public static void printGenerateMenu(SortOptions sortOptions) {
        System.out.println("\n");
        System.out.println("[1] Generate int array.");
        System.out.println("[2] Generate char array.");
        System.out.println("[3] Generate double array.");
        System.out.println("[4] Load data.");

        int index = scanner.nextInt();

        System.out.println("Array size: ");
        int arraySize = scanner.nextInt();
        sortOptions.setArraySizes(new int[] {arraySize} );

        switch (index) {
            case 1 -> {
                sortOptions.setDataType(SortDataType.Integer);
                sortOptions.setIntData(generator.generateInts(arraySize));
                System.out.printf("Array of %s integers generated.%n", arraySize);
            }
            case 2 -> {
                sortOptions.setDataType(SortDataType.Character);
                sortOptions.setCharData(generator.generateChars(arraySize));
                System.out.printf("Array of %s characters generated.%n", arraySize);
            }
            case 3 -> {
                sortOptions.setDataType(SortDataType.Double);
                sortOptions.setDoubleData(generator.generateDoubles(arraySize));
                System.out.printf("Array of %s doubles generated.%n", arraySize);
            }
            case 4 -> MainMenu.printMainMenu();
            default -> {
                System.out.println("Unsupported operation.");
                GenerateMenu.printGenerateMenu(sortOptions);
            }
        }
    }
}
