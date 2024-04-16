package pl.pwr.ite.aizo.menu;

import pl.pwr.ite.aizo.Main;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printMainMenu() {
        while(true) {
            System.out.println("[1] Load data.");
            System.out.println("[2] Generate data.");
            System.out.println("[3] Sort.");
            System.out.println("[4] Exit.");

            switch (scanner.nextInt()) {
                case 1 -> LoadMenu.printLoadDataMenu();
                case 2 -> GenerateMenu.printGenerateMenu();
                default -> {
                    System.out.println("Unsupported operation.");
                    MainMenu.printMainMenu();
                }
            }
        }
    }


}
