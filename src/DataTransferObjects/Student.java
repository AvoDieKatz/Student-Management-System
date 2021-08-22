package DataTransferObjects;


public class Student {

    
    private Integer userID = 1;
    private String fullname;
    private Integer age;
    private String address;

    private int tuition;
    private int initialFee;
    private int totalcredits;

    private Mark gpa;
    private Course studentCourse;

    //Constructor for taking basic info
    public Student(Integer userID, String fullname, Integer age, String address, int initialFee, Course studentCourse) {
        this.userID = userID;
        this.fullname = fullname;
        this.age = age;
        this.address = address;
        this.initialFee = initialFee;
        this.studentCourse = studentCourse;
    }


    
    
    @Override
    public String toString() {
        return "Student ID: " + getUserID() + "\n"
                + "Student Name: " + getFullname() + "\n"
                + "Student Age: " + getAge() + "\n"
                + "Student Address: " + getAddress() + "\n"
                + "Initial Fee: " +getInitialFee() + " USD\n"
                + "Course attending: \n" + getCourse() + "\n"
                + "Student Tuition: " + getTuition() + " USD (Tuition = Initial fee * credits)\n"
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    }
    
    
//    public void display() {
//        System.out.println("-----------------------------------------------------------------------------");
//        System.out.printf("%10s %20s %5s %10s %20s %10s", "STUDENT ID", "NAME", "AGE", "ADDRESS", "COURSE", "TUITION");
//        System.out.println();
//        System.out.println("-----------------------------------------------------------------------------");
//        System.out.format("%10s %20s %5s %10s %20s %10s",
//                getUserID(), getFullname(), getAge(), getAddress(), getCourse().getCourseName(), getTuition());
//        System.out.println();
//        System.out.println("-----------------------------------------------------------------------------");
//    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    String getFullname() {
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

    public int getTotalcredits() {
        return totalcredits;
    }

    public void setTotalcredits(int totalcredits) {
        this.totalcredits = totalcredits;
    }

    public int getTuition() {
        return tuition;
    }

    public void setTuition(int tuition) {
        this.tuition = tuition;
    }

    public int getInitialFee() {
        return initialFee;
    }

    public void setInitialFee(int initialFee) {
        this.initialFee = initialFee;
    }

    public Mark getGpa() {
        return this.gpa;
    }

    public void setGpa(Mark gpa) {
        this.gpa = gpa;
    }

    public Course getCourse() {
        return studentCourse;
    }

    public void setCourse(Course studentCourse) {
        this.studentCourse = studentCourse;
    }

}
