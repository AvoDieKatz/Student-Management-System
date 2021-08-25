package DataAccessObjects;

import DataTransferObjects.Course;
/**
 *
 * @author anhtung
 */
public interface ICourse {
    
    void getCourse(Course aCourse);
    
    void editCourseCredit(Course aCourse, int newCredit);

    void allCourses();
    
}
