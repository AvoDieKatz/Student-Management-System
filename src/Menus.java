
import DAOimplement.CourseFunc;
import DAOimplement.StudentFunc;
import DataAccessObjects.ICourse;
import DataAccessObjects.IStudent;
import DataTransferObjects.Course;
import DataTransferObjects.Student;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author anhtung
 */
public class Menus {

    Scanner scanner = new Scanner(System.in);
    ICourse courseDao = new CourseFunc();
    IStudent studentDao = new StudentFunc();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //MENUS Interface
    public void main_menu() throws IOException {
        while (true) {
            System.out.println("--------MAIN MENU--------");
            System.out.println("CURRENT DATA: (Students: " + studentDao.checkSize()
                    + " | Courses: " + courseDao.checkSize() + ")");
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
            System.out.println("\n\n-----------Course Menu-------------");
            System.out.println("1. Add Course");
            System.out.println("2. Update Course");
            System.out.println("3. Delete Course");
            System.out.println("4. Search Course");
            System.out.println("5. View All Course");
            System.out.println("6. Back");
            System.out.println("Enter your option:");
            Course_Section course_Section = new Course_Section();
            String choice = br.readLine();
            if (null == choice) {
                System.out.println("Invalid input, try 1->6");
            } else {
                switch (choice) {
                    case "1" ->
                        course_Section.add();
                    case "2" ->
                        course_Section.edit();
                    case "3" ->
                        course_Section.delete();
                    case "4" ->
                        course_Section.search();
                    case "5" ->
                        course_Section.viewAll();
                    case "6" -> {
                        break OUTER;
                    }
                    default ->
                        System.out.println("Invalid input, try 1->6");
                }
            }
        }
    }

