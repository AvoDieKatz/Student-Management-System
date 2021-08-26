
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import DAOimplement.*;
import DataAccessObjects.*;
import DataTransferObjects.*;
import regex.Regex;

/**
 *
 * @author anhtung
 */
public class Menus {

    CourseFactory courseFactory = new CourseFactory();
    Scanner scanner = new Scanner(System.in);
    IStudent studentDao = new StudentFunc();
    ICourse courseDao = new CourseFunc();
    Regex rx = new Regex();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //MENUS 
    public void main_menu() throws IOException {
        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("--------------------MAIN MENU---------------------");
            System.out.println("--------------------------------------------------");
            System.out.println("CURRENT DATA: (Students: " + studentDao.checkSize()
                    + " | Courses: 3)");
            System.out.println();
            System.out.println("1. Student management");
            System.out.println("2. View available courses");
            System.out.println("3. Export Student Information");
            System.out.println("4. Exit");
            System.out.print("\nChoose your choice: \n");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    student_menu();
                    break;
                case "2":
                    courseDao.allCourses();
                    break;
                case "3":
                    System.out.println("Developing");
                    break;
                case "4":
                    System.exit(0);
                default:
                    System.out.println("\nInvalid input, try 1->3\n");
            }
        }
    }

    public void student_menu() throws IOException {
        OUTER:
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------------------");
            System.out.println("-------------------STUDENT MENU-------------------");
            System.out.println("--------------------------------------------------");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Search Student");
            System.out.println("4. View All Student");
            System.out.println("5. Back");
            System.out.print("\nChoose your option: \n");
            Student_Section student_section = new Student_Section();
            String choice = br.readLine();
            if (null == choice) {
                System.out.println("\nInvalid input, try 1->5\n");
            } else {
                switch (choice) {
                    case "1" ->
                        student_section.add();
                    case "2" ->
                        student_section.edit();
                    case "3" ->
                        student_section.search();
                    case "4" ->
                        student_section.viewAll();
                    case "5" -> {
                        break OUTER;
                    }
                    default ->
                        System.out.println("\nInvalid input, try 1->5\n");
                }
            }
        }
    }

    class Student_Section {

        void add() throws IOException {
            String input;
            String cancle = "!cancle";

            int userID = 0;
            String name = null;
            int age = 0;
            String address = null;
            int initialFee = 0;

            OUT:
            while (true) {

                System.out.println("| Personal Information |");

                //Taking ID
                while (true) {
                    System.out.print("Enter Student ID: ");
                    input = br.readLine();
                    if ((rx.validateNumberInput(input)) && (!input.equals(cancle))) {
                        userID = Integer.parseInt(input);
                        if (studentDao.checkStudentExist(userID) == false) {
                            break;
                        } else {
                            System.out.println("Student ID is duplicated, try again");
                        }
                    } else if (input.equals(cancle)) {
                        break OUT;
                    } else {
                        System.out.println("Make sure 'ID' only contain numbers");
                    }

                }

                //Taking Name
                while (true) {
                    System.out.print("Enter name: ");
                    name = br.readLine();
                    if ((rx.validateNameInput(name)) && (!name.equals(cancle))) {
                        break;
                    } else if (name.equals(cancle)) {
                        break OUT;
                    } else {
                        System.out.println("Is Elon Musk your father?");
                    }
                }

                //Taking Age
                while (true) {
                    System.out.print("Enter age: ");
                    input = br.readLine();
                    if ((rx.validateNumberInput(input)) && (!input.equals(cancle))) {
                        age = Integer.parseInt(input);
                        if ((16 <= age) & (age <= 60)) {
                            break;
                        } else {
                            System.out.println("Invalid age, the valid age range from 16-60, try again");
                        }
                    } else if (input.equals(cancle)) {
                        break OUT;
                    } else {
                        System.out.println("Make sure 'Age' only contain numbers");
                    }
                }

                //Taking address
                while (true) {
                    System.out.print("Enter address: ");
                    String input_address = br.readLine();
                    if ((rx.validateAddressInput(input_address)) && (!input_address.equals(cancle))) {
                        String input_address_cap = input_address.substring(0, 1).toUpperCase();
                        address = input_address_cap + input_address.substring(1);
                        break;
                    } else if (input_address.equals(cancle)) {
                        break OUT;
                    } else {
                        System.out.println("Sound like not an address...");
                    }
                }

                //Taking Initial Fee
                while (true) {
                    System.out.print("Enter initial fee (USD): ");
                    input = br.readLine();
                    if ((rx.validateNumberInput(input)) && (!input.equals(cancle))) {
                        initialFee = Integer.parseInt(input);
                        break;
                    } else if (input.equals(cancle)) {
                        break OUT;
                    } else {
                        System.out.println("Make sure 'Initial Fee' only contain number");
                    }
                }

                //Taking Course Information
                System.out.println();
                System.out.println("| Courses Option |");
                System.out.println("Choose one of the below course:\n");
                courseDao.allCourses();

                //field to store Course variable get from Factory
                Course studentCourse = null;

                while (true) {
                    System.out.println();
                    System.out.print("Enter the ID of the course you want: ");
                    if (scanner.hasNextLine()) {
                        String optionOfCourse = scanner.nextLine().toUpperCase();

                        studentCourse = courseFactory.makeCourse(optionOfCourse);

                    }

                    if (studentCourse != null) {
                        break;
                    } else {
                        System.out.println("\nInvalid course ID, try wd / cs / sc");
                    }

                }

                //Put everything to Student
                try {
                    studentDao.addStudent(new Student(userID, name, age, address, initialFee, studentCourse));
                    System.out.println("!!! Student Added Successfully !!!");
                    break OUT;
                } catch (Exception e) {
                    System.err.println("Uh ohh! Somehing wrong while adding student\n");
                    System.err.print(e);
                }
            }

        }

        void edit() throws IOException {
            String input;
            String cancle = "!cancle";

            int userID = 0;
            String name = null;
            int age = 0;
            String address = null;
            int initialFee = 0;

            //While loop to !cancle while choosing ID to edit
            
            
            //Check if Student List empty?
            if (studentDao.checkEmpty() == false) {

                //Check for ID existance
                System.out.print("Enter student ID to UPDATE: ");
                input = br.readLine();
                
                if (rx.validateNumberInput(input)) {
                    userID = Integer.parseInt(input);
                    if (studentDao.checkStudentExist(userID) == true) {
                        
                    } else {
                        System.out.println("The student you are trying to edit does not present in the data");
                    }
                } else {
                    System.out.println("'ID' can only have numbers, try again");
                }

                OUT:
                while (true) {
                    System.out.println();
                    System.out.println("--------------------------------------");
                    System.out.println("| Modifying Student ID " + userID+ " |");
                    System.out.println("--------------------------------------");
                    System.out.println("1. Update personal's information");
                    System.out.println("2. Update marks");
                    System.out.println("3. Delete");
                    System.out.println("4. Back");
                    System.out.print("\nChoose your option: \n");
                    String choice = scanner.nextLine(); //readline().matches(regex));
                    OUTER:
                    switch (choice) {
                        case "1":

                            //Taking Name
                            while (true) {
                                System.out.print("Enter name: ");
                                name = br.readLine();
                                if ((rx.validateNameInput(name)) && (!name.equals(cancle))) {
                                    break;
                                } else if (name.equals(cancle)) {
                                    break OUTER;
                                } else {
                                    System.out.println("Is Elon Musk your father?");
                                }
                            }

                            //Taking Age
                            while (true) {
                                System.out.print("Enter age: ");
                                input = br.readLine();
                                if ((rx.validateNumberInput(input)) && (!input.equals(cancle))) {
                                    age = Integer.parseInt(input);
                                    if ((16 <= age) & (age <= 60)) {
                                        break;
                                    } else {
                                        System.out.println("Invalid age, the valid age range from 16-60, try again");
                                    }
                                } else if (input.equals(cancle)) {
                                    break OUTER;
                                } else {
                                    System.out.println("Make sure 'Age' only contain numbers");
                                }
                            }

                            //Taking address
                            while (true) {
                                System.out.print("Enter address: ");
                                String input_address = br.readLine();
                                if ((rx.validateAddressInput(input_address)) && (!input_address.equals(cancle))) {
                                    String input_address_cap = input_address.substring(0, 1).toUpperCase();
                                    address = input_address_cap + input_address.substring(1);
                                    break;
                                } else if (input_address.equals(cancle)) {
                                    break OUTER;
                                } else {
                                    System.out.println("Sound not like an address...");
                                }
                            }

                            //Taking Initial Fee
                            while (true) {
                                System.out.print("Enter initial fee (USD): ");
                                input = br.readLine();
                                if ((rx.validateNumberInput(input)) && (!input.equals(cancle))) {
                                    initialFee = Integer.parseInt(input);
                                    break;
                                } else if (input.equals(cancle)) {
                                    break OUTER;
                                } else {
                                    System.out.println("Make sure 'Initial Fee' only contain number");
                                }
                            }

                            //Taking Course Information
                            System.out.println();
                            System.out.println("| Courses Option |");
                            System.out.println("Choose one of the below course:\n");
                            courseDao.allCourses();

                            //field to store Course variable get from Factory
                            Course studentCourse = null;

                            while (true) {
                                System.out.println();
                                System.out.print("Enter the ID of the course you want: ");
                                if (scanner.hasNextLine()) {
                                    String optionOfCourse = scanner.nextLine().toUpperCase();

                                    studentCourse = courseFactory.makeCourse(optionOfCourse);

                                }

                                if (studentCourse != null) {
                                    break;
                                } else {
                                    System.out.println("\nInvalid course ID, try wd / cs / sc");
                                }

                            }

                            try {
                                studentDao.editStudent(new Student(userID, name, age, address, initialFee, studentCourse));
                                System.out.println("!!! StudentID: " + userID + " has been UPDATED !!!");
                            } catch (Exception e) {
                                System.err.println("Uh ohh! Something wrong while editing student!\n");
                            }
                            break;
                        case "2":
                            System.out.println("Developing");
                            break;
                        case "3":
                            studentDao.deleteStudent(userID);
                            System.out.println("!!! Student ID " + userID + " DELETED !!!");
                            break;
                        case "4":
                            break OUT;
                        default:
                            System.out.println("\nInvalid input, try again");
                            break;
                    }
                }

            } else {
                System.out.println("""
                                       There are no student available in the database
                                       Please ADD Student first""");
            }
        }

        void search() throws IOException {
            if (studentDao.checkEmpty() == false) {
                System.out.print("Enter Student ID to SEARCH: ");
                int userID = Integer.parseInt(br.readLine());
                if (studentDao.checkStudentExist(userID) == true) {
                    try {
                        studentDao.searchStudent(userID);
                    } catch (Exception e) {
                        System.err.println("Uh ohh! Something wrong while searching student\n");;
                    }
                } else {
                    System.out.println("\tNO RESULT\n");
                    System.out.println("Do you want to Add Student? ('y' to add student, 'n' to cancle)");
                    while (true) {
                        String opt = br.readLine().toUpperCase();
                        if ("Y".equals(opt)) {
                            add();
                        } else if ("N".equals(opt)) {
                            break;
                        } else {
                            System.out.println("\nI don't understand that, try again.");
                        }
                    }
                }
            } else {
                System.out.println("""
                                       There are no Student available in the database
                                       Please ADD Student first""");
            }
        }

        void viewAll() throws IOException {
            System.out.println("†------------------STUDENT LIST-----------------†");
            if (studentDao.checkEmpty() == false) {
                try {
                    studentDao.allStudents();
                } catch (Exception e) {
                    System.err.println("Uh ohh! Something wrong while displaying all students\n");
                }
            } else {
                System.out.println("\tList empty\n");
                System.out.println("Do you want to Add Student? ('y' to add student, 'n' to cancle)");
                while (true) {
                    String opt = br.readLine().toUpperCase();
                    if ("Y".equals(opt)) {
                        add();
                    } else if ("N".equals(opt)) {
                        break;
                    } else {
                        System.out.println("\nI don't understand that, try again.");
                    }
                }
            }
            System.out.println("†-----------------------------------------------†");
        }
    }
}
