package pl.pwr.ite.aizo.menu;

import java.util.Scanner;

public class LoadMenu {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printLoadDataMenu() {
        System.out.println("[1] Load int file.");
        System.out.println("[2] Load char file.");
        System.out.println("[3] Load double file.");
        System.out.println("[4] Back.");

        int option = scanner.nextInt();
        String filePath = scanner.next();

        switch (option) {
//            case 1 -> ;
//            case 2 -> ;
//            case 3 -> ;
            case 4 -> MainMenu.printMainMenu();
            default -> {
                System.out.println("Unsupported operation.");
                MainMenu.printMainMenu();
            }
        }
    }
}
