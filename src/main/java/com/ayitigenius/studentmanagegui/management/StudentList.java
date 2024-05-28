package com.ayitigenius.studentmanagegui.management;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableList;

public class StudentList implements Initializable {
        @FXML
        public TableView<Student> studentTable;
        @FXML
        public TableColumn<Student, Integer> ID;
        @FXML
        public TableColumn<Student, String> lastName;
        @FXML
        public TableColumn<Student, String> firstName;
        @FXML
        public TableColumn<Student, Integer> age;
    //    @FXML
    //    public TableColumn<Student, ArrayList<Course>> EnrolledCourses;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ID.setCellValueFactory(new PropertyValueFactory<Student, Integer>("ID"));
        lastName.setCellValueFactory(new PropertyValueFactory<Student, String>("lastname"));
        firstName.setCellValueFactory(new PropertyValueFactory<Student, String>("firstname"));
        age.setCellValueFactory(new PropertyValueFactory<Student, Integer>("age"));

        studentTable.setItems(observableList(CourseManagement.studentList));
    }
}
