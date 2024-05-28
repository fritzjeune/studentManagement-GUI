package com.ayitigenius.studentmanagegui;

import com.ayitigenius.studentmanagegui.management.CourseManagement;
import com.ayitigenius.studentmanagegui.management.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CourseRegistrationController {

    @FXML
    public TextField course_code;
    @FXML
    public TextField course_name;
    @FXML
    public TextField max_capacity;
    @FXML
    public Button add_course_btn;
    @FXML
    public Label warnings;

    public void createCourseBtnHAndler (ActionEvent event) {
        if (course_code.getText() == null || course_name.getText() == null || max_capacity.getText() == null) {
            warnings.setText("Please fill all the fields");
        }
        CourseManagement.addCourse(course_code.getText(), course_name.getText(), Integer.parseInt(max_capacity.getText()));
        warnings.setText( course_name.getText() + " Course added Successfully");

        course_code.clear();
        course_name.clear();
        max_capacity.clear();
    }
}
