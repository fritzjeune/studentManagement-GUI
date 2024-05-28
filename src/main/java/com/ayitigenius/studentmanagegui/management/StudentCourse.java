package com.ayitigenius.studentmanagegui.management;

/**
 * I add this class to create an object with the course
 * and the grade for that course
 */
public class StudentCourse {
    private Course course;
    private double grade;


    StudentCourse (Course course, double grade) {
        this.course = course;
        this.grade = grade;
    }

    /**
     * I allow the creation of nwe course with only the course ,
     * and let the admin add the grade later.
     * @param course the course to which he is enrolled the student.
     */
    StudentCourse (Course course) {
        this.course = course;
    }

    // to get grade for this particular course
    public double getGrade() {
        return grade;
    }

    // setter method for the grade
    public void setGrade(double grade) {
        this.grade = grade;
    }

    // get the course , but I will not allow the change of the course.
    public Course getCourse() {
        return course;
    }
}
