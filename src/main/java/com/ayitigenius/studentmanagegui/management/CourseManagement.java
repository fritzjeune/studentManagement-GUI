package com.ayitigenius.studentmanagegui.management;

import java.util.ArrayList;

public class CourseManagement {
    // This Student list take an Object Student which contain the courseList of
    // the student with the grade for that particular course.
    public static ArrayList<Student> studentList = new ArrayList<>();
    // This variable holds a list of course available
    public static ArrayList<Course> courseList = new ArrayList<>();

    /**
     * This method create an object of course and add it the general static course list
     * variable.
     * @param name
     * @param maxCapacity
     * @return a text confirmation
     */
    public static String addCourse ( String courseCode, String name, int maxCapacity) {
        Course course = new Course(courseCode, name, maxCapacity);
        courseList.add(course);
        return "Course Added!!";
    }

    /**
     * This method create a new student and add it to the list of student,
     * @param ID Auto generated
     * @param lastname
     * @param firstname
     * @params age
     * @return a text confirmation
     */
    public static String registerStudent (String lastname, String firstname, int age) {
        Student student = new Student(lastname, firstname, age);
        studentList.add(student);
        return "Course Added!!";
    }

    /**
     * This method assign grade to a student for a particular course
     * It loops through the studentCourseList find the course and assign
     * the grade for that course.
     * @param student
     * @param course
     * @param grade
     * @return
     */
    public static String assignGrade (Student student, Course course, double grade) {
        for (StudentCourse sc : student.getEnrolledCourses()) {
            if (sc.getCourse() == course) {
                sc.setGrade(grade);
            }
        }
        return "Grade Assigned!";
    }

    /**
     * this method will first lookup the course and student by Id , if both are found
     * it will go ahead and call the enrollToCourse method in the student class.
     * this method enrollToCourse will update the static variable of number of enrolled
     * to the course.
     * @param studentID
     * @param courseID
     * @return true if student if course is added to the student registered course
     * and false if student or course is not found
     */
    public static boolean enrollStudent (int studentID, String courseID) {
        Student student = getStudentById(studentID);
        Course course = getCourseById(courseID);
        if (student == null || course == null) {
            return false;
        }

        if (student.checkEnrolledCourse(course))  {
            System.out.println("Student already enrolled in this course");
            return false;
        }

        student.enrollToCourse(course);
        course.addEnrolledStudents(student);
        return true;
    }

    /**
     * This method loops through the student enrolledCourse and get
     * the grade for each course and add it to the total grade.
     * @param student
     * @return the total point.
     */
    public static double calculateOverallGrade (Student student) {
        double totalPoints = 0.0;
        ArrayList<StudentCourse> courseList = student.getEnrolledCourses();
        for (int i = 0; i < courseList.size(); i++) {
//          // make the sum of all point grade
            totalPoints += courseList.get(i).getGrade();
        }
        // calculate the grade
        double grade = totalPoints / courseList.size();
        student.setOverallGrade(grade);
        return grade;
    }

    // This static method will help find a course by ID
    public static Course getCourseById (String ID) {
        for (Course course : courseList) {
            if (course.getCourseCode().equals(ID)) {
                return course;
            }
        }
        return null;
    }

    // This static method will help find a student by ID
    public static Student getStudentById (int ID) {
        for (Student student : studentList) {
            if (student.getID() == ID) {
                return student;
            }
        }
        return null;
    }

}
