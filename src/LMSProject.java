
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author anhtung
 */
public class LMSProject {

    public static void main(String[] args) throws IOException {
        Menus menus = new Menus();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to my Learning Management System");
            System.out.println();
            System.out.println("1. Login");
            System.out.println("2. Exit");
            int opt = scanner.nextInt();
            switch (opt) {
                case 1:
                    if (menus.login() == true) {
                        while (true) {
                            menus.main_menu();
                            System.out.println("Enter your choice (Valid options: 1 -> 3)");
                            char choice = scanner.next().charAt(0);
                            switch (choice) {
                                case '1':
                                    menus.course_menu();
                                    break;
                                case '2':
                                    menus.student_menu();
                                    break;
                                case '3':
                                    System.out.println("Exitting...");
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("Invalid input, try 1->3");
                                    break;
                            }
                        }
                    }
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input, try 1,2");
                    break;
            }
        }
    }
}