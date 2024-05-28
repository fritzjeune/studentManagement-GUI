package com.ayitigenius.studentmanagegui;

import com.ayitigenius.studentmanagegui.management.CourseManagement;
import com.ayitigenius.studentmanagegui.management.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentRegistrationController implements Initializable {

    @FXML
    public Label warnings;
    @FXML
    private TextField last_name;
    @FXML
    private TextField first_name;
    @FXML
    private TextField age;
    @FXML
    private Button add_student_btn;

    public void registerStudentBtnHAndler (ActionEvent event) {
        if (last_name.getText() == null || first_name.getText() == null || age.getText() == null) {
            warnings.setText("Please fill all the fields");
        }
        CourseManagement.registerStudent(last_name.getText(), first_name.getText(), Integer.parseInt(age.getText()));
        warnings.setText("Student registration successful");

        last_name.clear();
        first_name.clear();
        age.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