    public void student_menu() throws IOException {
        OUTER:
        while (true) {
            System.out.println("\n\n-----------Student Menu-------------");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. View All Student");
            System.out.println("6. Back");
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
                        student_Section.delete();
                    case "4" ->
                        student_Section.search();
                    case "5" ->
                        student_Section.viewAll();
                    case "6" -> {
                        break OUTER;
                    }
                    default ->
                        System.out.println("Invalid input, try 1->6");
                }
            }
        }
    }

    //IMPLEMENTATION FOR COURSE/STUDENT SECTION
    class Course_Section {

        void add() throws IOException {
            int courseID = 0;
            while (true) {
                System.out.print("Enter Course ID: ");
                courseID = Integer.parseInt(br.readLine());
                if (courseDao.checkCourseExist(courseID) == false) {
                    break;
                } else {
                    System.out.println("Course ID is duplicated, try again");
                }
            }
            System.out.print("Enter Course Name: ");
            String courseName = br.readLine().toUpperCase();
            System.out.print("Enter amount of Credits this course has: ");
            int credits = Integer.parseInt(br.readLine());
            try {
                courseDao.addCourse(new Course(courseID, courseName, credits));
                System.out.println("Course ADDED succesfully");
            } catch (Exception e) {
                System.err.println("Uh ohh! Something wrong while adding course!\n");
            }
        }

        void edit() throws IOException {
            if (courseDao.checkEmpty() == false) {
                Integer courseID = 0;
                while (true) {
                    System.out.print("Enter Course ID to UPDATE: ");
                    courseID = Integer.parseInt(br.readLine());

                    if (courseDao.checkCourseExist(courseID) == true) {
                        break;
                    } else {
                        System.out.println("The course you are trying to update does not present in the data");
//                        System.out.println("Try another one or type '!cancle' to get back to the menu.");
//                        String cancle = br.readLine();
//                        if ("!cancle".equals(cancle)) {
//                            break;
//                        }
                    }
                }
                System.out.print("Enter Course Name: ");
                String courseName = br.readLine().toUpperCase();
                System.out.print("Enter amount of Credits this course has: ");
                int credits = Integer.parseInt(br.readLine());
                try {
                    courseDao.editCourse(new Course(courseID, courseName, credits));
                    System.out.println("CourseID: " + courseID + " has been UPDATED");
                } catch (Exception e) {
                    System.err.println("Uh ohh! Something wrong while editing course!\n");
                }
            } else {
                System.out.println("""
                                       There are no Course available at the moment
                                       Please ADD course first""");
            }
        }

        void delete() throws IOException {
            if (courseDao.checkEmpty() == false) {
                int courseID = 0;
                while (true) {
                    System.out.print("Enter Course ID to DELETE: ");
                    courseID = Integer.parseInt(br.readLine());
                    if (courseDao.checkCourseExist(courseID) == true) {
                        break;
                    } else {
                        System.out.println("The course you are trying to delete for does not present in the data");
                    }
                }
                try {
                    courseDao.deleteCourse(courseID);
                    System.out.println("CourseID: " + courseID + " has been DELETED");
                } catch (Exception e) {
                    System.err.println("Uh ohh! Something wrong while deleting course!\n");
                }
            } else {
                System.out.println("""
                                   There are no Course available at the moment
                                   Please ADD course first""");
            }
        }

        void search() throws IOException {
            if (courseDao.checkEmpty() == false) {
                System.out.print("Enter Course ID to SEARCH: ");
                int courseID = Integer.parseInt(br.readLine());
                if (courseDao.checkCourseExist(courseID) == true) {
                    try {
                        courseDao.searchCourse(courseID);
                    } catch (Exception e) {
                        System.err.println("Uh ohh! Something wrong while searching for student\n");
                    }
                } else {
                    System.out.println("NO RESULT");
                    System.out.println("Do you want to Add Course? (type 'y' to add student), any other key to continue");
                    String opt = br.readLine().toLowerCase();
                    if ("y".equals(opt)) {
                        add();
                    }
                }
            } else {
                System.out.println("""
                                       There are no Course available at the moment
                                       Please ADD course first""");
            }
        }

        void viewAll() {
            if (courseDao.checkEmpty() == false) {
                System.out.println("----------COURSE LIST----------");
                try {
                    courseDao.allCourses();
                } catch (Exception e) {
                    System.err.println("Uh ohh! Something wrong while displaying all courses!\n");
                }
            } else {
                System.out.println("----------COURSE LIST----------");
                System.out.println("\t\tList Empty\n");
            }
        }
    }

    class Student_Section {

        void add() throws IOException {
            if (courseDao.checkEmpty() == false) {
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

                //Turn to DoB, calculate Age by getDate - DoB
                //Check Age validity age < 18 -> wut?
                System.out.print("Enter age: ");
                int age = Integer.parseInt(br.readLine());
                System.out.print("Enter address: ");
                String address = br.readLine();
                System.out.println("Enter initial fee: ");
                int initialFee = Integer.parseInt(br.readLine());
                System.out.println();
                System.out.println();
                System.out.println("| Courses Option |");
                System.out.println("Choose one of the below course: ");

                //Display all available courses
                courseDao.allCourses();
                Integer studentCourseOption = null;
                while (true) {
                    System.out.print("Enter your desired course's ID: ");
                    studentCourseOption = Integer.parseInt(br.readLine());
                    if (courseDao.checkCourseExist(studentCourseOption) == true) {
                        break;
                    } else {
                        System.out.println("Please choose course within the above list");
                    }
                }
                //possibly make a student's list of courses attending
                //display all but minus chose options
                try {
                    studentDao.addStudent(new Student(userID, name, age, address, initialFee, courseDao.searchCourse(studentCourseOption)));
                    System.out.println("Student Added Successfully");
                } catch (Exception e) {
                    System.err.println("Uh ohh! Somehing wrong while adding student\n");
                    System.err.print(e);
                }

            } else {
                System.out.println("""
                                       There are no course available at the moment :((((
                                       Please return to previous Menu and Choose Add Course in Course Menu
                                       """);
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
                        System.out.println("Enter initial fee: ");
                        int initialFee = Integer.parseInt(br.readLine());
                        System.out.print("Choose one of the below course: ");
                        courseDao.allCourses();
                        int course = Integer.parseInt(br.readLine());
                        try {
                            studentDao.editStudent(new Student(userID, name, age, address, initialFee, courseDao.searchCourse(course)));
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
//                System.out.print("Enter name: ");
//                String name = br.readLine();
//                System.out.print("Enter age: ");
//                int age = Integer.parseInt(br.readLine());
//                System.out.print("Enter address: ");
//                String address = br.readLine();
//                System.out.print("Choose one of the below course: ");
//                courseDao.allCourses();
//                int course = Integer.parseInt(br.readLine());
//                try {
//                    studentDao.editStudent(new Student(userID, name, age, address, courseDao.searchCourse(course)));
//                    System.out.println("StudentID: " + userID + " has been UPDATED");
//                } catch (Exception e) {
//                    System.err.println("Uh ohh! Something wrong while editing student!\n");
//                }
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
//                    System.out.println("Do you want to add new Student? (Enter 'y' to add, any other keys to cancle)");
//                    String option = br.readLine().trim().toLowerCase();
//                    if (option.equals("y")) {
//                        studentDao.addSection();
//                    } else {
//                        student_menu();
//                    }
            }
        }
    }
}
