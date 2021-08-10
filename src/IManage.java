
import java.util.List;


public interface IManage {

    //Student
    void addStudent(Student student);

    void editStudent(Student student);

    void deleteStudent(int userID);

    Student searchStudent(int userID);

    int getStudentElIndex(int userID);

    boolean checkStudentExist(Student userID);
    
    List<Student> viewAllStudent();
    
    public void allStudent();

    //Course
    void addCourse(Course course);

    void editCourse(Course course);

    void deleteCourse(Integer courseID);

    Course searchCourse(Integer courseID);

    int getCourseElIndex(Integer courseID);

    boolean checkCourseExist(Course courseID);

    //Random bs GOOOO
    void addMark();

    void editMark();

    void applyFeeExchangeStudent();

}
