package DataTransferObjects;


public abstract class Course {

    private String courseID;
    private String courseName;
    private int credits;

    public Course() {
        
    }

    
    public Course(String courseID, String courseName, int credits) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
    }
    
    @Override
    public String toString() {
        return "Course ID: " +getCourseID()+ "\n"
                + "Course Name: " +getCourseName()+ "\n"
                + "Course Credit: " +getCredits();
    }
    
    

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
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

    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    public void displayCourseInfo() {
        System.out.println("Course ID: " +getCourseID() 
                        + "Course Name: " +getCourseName()
                        + "Course Credit: " +getCredits());
    }
    
    public void editCredit(int newCredit) {
        setCredits(newCredit);
    }

}
