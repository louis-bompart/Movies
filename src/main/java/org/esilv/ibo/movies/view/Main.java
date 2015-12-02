package org.esilv.ibo.movies.view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.esilv.ibo.movies.control.Control;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }

    private static Control control;
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View.fxml"));
        primaryStage.setTitle("Group one");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        control = new Control();
    }


}
