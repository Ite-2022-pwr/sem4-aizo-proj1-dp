package pl.pwr.ite.aizo.menu;

import pl.pwr.ite.aizo.model.SortDataType;
import pl.pwr.ite.aizo.model.SortOptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.function.Consumer;

public class LoadMenu {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printLoadDataMenu(SortOptions sortOptions) {
        System.out.println("[1] Load int file.");
        System.out.println("[2] Load char file.");
        System.out.println("[3] Load double file.");
        System.out.println("[4] Back.");

        int option = scanner.nextInt();
        System.out.println("Absolute file path: ");
        String filePath = scanner.next();

        try {
            switch (option) {
                case 1 -> loadFromFile(filePath, sortOptions, SortDataType.Integer);
                case 2 -> loadFromFile(filePath, sortOptions, SortDataType.Character);
                case 3 -> loadFromFile(filePath, sortOptions, SortDataType.Double);
                case 4 -> MainMenu.printMainMenu();
                default -> {
                    System.out.println("Unsupported operation.");
                    LoadMenu.printLoadDataMenu(sortOptions);
                }
            }
        } catch (IOException ex) {
            LoadMenu.printLoadDataMenu(sortOptions);
        }
    }

    private static void loadFromFile(String path, SortOptions sortOptions, SortDataType dataType) throws IOException {
        try(var reader = new BufferedReader(new FileReader(path))) {

            var arraySize = Integer.valueOf(reader.readLine());
            sortOptions.setArraySizes(new int[] {arraySize} );

            String line;
            int i = 0;

            if(dataType.equals(SortDataType.Integer)) {
                sortOptions.setIntData(new int[arraySize]);
                sortOptions.setDataType(SortDataType.Integer);
            } else if(dataType.equals(SortDataType.Character)) {
                sortOptions.setCharData(new char[arraySize]);
                sortOptions.setDataType(SortDataType.Character);
            } else if(dataType.equals(SortDataType.Double)) {
                sortOptions.setDoubleData(new double[arraySize]);
                sortOptions.setDataType(SortDataType.Double);
            }

            while ((line = reader.readLine()) != null) {
                if(dataType.equals(SortDataType.Integer)) {
                    sortOptions.getIntData()[i] = Integer.parseInt(line);
                } else if(dataType.equals(SortDataType.Character)) {
                    sortOptions.getCharData()[i] = line.charAt(0);
                } else if(dataType.equals(SortDataType.Double)) {
                    sortOptions.getDoubleData()[i] = Double.parseDouble(line);
                }
                i++;
            }
        }
    }
}
