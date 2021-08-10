
import java.util.Scanner;

/**
 *
 * @author anhtung
 */
public class LMSProject {

    public static void menu() {
        System.out.println();
        System.out.println("1. Student Menu");
        System.out.println("2. Course Menu");
        System.out.println("3. Exit");
    }

    public static void student_menu() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n\n-----------Student Menu-------------");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. View All Student");
            System.out.println("6. Back");
            System.out.println("Enter your option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                try {
                    System.out.println("Enter student ID:");
                    int userID = sc.nextInt();
                    System.out.println("Enter name:");
                    String name = sc.next();
                    System.out.println("Enter age:");
                    int age = sc.nextInt();
                    System.out.println("Enter address:");
                    String address = sc.next();
                    IManage studentDao = new Admin();
                    studentDao.addStudent(new Student(userID, name, age, address));
                } catch (Exception e) {
                    System.out.println("Something wrong, please try again..\n");
                }

            } else if (choice == 2) {
                try {
                    System.out.println("Enter student ID to DELETE: ");
                    int userID = sc.nextInt();
                    IManage studentDao = new Admin();
                    studentDao.deleteStudent(userID);
                } catch (Exception e) {
                    System.out.println("Something wrong, please try again..\n");
                }

            } else if (choice == 3) {
                try {
                    System.out.println("Enter student ID to UPDATE:");
                    int userID = sc.nextInt();
                    System.out.println("Enter name:");
                    String name = sc.next();
                    System.out.println("Enter age:");
                    int age = sc.nextInt();
                    System.out.println("Enter address:");
                    String address = sc.next();
                    IManage studentDao = new Admin();
                    studentDao.editStudent(new Student(userID, name, age, address));
                    System.out.println("Student info UPDATED");
                } catch (Exception e) {
                    System.out.println("Something wrong, please try again..\n");
                }

            } else if (choice == 4) {
                try {
                    System.out.println("Enter Student ID to SEARCH: ");
                    int userID = sc.nextInt();
                    IManage studentDao = new Admin();
                    System.out.println(studentDao.searchStudent(userID - 1));
                } catch (Exception e) {
                    System.out.println("Something wrong, please try again..\n");
                }

            } else if (choice == 5) {
                try {
                    System.out.println("----------STUDENT LIST----------");
                    IManage studentDao = new Admin();
                    studentDao.allStudent();
                } catch (Exception e) {
                    System.out.println("Something wrong, please try again..\n");
                }
                
            } else if (choice == 6) {
                break;   
                
                
            } else {
                System.out.println("Bruhhh");
            }
        }
    }

    public static void course_menu() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("-----------Course Menu-------------");
            System.out.println("1. Add Course");
            System.out.println("2. Update Course");
            System.out.println("3. Delete Course");
            System.out.println("4. Search Course");
            System.out.println("5. Back");
            System.out.println("Enter your option:");
            int choice = sc.nextInt();

            if (choice == 1) {
                try {
                    System.out.println("Enter Course ID:");
                    Integer courseID = sc.nextInt();
                    System.out.println("Enter Course Name:");
                    String courseName = sc.next();
                    System.out.println("Enter amount of Credits this course has:");
                    int courseCredit = sc.nextInt();
                    IManage courseDao = new Admin();
                    courseDao.addCourse(new Course(courseID, courseName, courseCredit));
                    System.out.println("Course ADDED succesfully");
                } catch (Exception e) {
                    System.out.println("Something wrong, please try again..\n");
                }

            } else if (choice == 2) {
                try {
                    System.out.println("Enter Course ID to UPDATE:");
                    Integer courseID = sc.nextInt();
                    System.out.println("Enter Course Name:");
                    String courseName = sc.next();
                    System.out.println("Enter amount of Credits this course has:");
                    int courseCredit = sc.nextInt();
                    IManage courseDao = new Admin();
                    courseDao.editCourse(new Course(courseID, courseName, courseCredit));
                    System.out.println("Course EDITED succesfully");
                } catch (Exception e) {
                    System.out.println("Something wrong, please try again..\n");
                }

            } else if (choice == 3) {
                try {
                    System.out.println("Enter Course ID to DELETE:");
                    Integer courseID = sc.nextInt();
                    IManage courseDao = new Admin();
                    courseDao.deleteCourse(courseID);
                    System.out.println("Course DELETED");
                } catch (Exception e) {
                    System.out.println("Something wrong, please try again..\n");
                }

            } else if (choice == 4) {
                try {
                    System.out.println("Enter Course ID to SEARCH:");
                    Integer courseID = sc.nextInt();
                    IManage courseDao = new Admin();
                    courseDao.searchCourse(courseID);
                    
                } catch (Exception e) {
                    System.out.println("Something wrong, please try again..\n");
                }

            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Bruhhh");
            }

        }

    }

    public static void main(String[] args) {
        System.out.println("Welcome to my simple Learning Management System");
        while (true) {
            menu();
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter your choice:");
            int choice = reader.nextInt();
            switch (choice) {
                case 1:
                    student_menu();
                    break;
                case 2:
                    course_menu();
                    break;
                case 3:
                    System.out.println("Exitting....");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Dumb");
                    break;
            }
        }
    }
}
