package DAOimplement;

import DataAccessObjects.ICourse;
import DataTransferObjects.Course;
import DataTransferObjects.Student;
import data.CourseDetails;
import data.StudentDetails;
import java.util.List;

/**
 *
 * @author anhtung
 */
public class CourseFunc implements ICourse {

    CourseDetails courseDetails;
    StudentDetails studentDetails;

    public CourseFunc() {
        courseDetails = CourseDetails.getObj();
    }

    @Override
    public void addCourse(Course course) {
        courseDetails.getCourseLists().add(course);

    }

    @Override
    public void deleteCourse(int courseID) {
        if (getCourseElIndex(courseID) >= 0) {
            courseDetails.getCourseLists().remove(getCourseElIndex(courseID));
        }
    }

    @Override
    public void editCourse(Course course) {
        if (getCourseElIndex(course.getCourseID()) >= 0) {
            courseDetails.getCourseLists().set(getCourseElIndex(course.getCourseID()), course);
        }
    }

    //currently searching by index (RE-DO)
    @Override
    public Course searchCourse(Integer courseID) {
        return courseDetails.getCourseLists().get(getCourseElIndex(courseID));
    }

    @Override
    public List<Course> viewAllCourses() {
        return courseDetails.getCourseLists();
    }

    @Override
    public void allCourses() {
        courseDetails.getAllCourses();
    }

    @Override
    public int getCourseElIndex(int courseID) {
        for (Course c : courseDetails.getCourseLists()) {
            if (courseID == c.getCourseID()) {
                return courseDetails.getCourseLists().indexOf(c);
            }
        }
        return -1;
    }

    @Override
    public boolean checkCourseExist(Integer courseID) {
        return courseDetails.getCourseLists().stream().anyMatch(c -> (courseID == c.getCourseID()));
    }

    @Override
    public boolean checkEmpty() {
        return courseDetails.getCourseLists().isEmpty();
    }

    @Override
    public int checkSize() {
        return courseDetails.getCourseLists().size();
    }

//Display all attending Students in "A course"
    @Override
    public List<Student> viewAttendingStudents() {
        return studentDetails.getStudentList();
    }

}
