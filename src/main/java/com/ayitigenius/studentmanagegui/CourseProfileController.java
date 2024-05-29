package com.ayitigenius.studentmanagegui;

import com.ayitigenius.studentmanagegui.management.Course;
import com.ayitigenius.studentmanagegui.management.CourseManagement;
import com.ayitigenius.studentmanagegui.management.Student;
import com.ayitigenius.studentmanagegui.management.StudentCourse;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableList;


public class CourseProfileController implements Initializable{
    Course course ;

    public TableView<Student> studentTable;
    public TableColumn<Student, Integer> studentID;
    public TableColumn<Student, String> lastname;
    public TableColumn<Student, String> firstname;

    public Text maxCapacity;
    public Text courseName;
    public Text courseCode;
    public TextField searchInput;


    @FXML
    public void handleCourseSearch(ActionEvent event) {
        if (searchInput.getText().isEmpty()) {
            System.out.println("Not Found");
        }
        course = CourseManagement.getCourseById(searchInput.getText());

        if (course != null) {
            courseCode.setText(course.getCourseCode());
            courseName.setText(course.getName());
            maxCapacity.setText(String.valueOf(course.getMaxCapacity()));

            // to get nested column
            // https://stackoverflow.com/questions/24769296/binding-nested-object-properties-to-tableview-in-javafx
            studentID.setCellValueFactory(new PropertyValueFactory<Student, Integer>("ID"));
            lastname.setCellValueFactory(new PropertyValueFactory<Student, String>("lastname"));
            firstname.setCellValueFactory(new PropertyValueFactory<Student, String>("firstname"));

            studentTable.setItems(observableList(course.getEnrolledStudents()));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
