/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTransferObjects;

/**
 *
 * @author anhtung
 */
public class CourseFactory {

    public Course makeCourse(String newCourseOpt) {

        switch (newCourseOpt) {
            case "CS":
                return new ComputerScienceCourse();
            case "SC":
                return new SecurityCourse();
            case "WD":
                return new WebDevelopmentCourse();
            default:
                return null;
        }
    }
}
