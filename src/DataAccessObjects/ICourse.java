package DataAccessObjects;

import DataTransferObjects.Student;
import DataTransferObjects.Course;
import java.util.List;

/**
 *
 * @author anhtung
 */
public interface ICourse {

    void addCourse(Course course);

    void editCourse(Course course);

    void deleteCourse(int courseID);

    Course searchCourse(Integer courseID);

    int getCourseElIndex(int courseID);

    boolean checkCourseExist(Integer courseID);
    
    boolean checkEmpty();
    
    int checkSize();
    
    List<Course> viewAllCourses();
    
    void allCourses();
    
    List<Student> viewAttendingStudents();

}
