
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author anhtung
 */
public class LMSProject {

    public static void main(String[] args) throws IOException {
        Authentication auth = new Authentication();
        Menus menus = new Menus();
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------------------------------------------");
        System.out.println("---Welcome to my Learning Management System---");
        System.out.println("----------------------------------------------");
        System.out.println();
        System.out.println("1. Login");
        System.out.println("2. Exit");

        while (true) {
            System.out.print("\nEnter your option: ");
            String opt = scanner.nextLine();
            switch (opt) {
                case "1":
                    if (auth.login() == true) {
                        menus.main_menu();
                    }
                    break;
                case "2":
                    System.exit(0);
                default:
                    System.out.println("\nInvalid input, try again\n");
            }

        }
    }
}
