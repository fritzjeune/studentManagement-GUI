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
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableList;

public class StudentProfilController implements Initializable {
    @FXML
    public TableView<StudentCourse> courseTable;
    @FXML
    public TableColumn<Course, String> courseCode;
    @FXML
    public TableColumn<Course, String> name;
    @FXML
    public TableColumn<StudentCourse, Double> grade;
    @FXML
    public Text firstName;
    @FXML
    public Text lastName;
    @FXML
    public Text overAllGrade;
    @FXML
    public Text age;
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
        Student student = CourseManagement.getStudentById(Integer.parseInt(searchInput.getText()));

        if (student != null) {
            firstName.setText(student.getFirstname());
            lastName.setText(student.getLastname());
            age.setText(String.valueOf(student.getAge()));
            overAllGrade.setText(String.valueOf(student.getOverallGrade()));

            // to get nested column
            // https://stackoverflow.com/questions/24769296/binding-nested-object-properties-to-tableview-in-javafx
            courseCode.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCourseCode()));
            name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
            grade.setCellValueFactory(new PropertyValueFactory<StudentCourse, Double>("grade"));

            courseTable.setItems(observableList(student.getEnrolledCourses()));
        }
    }


    public void handleEnrollement (ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
