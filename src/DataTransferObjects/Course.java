package DataTransferObjects;


public class Course {

    private Integer courseID;
    private String courseName;
    private Integer credits;

    public Course() {
        
    }

    
    public Course(Integer courseID, String courseName, Integer credits) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
    }
    
    @Override
    public String toString() {
        return "Course ID: " +getCourseID()+ "\n"
                + "Course Name: " +getCourseName()+ "\n"
                + "Course Credit: " +getCredits()+ "";
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return this.credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

}
