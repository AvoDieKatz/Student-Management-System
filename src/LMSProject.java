
import DataTransferObjects.Student;
import DataTransferObjects.Course;
import DataAccessObjects.ICourse;
import DataAccessObjects.IStudent;
import DAOimplement.CourseFunc;
import DAOimplement.StudentFunc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author anhtung
 */
public class LMSProject {

    public static void main(String[] args) throws IOException {
        Menus menus = new Menus();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to my Learning Management System");
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
}

//    public static void menu() {
//        ICourse course = new CourseFunc();
//        IStudent student = new StudentFunc();
//        System.out.println("\nCURRENT DATA: (Students: " + student.checkSize()
//                + " | Courses:" + course.checkSize() + ")");
//        System.out.println();
//        System.out.println("1. Course Menu");
//        System.out.println("2. Student Menu");
//        System.out.println("3. Exit");
//    }
//
//    public static void student_menu() throws IOException {
//        while (true) {
//            System.out.println("\n\n\n-----------Student Menu-------------");
//            System.out.println("1. Add Student");
//            System.out.println("2. Delete Student");
//            System.out.println("3. Update Student");
//            System.out.println("4. Search Student");
//            System.out.println("5. View All Student");
//            System.out.println("6. Back");
//            System.out.println("Enter your option: ");
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            IStudent studentDao = new StudentFunc();
//            ICourse courseDao = new CourseFunc();
//            int choice = Integer.parseInt(br.readLine());
//
//            if (choice == 1) {
//                if (courseDao.checkEmpty() == false) {
//                    System.out.println("| Basic Information |");
//                    System.out.print("Enter student ID: ");
//                    int userID = Integer.parseInt(br.readLine());
//                    System.out.print("Enter name: ");
//                    String name = br.readLine();
//
//                    //Turn to DoB, calculate Age by getDate - DoB
//                    //Check Age validity age < 18 -> wut?
//                    System.out.print("Enter age: ");
//                    int age = Integer.parseInt(br.readLine());
//                    System.out.print("Enter address: ");
//                    String address = br.readLine();
//                    System.out.println();
//                    System.out.println();
//                    System.out.println("| Courses Option |");
//                    System.out.println("Choose one of the below course: ");
//
//                    //Display all available courses
//                    courseDao.allCourses();
//
//                    System.out.print("Enter your desired course's ID: ");
//                    Integer stuCourse = Integer.parseInt(br.readLine());
//
//                    //possibly make a student's list of courses attending
//                    //display all but minus chose options
//                    try {
//                        studentDao.addStudent(new Student(userID, name, age, address, courseDao.searchCourse(stuCourse - 1)));
//                    } catch (Exception e) {
//                        System.err.println("Uh ohh something wrong!\n");
//                    }
//                    System.out.println("Student Added Successfully");
//
//                } else {
//                    System.out.println("""
//                                       There are no course available at the moment :((((
//                                       Please return to previous Menu and Choose Add Course in Course Menu
//                                       """);
//                }
//
//            } else if (choice == 2) {
//                if (studentDao.checkEmpty() == false) {
//                    System.out.print("Enter student ID to DELETE: ");
//                    int userID = Integer.parseInt(br.readLine());
//                    try {
//                        studentDao.deleteStudent(userID);
//                    } catch (Exception e) {
//                        System.err.println("Uh ohh something wrong!\n");
//                    }
//
//                    System.out.println("Student Deleted Successfully");
//                } else {
//                    System.out.println("""
//                                       There are no Student available at the moment
//                                       please ADD Student first""");
//                }
//
//            } else if (choice == 3) {
//                if (studentDao.checkEmpty() == false) {
//                    System.out.print("Enter student ID to UPDATE:");
//                    int userID = Integer.parseInt(br.readLine());
//                    System.out.print("Enter name: ");
//                    String name = br.readLine();
//                    System.out.print("Enter age: ");
//                    int age = Integer.parseInt(br.readLine());
//                    System.out.print("Enter address: ");
//                    String address = br.readLine();
//                    System.out.print("Choose one of the below course: ");
//                    courseDao.allCourses();
//                    int course = Integer.parseInt(br.readLine());
//                    try {
//                        studentDao.editStudent(new Student(userID, name, age, address, courseDao.searchCourse(course)));
//                    } catch (Exception e) {
//                        System.out.println("Something wrong with your input");
//                    }
//                    System.out.println("Student info UPDATED");
//                } else {
//                    System.out.println("""
//                                       There are no student available in the database
//                                       Please ADD Student first""");
//                }
//
//            } else if (choice == 4) {
//                if (studentDao.checkEmpty() == false) {
//                    System.out.print("Enter Student ID to SEARCH: ");
//                    int userID = Integer.parseInt(br.readLine());
//                    try {
//                        System.out.println(studentDao.searchStudent(userID - 1));
//                    } catch (Exception e) {
//                        System.err.println("Something wrong with searchStudent");
//                    }
//                } else {
//                    System.out.println("""
//                                       There are no Student available in the database
//                                       Please ADD Student first""");
//                }
//
//            } else if (choice == 5) {
//                if (studentDao.checkEmpty() == false) {
//                    System.out.println("----------STUDENT LIST----------");
//                    studentDao.allStudents();
//                } else {
//                    System.out.println("----------STUDENT LIST----------");
//                    System.out.println("\tList empty\n");
////                    System.out.println("Do you want to add new Student? (Enter 'y' to add, any other keys to cancle)");
////                    String option = br.readLine().trim().toLowerCase();
////                    if (option.equals("y")) {
////                        studentDao.addSection();
////                    } else {
////                        student_menu();
////                    }
//
//                }
//
//            } else if (choice == 6) {
//                break;
//
//            } else {
//                System.out.println("Bruhhh");
//            }
//        }
//    }
//
//    public static void course_menu() throws IOException {
//        while (true) {
//            System.out.println("\n\n\n-----------Course Menu-------------");
//            System.out.println("1. Add Course");
//            System.out.println("2. Update Course");
//            System.out.println("3. Delete Course");
//            System.out.println("4. Search Course");
//            System.out.println("5. View All Course");
//            System.out.println("6. Back");
//            System.out.println("Enter your option:");
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            IStudent studentDao = new StudentFunc();
//            ICourse courseDao = new CourseFunc();
//            int choice = Integer.parseInt(br.readLine());
//
//            if (choice == 1) {
//                System.out.print("Enter Course ID: ");
//                int courseID = Integer.parseInt(br.readLine());
//                System.out.print("Enter Course Name: ");
//                String courseName = br.readLine();
//                System.out.print("Enter amount of Credits this course has: ");
//                int credits = Integer.parseInt(br.readLine());
//                try {
//                    courseDao.addCourse(new Course(courseID, courseName, credits));
//                } catch (Exception e) {
//                    System.err.println("Something wrong when adding Course");
//                }
//                System.out.println("Course ADDED succesfully");
//
//            } else if (choice == 2) {
//                if (courseDao.checkEmpty() == false) {
//                    System.out.print("Enter Course ID to UPDATE: ");
//                    int courseID = Integer.parseInt(br.readLine());
//                    System.out.print("Enter Course Name: ");
//                    String courseName = br.readLine();
//                    System.out.print("Enter amount of Credits this course has: ");
//                    int credits = Integer.parseInt(br.readLine());
//                    try {
//                        courseDao.editCourse(new Course(courseID, courseName, credits));
//
//                    } catch (Exception e) {
//                        System.err.println("Uh ohh something wrong!\n");
//                    }
//                    System.out.println("Course EDITED succesfully");
//                } else {
//                    System.out.println("""
//                                       There are no Course available at the moment
//                                       Please ADD course first""");
//                }
//
//            } else if (choice == 3) {
//                if (courseDao.checkEmpty() == false) {
//                    System.out.print("Enter Course ID to DELETE: ");
//                    int courseID = Integer.parseInt(br.readLine());
//                    try {
//                        courseDao.deleteCourse(courseID);
//
//                    } catch (Exception e) {
//                        System.err.println("Uh ohh something wrong!\n");
//                    }
//                    System.out.println("Course DELETED");
//                } else {
//                    System.out.println("""
//                                       There are no Course available at the moment
//                                       Please ADD course first""");
//                }
//
//            } else if (choice == 4) {
//                if (courseDao.checkEmpty() == false) {
//                    System.out.print("Enter Course ID to SEARCH: ");
//                    int courseID = Integer.parseInt(br.readLine());
//                    try {
//                        courseDao.searchCourse(courseID);
//                    } catch (Exception e) {
//                        System.err.println("Something wrong with searchCourse");
//                    }
//
//                } else {
//                    System.out.println("""
//                                       There are no Course available at the moment
//                                       Please ADD course first""");
//                }
//
//            } else if (choice == 5) {
//                if (courseDao.checkEmpty() == false) {
//                    System.out.println("----------COURSE LIST----------");
//                    try {
//                        courseDao.allCourses();
//                    } catch (Exception e) {
//                        System.err.println("Something wrong with View All Courses");
//                    }
//                } else {
//                    System.out.println("----------COURSE LIST----------");
//                    System.out.println("\tList Empty\n");
//                }
//
//            } else if (choice == 6) {
//                break;
//            } else {
//                System.out.println("Bruhhh");
//            }
//
//        }
//
//    }
//    public static void main(String[] args) throws IOException {
//        while (true) {
//            menu();
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            System.out.print("Enter your choice: ");
//            int choice = Integer.parseInt(br.readLine());
//            switch (choice) {
//                case 1:
//                    course_menu();
//                    break;
//                case 2:
//                    student_menu();
//                    break;
//                case 3:
//                    System.out.println("Exitting....");
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("Invalid input, try 1-3");
//                    break;
//            }
//        }
