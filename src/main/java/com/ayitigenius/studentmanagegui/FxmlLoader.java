package com.ayitigenius.studentmanagegui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.net.URL;

public class FxmlLoader {
    private Pane view;

    public Pane getView(String filename) {
        try {
            URL resource = MainApplication.class.getResource("" + filename + ".fxml");
            if (resource == null) {
                throw new FileNotFoundException(filename + ".fxml cannot be found");
            }

            view = new FXMLLoader().load(resource);
        } catch (Exception e) {
            System.out.println("Error in loading fxml");
        }
        return view;
    }
}


// References:
// https://www.youtube.com/watch?v=5yQbt6lYRqk
