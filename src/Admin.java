import java.util.ListIterator;
import java.util.List;


public class Admin implements IManage {

    StudentDetails studentDetails;

    public Admin() {
        studentDetails = StudentDetails.getObj();
    }

    
    //FUNCTIONS FOR STUDENT
    
    
    
    @Override
    public void addStudent(Student student) {
        studentDetails.getStudentList().add(student);
    }

    @Override
    public void editStudent(Student student) {
        if (getStudentElIndex(student.getUserID()) >= 0) {
            studentDetails.getStudentList().set(getStudentElIndex(student.getUserID()), student);
            System.out.println("Student information added successfully!!");
        } else {
            System.out.println("No such Student ID");
        }
    }

    @Override
    public void deleteStudent(int userID) {
        if (getStudentElIndex(userID) >= 0) {
            studentDetails.getStudentList().remove(getStudentElIndex(userID));
            System.out.println("Student DELETED successfully");
        } else {
            System.out.println("No such Student ID");
        }
    }

    @Override
    public Student searchStudent(int userID) {
//        if (studentDetails.getStudentList().contains("userID")) {
            return studentDetails.getStudentList().get(userID);
//        } else {
//            System.out.print("No such Student ID:\t");
//            return null;
//        }
    }

    @Override
    public List<Student> viewAllStudent() {
        return studentDetails.getStudentList();
    }
    
    

    @Override
    public void allStudent() {
        studentDetails.getAllStudent();
    }
    
    

    @Override
    public int getStudentElIndex(int userID) {
        for (Student s : studentDetails.getStudentList()) {
            if ((userID) == s.getUserID()) {
                return studentDetails.getStudentList().indexOf(s);
            }
        }
        return -1;
    }
    
    @Override
    public boolean checkStudentExist(Student student) {
//        return studentDetails.getStudentList().contains(student.getUserID());
        return true;
    }

    
    
    //FUNCTIONS FOR COURSE
    
    
    
    @Override
    public void addCourse(Course course) {
        studentDetails.getCourseList().add(course);
    }

    @Override
    public void deleteCourse(Integer courseID) {
        if (getCourseElIndex(courseID) >= 0) {
            studentDetails.getCourseList().remove(getCourseElIndex(courseID));
        }
    }

    @Override
    public void editCourse(Course course) {
        if (getCourseElIndex(course.getCourseID()) >= 0) {
            studentDetails.getCourseList().set(getCourseElIndex(course.getCourseID()), course);
        }
    }
    
    @Override
    public Course searchCourse(Integer courseID) {
        return studentDetails.getCourseList().get(courseID);
    }
    

    @Override
    public int getCourseElIndex(Integer courseID) {
        for (Course c : studentDetails.getCourseList()) {
            if (c.getCourseID().equals(courseID)) {
                return studentDetails.getCourseList().indexOf(c);
            }
        }
        return -1;
    }
    
    @Override
    public boolean checkCourseExist(Course courseID) {

        return true;
    }

    
    
    //FUNCTIONS FOR TO BE CONFIGURED
    
    
    @Override
    public void addMark() {

    }

    @Override
    public void editMark() {

    }

    @Override
    public void applyFeeExchangeStudent() {

    }


    
    
    
    

}
