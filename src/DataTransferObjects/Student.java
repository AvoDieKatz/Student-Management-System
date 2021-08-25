package DataTransferObjects;

import java.util.Objects;


public class Student {

    
    private Integer userID;
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
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.userID);
        hash = 59 * hash + Objects.hashCode(this.fullname);
        hash = 59 * hash + Objects.hashCode(this.age);
        hash = 59 * hash + Objects.hashCode(this.address);
        hash = 59 * hash + this.tuition;
        hash = 59 * hash + this.initialFee;
        hash = 59 * hash + this.totalcredits;
        hash = 59 * hash + Objects.hashCode(this.gpa);
        hash = 59 * hash + Objects.hashCode(this.studentCourse);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.tuition != other.tuition) {
            return false;
        }
        if (this.initialFee != other.initialFee) {
            return false;
        }
        if (this.totalcredits != other.totalcredits) {
            return false;
        }
        if (!Objects.equals(this.fullname, other.fullname)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.userID, other.userID)) {
            return false;
        }
        if (!Objects.equals(this.age, other.age)) {
            return false;
        }
        if (!Objects.equals(this.gpa, other.gpa)) {
            return false;
        }
        if (!Objects.equals(this.studentCourse, other.studentCourse)) {
            return false;
        }
        return true;
    }



    
    
    @Override
    public String toString() {
        return "Student ID: " + getUserID() + "\n"
                + "Student Name: " + getFullname() + "\n"
                + "Student Age: " + getAge() + "\n"
                + "Student Address: " + getAddress() + "\n"
                + "Initial Fee: " +getInitialFee() + " USD\n"
                + "Course attending: \n"
                + "\tCourse ID: " +getCourse().getCourseID()+ "\n"
                + "\tCourse Name: " +getCourse().getCourseName()+ "\n"
                + "\tCourse Credit: " +getCourse().getCredits()+ " credits\n"
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
