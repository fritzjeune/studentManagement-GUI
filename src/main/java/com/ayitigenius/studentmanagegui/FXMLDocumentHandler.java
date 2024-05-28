package com.ayitigenius.studentmanagegui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLDocumentHandler extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        javafx.fxml.FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-pane.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Student Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
