package DataAccessObjects;

import DataTransferObjects.Student;
import DataTransferObjects.Course;
import java.util.List;

/**
 *
 * @author anhtung
 */
public interface ICourse {
    
    void getCourse();
    
    void editCourseCredit(Course aCourse, int newCredit);

    void allCourses();
    
    void displayCourseInfo(Course aCourse);
}
