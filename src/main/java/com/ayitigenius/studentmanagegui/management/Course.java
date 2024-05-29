package com.ayitigenius.studentmanagegui.management;

import java.util.ArrayList;

public class Course {
    public int totalEnrolledStudent;
    public static int courseTotal = 0;
    private String name;
    private String courseCode;
    private int maxCapacity;
    private ArrayList<Student> enrolledStudents;

    Course (String courseCode, String name, int maxCapacity){
        courseTotal++;
        this.courseCode = courseCode;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.totalEnrolledStudent = 0;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getTotalEnrolledStudent() {
        return totalEnrolledStudent;
    }

    public void setTotalEnrolledStudent(int totalEnrolledStudent) {
        this.totalEnrolledStudent = totalEnrolledStudent;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
    public boolean addEnrolledStudents(Student student) {
        if (enrolledStudents.contains(student)) {
            System.out.println("Student already enrolled");
            return false;
        }
        enrolledStudents.add(student);
        return true;
    }


}
