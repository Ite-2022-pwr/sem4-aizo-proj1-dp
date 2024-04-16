package pl.pwr.ite.aizo.menu;

import pl.pwr.ite.aizo.Main;

import java.util.Scanner;

public class GenerateMenu {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printGenerateMenu() {
        System.out.println("[1] Load data.");
        System.out.println("[2] Generate data.");
        System.out.println("[3] Sort.");
        System.out.println("[4] Exit.");

        switch (scanner.nextInt()) {
            case 4 -> MainMenu.printMainMenu();
            default -> {
                System.out.println("Unsupported operation.");
                GenerateMenu.printGenerateMenu();
            }
        }
    }
}
