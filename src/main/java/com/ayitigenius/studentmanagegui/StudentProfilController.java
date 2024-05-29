package com.ayitigenius.studentmanagegui;

import com.ayitigenius.studentmanagegui.management.Course;
import com.ayitigenius.studentmanagegui.management.CourseManagement;
import com.ayitigenius.studentmanagegui.management.Student;
import com.ayitigenius.studentmanagegui.management.StudentCourse;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableList;

public class StudentProfilController implements Initializable {

    private Student student;
    // table fields to list enrolled courses
    @FXML
    public TableView<StudentCourse> courseTable;
    @FXML
    public TableColumn<StudentCourse, String> courseCode;
    @FXML
    public TableColumn<StudentCourse, String> name;
    @FXML
    public TableColumn<StudentCourse, Double> grade;

    // Fields of the student profile
    @FXML
    public Text firstName;
    @FXML
    public Text lastName;
    @FXML
    public Text overAllGrade;
    @FXML
    public Text age;

    // Fields for course enrollment
    @FXML
    public TextField searchInput;
    @FXML
    public ChoiceBox<String> courseList;
    @FXML
    public Button registerCourseBtn;

    @FXML
    public void getStudent(ActionEvent event) {
        if (searchInput.getText().isEmpty()) {
            System.out.println("Not Found");
        }
        student = CourseManagement.getStudentById(Integer.parseInt(searchInput.getText()));

        if (student != null) {
            firstName.setText(student.getFirstname());
            lastName.setText(student.getLastname());
            age.setText(String.valueOf(student.getAge()));
            overAllGrade.setText(String.valueOf(student.getOverallGrade()));

            // to get nested column
            // https://stackoverflow.com/questions/24769296/binding-nested-object-properties-to-tableview-in-javafx
            courseCode.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCourse().getCourseCode()));
            name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCourse().getName()));
            grade.setCellValueFactory(new PropertyValueFactory<StudentCourse, Double>("grade"));

            courseTable.setItems(observableList(student.getEnrolledCourses()));
        }
    }

    @FXML
    // Method to handler the enrroll to course button in the Student Profil
    public void handleEnrollment (ActionEvent event) {
        if (courseList.getSelectionModel().getSelectedItem() != null) {
            boolean added = CourseManagement.enrollStudent(student.getID(), courseList.getValue().split(" - ")[0]);
            if (added) {
                System.out.println("Course Added");
            } else {
                System.out.println("Course Not Added");
            }
        } else {
            System.out.println("Select a course from the list first");
        }
    }

    @FXML
    public void calculateOverAllGrade(ActionEvent event) {
        if (student != null) {
            System.out.println(CourseManagement.calculateOverallGrade(student));

        } else {
            System.out.println("No Student Selected");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> courseString = new ArrayList<>();
        for( Course course : CourseManagement.courseList) {
            courseString.add(course.getCourseCode() + " - " + course.getName());
        }
        courseList.getItems().setAll(courseString);
    }
}
