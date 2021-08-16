/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import DataTransferObjects.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author anhtung
 */
public class CourseDetails {

    private static CourseDetails courseDetails = null;
    //private
    List<Course> courseList;

    private CourseDetails() {
        courseList = new ArrayList<>();
    }

    public static CourseDetails getObj() {
        if (courseDetails != null) {
            return courseDetails;
        }
        courseDetails = new CourseDetails();
        return courseDetails;
    }

    //ERROR!!! Does not return list with value
    public List<Course> getCourseLists() {
        return courseList;
    }

    public void getAllCourses() {
        ListIterator couIterator = courseList.listIterator();
        while (couIterator.hasNext()) {
            Object cou = couIterator.next();
            System.out.println(cou + " ");
        }
        System.out.println();
    }

}
