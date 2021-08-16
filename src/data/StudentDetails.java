package data;


import DataTransferObjects.Student;
import DataTransferObjects.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.ListIterator;

/**
 *
 * @author anhtung
 */
public class StudentDetails {

    private static StudentDetails studentDetails = null;
    List<Student> studentList;
    List<Course> studentCourses;
    
    private StudentDetails() {
        studentList = new ArrayList<>();
        studentCourses = new ArrayList<>();
    }

    public static StudentDetails getObj() {
        if (studentDetails != null) {
            return studentDetails;
        }
        studentDetails = new StudentDetails();
        return studentDetails;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Course> getStudentCourseList() {
        return studentCourses;
    }

    
    //Implementing Behavior Design Pattern - Iterator
    public void getAllStudent() {
        ListIterator stuIt = studentList.listIterator();
        while (stuIt.hasNext()) {
            Object stu = stuIt.next();
            System.out.println(stu + " ");
        }
        System.out.println();
    }

}
