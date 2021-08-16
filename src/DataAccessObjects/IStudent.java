package DataAccessObjects;

import DataTransferObjects.Student;
import DataTransferObjects.Course;
import java.util.List;


public interface IStudent {

    //Student    
    void addStudent(Student student);

    void editStudent(Student student);

    void deleteStudent(int userID);

    Student searchStudent(int userID);

    int getStudentElIndex(int userID);

    boolean checkStudentExist(Integer userID);
    
    boolean checkEmpty();
    
    int checkSize();
    
    List<Student> viewAllStudents();
    
    void allStudents();
    
    void addToCourse(Course course);
    
    void viewAttendingCourses();
    
    void calcTuition(Student student);
    
}
