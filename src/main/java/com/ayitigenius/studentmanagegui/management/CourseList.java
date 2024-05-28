package com.ayitigenius.studentmanagegui.management;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableList;

public class CourseList implements Initializable {
        @FXML
        public TableView<Course> courseTable;
        @FXML
        public TableColumn<Course, String> courseCode;
        @FXML
        public TableColumn<Course, String> courseName;
        @FXML
        public TableColumn<Course, Integer> maxCapacity;
        @FXML
        public TableColumn<Course, Integer> totalEnrolledStudent;
    //    @FXML
    //    public TableColumn<Student, ArrayList<Course>> EnrolledCourses;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        courseCode.setCellValueFactory(new PropertyValueFactory<Course, String>("courseCode"));
        courseName.setCellValueFactory(new PropertyValueFactory<Course, String>("name"));
        maxCapacity.setCellValueFactory(new PropertyValueFactory<Course, Integer>("maxCapacity"));
        totalEnrolledStudent.setCellValueFactory(new PropertyValueFactory<Course, Integer>("totalEnrolledStudent"));

        courseTable.setItems(observableList(CourseManagement.courseList));
    }
}
