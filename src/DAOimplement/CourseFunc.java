/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOimplement;

import DataAccessObjects.ICourse;
import DataTransferObjects.Course;
import DataTransferObjects.CourseFactory;

/**
 *
 * @author anhtung
 */
public class CourseFunc implements ICourse {

    @Override
    public void getCourse(Course aCourse) {
        aCourse.displayCourseInfo();
    }

    @Override
    public void editCourseCredit(Course aCourse, int newCredit) {
        aCourse.editCredit(newCredit);
    }

    @Override
    public void allCourses() {
        CourseFactory courseFactory = new CourseFactory();
        System.out.println("");
        System.out.println(courseFactory.makeCourse("WD"));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(courseFactory.makeCourse("SC"));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(courseFactory.makeCourse("CS"));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

    }

}
