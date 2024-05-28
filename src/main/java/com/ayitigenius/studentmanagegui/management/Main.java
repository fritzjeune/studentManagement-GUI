package com.ayitigenius.studentmanagegui.management;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static int option;
    public static ArrayList<Student> students = new ArrayList<>();
    public static ArrayList<Course> courses = new ArrayList<>();
    public static void main(String[] args) {

        boolean loggedIn = true;
        while (loggedIn) {
            getMenu();
            switch (option) {
                case 1 -> {
                    // Add new student
                    System.out.println("***Add Student Section***");
//                    addStudent();
                }
                case 2 -> {
                    // Add new course
                    System.out.println("***Add new Course Section***");
                    addCourse();
                }
                case 3 -> {
                    // view student details
                    System.out.println("***Enroll Student to Course Section***");

                }
                case 4 -> {
                    // Add grade to student course
                }
                case 5 -> {
                    // Calculate overall grade for each Student
                    break;
                }
                case 6 -> {
                    // Exit
                    System.out.println("Good Bye!");
                    System.exit(0);
                }
            }
        }
    }

    private static void getMenu() {
        System.out.println("***Administrator Interface***");
        boolean nameOptionIsValid = false;
        do {
            System.out.println("""
                What operation would you like to perform? 
                    1 - Add new Course
                    2 - Add new Student
                    3 - Enroll Student to course
                    4 - Add grade to course
                    5 - Calculate overall grade for each Student
                    6 - Exit
                Choose by typing the corresponding option id.
                """);
            Scanner scanner = new Scanner( System.in );
            try {
                option = scanner.nextInt();
            }
            catch (InputMismatchException ime) {
                System.out.println("Invalid for an Interger, please try again!");
            }

            // Verify that the user enter a valid option
            if (option > 0 && option < 5) {
                nameOptionIsValid = true;
            } else {
                System.out.println("Invalid Option!");
            }
        } while (!nameOptionIsValid);
    }

    public static void addCourse () {
        boolean nameIsValid = false;
        String name;
        do {
            System.out.println("Please enter the the course name and max capacity, followed by commas");
            Scanner scanner = new Scanner( System.in );
            name = scanner.next();
            try {
                if (name instanceof String) {
                    String[] splittedName = name.split(",");
                    CourseManagement.addCourse(splittedName[0], splittedName[1], Integer.parseInt(splittedName[2]));
                    nameIsValid = true;
                }
            } catch (NumberFormatException nfe) {
                System.out.println();
            }

        } while (!nameIsValid);
    }
}