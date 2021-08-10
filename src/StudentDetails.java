
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.ListIterator;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anhtung
 */
public class StudentDetails {

    private static StudentDetails studentDetails = null;
    List<Student> studentList;
    List<Course> courseList;

    private StudentDetails() {
        studentList = new ArrayList<>();
        courseList = new ArrayList<>();
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
    
    public void getAllStudent() {
        ListIterator stuIt = studentList.listIterator();
        while (stuIt.hasNext()) {
            Object stu = stuIt.next();
            System.out.println(stu + " ");
        }
        System.out.println();
    }
    
    public List<Course> getCourseList() {
        return courseList;
    }
}
