package DataAccessObjects;

import DataTransferObjects.Student;
import java.util.List;


public interface IStudent {

    //Student    
    void addStudent(Student student);

    void editStudent(Student student);

    void deleteStudent(int userID);

    Student searchStudent(int userID);

    int getStudentElIndex(Integer userID);

    boolean checkStudentExist(Integer userID);
    
    boolean checkEmpty();
    
    int checkSize();
    
    List<Student> viewAllStudents();
    
    void allStudents();
    
    void calcTuition(Student student);
    
}
