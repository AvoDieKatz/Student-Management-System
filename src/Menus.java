
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import DAOimplement.*;
import DataAccessObjects.*;
import DataTransferObjects.*;

/**
 *
 * @author anhtung
 */
public class Menus {

    CourseFactory courseFactory = new CourseFactory();
    Scanner scanner = new Scanner(System.in);
    IStudent studentDao = new StudentFunc();
    ICourse courseDao = new CourseFunc();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //MENUS 
    public void main_menu() throws IOException {
        while (true) {
            System.out.println("--------MAIN MENU--------");
            System.out.println("CURRENT DATA: (Students: " + studentDao.checkSize()
                    + " | Courses: 3)");
            System.out.println();
            System.out.println("1. Course Menu");
            System.out.println("2. Student Menu");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    course_menu();
                    break;
                case "2":
                    student_menu();
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println("Invalid input, try 1-3");
            }
        }
    }

    public void course_menu() throws IOException {
        OUTER:
        while (true) {
            Course_Section course_Section = new Course_Section();
            System.out.println("1. View Current Courses");
            System.out.println("2. Edit Course");
            System.out.println("3. Back");
            String choice = br.readLine();
            switch (choice) {
                case "1":
                    course_Section.viewAll();
                    break;
                case "2":
                    course_Section.edit();

                case "3":
                    break OUTER;
                default:
                    System.out.println("Invalid input, try 1->3");
                    break;
            }
        }
    }

    class Course_Section {

        void viewAll() {
            courseDao.allCourses();
        }
        
        void edit() {
            System.out.println("Enter the course ID to update");
        }
    }

    public void student_menu() throws IOException {
        OUTER:
        while (true) {
            System.out.println("\n\n-----------Student Menu-------------");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Search Student");
            System.out.println("4. View All Student");
            System.out.println("5. Back");
            System.out.println("Enter your option: ");
            Student_Section student_Section = new Student_Section();
            String choice = br.readLine();
            if (null == choice) {
                System.out.println("Invalid input, try 1->6");
            } else {
                switch (choice) {
                    case "1" ->
                        student_Section.add();
                    case "2" ->
                        student_Section.edit();
                    case "3" ->
                        student_Section.search();
                    case "4" ->
                        student_Section.viewAll();
                    case "5" -> {
                        break OUTER;
                    }
                    default ->
                        System.out.println("Invalid input, try 1->5");
                }
            }
        }
    }

    class Student_Section {

        void add() throws IOException {
            System.out.println("| Basic Information |");
            int userID = 0;
            while (true) {
                System.out.print("Enter Student ID: ");
                userID = Integer.parseInt(br.readLine());
                if (studentDao.checkStudentExist(userID) == false) {
                    break;
                } else {
                    System.out.println("Student ID is duplicated, try again");
                }
            }
            System.out.print("Enter name: ");
            String name = br.readLine();
            System.out.print("Enter age: ");
            int age = Integer.parseInt(br.readLine());
            System.out.print("Enter address: ");
            String address = br.readLine();
            System.out.print("Enter initial fee: ");
            int initialFee = Integer.parseInt(br.readLine());
            System.out.println();
            System.out.println("| Courses Option |");
            System.out.println("Choose one of the below course:\n");
            courseDao.allCourses();

            //field to store Course variable get from Factory
            Course studentCourse = null;

            while (true) {
                System.out.println("Enter the ID of the course you want: ");
                if (scanner.hasNextLine()) {
                    String optionOfCourse = scanner.nextLine().toUpperCase();

                    studentCourse = courseFactory.makeCourse(optionOfCourse);

                }

                if (studentCourse != null) {
                    break;
                } else {
                    System.out.println("Valid course ID next time");
                }

            }

            //Put everything to Student
            try {
                studentDao.addStudent(new Student(userID, name, age, address, initialFee, studentCourse));
                System.out.println("Student Added Successfully");
            } catch (Exception e) {
                System.err.println("Uh ohh! Somehing wrong while adding student\n");
                System.err.print(e);
            }
        }

        void edit() throws IOException {
            if (studentDao.checkEmpty() == false) {

                //Check for ID existance
                int userID = 0;
                while (true) {
                    System.out.print("Enter student ID to UPDATE:");
                    userID = Integer.parseInt(br.readLine());
                    if (studentDao.checkStudentExist(userID) == true) {
                        break;
                    } else {
                        System.out.println("The student you are trying to edit does not present in the data");
                    }
                }
                System.out.println("Modifying Student: " + userID);
                System.out.println("1. Update personal's information");
                System.out.println("2. Update marks");
                System.out.println("3. Delete");
                System.out.println("4. Back");
                int choice = Integer.parseInt(br.readLine()); //readline().matches(regex));
                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = br.readLine();
                        System.out.print("Enter age: ");
                        int age = Integer.parseInt(br.readLine());
                        System.out.print("Enter address: ");
                        String address = br.readLine();
                        System.out.print("Enter initial fee: ");
                        int initialFee = Integer.parseInt(br.readLine());
                        System.out.print("Choose one of the below course: ");
                        courseDao.allCourses();

                        Course studentCourse = null;

                        while (true) {
                            System.out.println("Enter the ID of the course you want: ");
                            if (scanner.hasNextLine()) {
                                String optionOfCourse = scanner.nextLine().toUpperCase();

                                studentCourse = courseFactory.makeCourse(optionOfCourse);

                            }

                            if (studentCourse != null) {
                                break;
                            } else {
                                System.out.println("Valid course ID next time");
                            }

                        }

                        try {
                            studentDao.editStudent(new Student(userID, name, age, address, initialFee, studentCourse));
                            System.out.println("StudentID: " + userID + " has been UPDATED");
                        } catch (Exception e) {
                            System.err.println("Uh ohh! Something wrong while editing student!\n");
                        }
                        break;
                    case 2:
                        System.out.println("Developing");
                        break;
                    case 3:
                        delete();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Invalid input, try again");
                        break;
                }
            } else {
                System.out.println("""
                                       There are no student available in the database
                                       Please ADD Student first""");
            }
        }

        void delete() throws IOException {
            if (studentDao.checkEmpty() == false) {
                int userID = 0;
                while (true) {
                    System.out.print("Enter student ID to DELETE: ");
                    userID = Integer.parseInt(br.readLine());
                    if (studentDao.checkStudentExist(userID) == true) {
                        break;
                    } else {
                        System.out.println("The student you are trying to delete does not present in the data");
                    }
                }
                try {
                    studentDao.deleteStudent(userID);
                    System.out.println("StudentID: " + userID + " has been DELETED");
                } catch (Exception e) {
                    System.err.println("Uh ohh! Something wrong while deleting student!\n");
                }
            } else {
                System.out.println("""
                                       There are no Student available at the moment
                                       please ADD Student first""");
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
                    System.out.println("NO RESULT");
                    System.out.println("Do you want to Add Student? (type 'y' to add student), any other key to continue");
                    String opt = br.readLine().toLowerCase();
                    if ("y".equals(opt)) {
                        add();
                    }
                }
            } else {
                System.out.println("""
                                       There are no Student available in the database
                                       Please ADD Student first""");
            }
        }

        void viewAll() throws IOException {
            if (studentDao.checkEmpty() == false) {
                System.out.println("----------STUDENT LIST----------");
                try {
                    studentDao.allStudents();
                } catch (Exception e) {
                    System.err.println("Uh ohh! Something wrong while displaying all students\n");
                }
            } else {
                System.out.println("----------STUDENT LIST----------");
                System.out.println("\tList empty\n");
                System.out.println("Do you want to Add Course? (type 'y' to add student), any other key to continue");
                String opt = br.readLine().toLowerCase();
                if ("y".equals(opt)) {
                    add();
                }
            }
        }
    }
}
