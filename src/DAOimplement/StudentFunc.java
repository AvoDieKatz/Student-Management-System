package DAOimplement;

import DataAccessObjects.IStudent;
import DataTransferObjects.Student;
import data.StudentDetails;
import java.util.List;

public class StudentFunc implements IStudent {

    StudentDetails studentDetails;

    public StudentFunc() {
        studentDetails = StudentDetails.getObj();
    }

    @Override
    public void addStudent(Student student) {
        studentDetails.getStudentList().add(student);
        calcTuition(student);
    }

    @Override
    public void editStudent(Student student) {
        if (getStudentElIndex(student.getUserID()) >= 0) {
            studentDetails.getStudentList().set(getStudentElIndex(student.getUserID()), student);
            calcTuition(student);
        }
    }

    @Override
    public void deleteStudent(int userID) {
        if (getStudentElIndex(userID) >= 0) {
            studentDetails.getStudentList().remove(getStudentElIndex(userID));
        }
    }

    @Override
    public Student searchStudent(int userID) {
        return studentDetails.getStudentList().get(getStudentElIndex(userID));
    }

    @Override
    public List<Student> viewAllStudents() {
        return studentDetails.getStudentList();
    }

    @Override
    public void allStudents() {
        studentDetails.getAllStudent();
    }

    @Override
    public int getStudentElIndex(Integer userID) {
        for (Student s : studentDetails.getStudentList()) {
            if (userID.equals(s.getUserID())) {
//            if ((userID) == s.getUserID()) {
                return studentDetails.getStudentList().indexOf(s);
            }
        }
        return -1;
    }

    @Override
    public boolean checkStudentExist(Integer userID) {
        return studentDetails.getStudentList().stream().anyMatch(s -> (userID == s.getUserID()));
    }

    @Override
    public boolean checkEmpty() {
        return studentDetails.getStudentList().isEmpty();
    }

    @Override
    public int checkSize() {
        return studentDetails.getStudentList().size();
    }

    @Override
    public void calcTuition(Student student) {
        student.setTuition(student.getInitialFee() * student.getCourse().getCredits());
    }
    
    

}
