
public class Student {

    private int userID;
    private String fullname;
    private int age;
    private String address;
    private float gpa;
    private int[] classmark;
    private int tuition;
    private int totalcredits;
    Course course;

    
    public Student(int userID, String fullname, int age, String address) {
        this.userID = userID;
        this.fullname = fullname;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
        this.classmark = classmark;
        this.totalcredits = totalcredits;
        this.tuition = tuition;
    }
    
//    public StudentIterator<Student> iterator() {
//        return new MyStudentIterator();
//    }
//    
//    class MyStudentIterator implements StudentIterator<Student> {
//        
//    }
    
    @Override
    public String toString() {
        return "Student ID= " + userID + "\n"
                + "Student Name= " + fullname + "\n"
                + "Student Age= " + age + "\n"
                + "Student Address= " + address + "\n";
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getGpa() {
        return this.gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int[] getClassMark() {
        // TODO - implement Student.getClassMark
        throw new UnsupportedOperationException();
    }

    public void setClassMark(int mark) {
        // TODO - implement Student.setClassMark
        throw new UnsupportedOperationException();
    }

}
