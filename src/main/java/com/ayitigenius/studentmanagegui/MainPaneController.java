package com.ayitigenius.studentmanagegui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainPaneController implements Initializable {

    public Button add_course_menu_btn;
    public Button add_student_menu_btn;
    public Button list_menu_btn;
    public Button list_course_menu_btn;
    public BorderPane main_pane_content;
    public Button search_student_menu_btn;
    public Button search_course_menu_btn;

    @FXML
    private void addRegisterStudentMenuHandler (ActionEvent event) {
        FxmlLoader view = new FxmlLoader();
        Pane window = view.getView("student-registration");
        main_pane_content.setLeft(window);
    }

    @FXML
    private void addCourseStudentMenuHandler (ActionEvent event) {
        FxmlLoader view = new FxmlLoader();
        Pane window = view.getView("course-registration");
        main_pane_content.setLeft(window);
    }

    @FXML
    private void listStudentMenuHandler (ActionEvent event) {
        FxmlLoader view = new FxmlLoader();
        Pane window = view.getView("list-student");
        main_pane_content.setLeft(window);
    }

    @FXML
    private void listCourseMenuHandler (ActionEvent event) {
        FxmlLoader view = new FxmlLoader();
        Pane window = view.getView("list-course");
        main_pane_content.setLeft(window);
    }

    @FXML
    private void StudentProfilMenuHandler (ActionEvent event) {
        FxmlLoader view = new FxmlLoader();
        Pane window = view.getView("student-profil");
        main_pane_content.setLeft(window);
    }

    @FXML
    private void CourseProfilMenuHandler (ActionEvent event) {
        FxmlLoader view = new FxmlLoader();
        Pane window = view.getView("course-profile");
        main_pane_content.setLeft(window);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
