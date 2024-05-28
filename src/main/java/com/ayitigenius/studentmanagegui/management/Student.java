package com.ayitigenius.studentmanagegui.management;

import java.util.ArrayList;

public class Student {
    static int autoIncrementID = 0;
    private String lastname;
    private String firstname;
    private int age;
    private int ID;
    private ArrayList<StudentCourse> enrolledCourses;
    private double overallGrade;

    Student( String lastname, String firstname, int age) {
        autoIncrementID++;
        this.ID = autoIncrementID;
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
        this.enrolledCourses = new ArrayList<>();
    }

    /**
     * This method create a Student course which allow me assign a grade
     * to the student for that course.
     * @param course because at creation time the grade could not be available.
     */
    public void enrollToCourse (Course course) {
        StudentCourse studentCourse = new StudentCourse(course);
        this.enrolledCourses.add(studentCourse);
        course.setTotalEnrolledStudent(course.totalEnrolledStudent + 1);
    }

    public String getName() {
        return lastname;
    }

    public int getID() {
        return ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // getter method for the overallGrade variable.
    public double getOverallGrade() {
        return overallGrade;
    }

    // setter method for the overallGrade variable.
    public void setOverallGrade(double overallGrade) {
        this.overallGrade = overallGrade;
    }

    // getter method for the enrolledCourse variable.
    public ArrayList<StudentCourse> getEnrolledCourses() {
        return this.enrolledCourses;
    }

    // A method that I add to be able to print the student details
    public void printStudentDetails() {
        ArrayList<StudentCourse> courses = this.getEnrolledCourses();

        String details =
                        "ID : " + this.ID + "\n"
                        + "Last name : " + this.lastname + "\n"
                        + "First name : " + this.firstname + "\n"
                        + "Age : " + this.age + "\n"
                        + "OverallGrade : " + this.getOverallGrade() + "\n";
        System.out.println(details);
        for (StudentCourse stc: courses) {
            System.out.println("    " + stc.getCourse() + " : " + stc.getGrade() + "\n");
        }
        System.out.println("*************************");
    }
}

