
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anhtung
 */
public class Authentication {
        public boolean login() {
        try {
            //Change the file location relative to yours
            File loginInfo = new File("/Users/anhtung/Desktop/login.txt");
            
            Scanner scanner = new Scanner(System.in);
            
            String validUsername;
            String validPassword;
            
            try ( Scanner readInfo = new Scanner(loginInfo)) {
                
                validUsername = readInfo.nextLine();
                validPassword = readInfo.nextLine();
                
            }
            while (true) {
                
                System.out.println("Username: ");
                String username = scanner.nextLine();
                if (username.isBlank()) {
                    System.out.println("Username cannot be blank");
                    continue;
                }
                
                System.out.println("Password: ");
                String password = scanner.nextLine();
                if (password.isBlank()) {
                    System.out.println("Password cannot be blank");
                    continue;
                }
                
                if (username.equals(validUsername) && password.equals(validPassword)) {
                    break;
                } else {
                    System.out.println("\nInvalid password or username, try again");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
