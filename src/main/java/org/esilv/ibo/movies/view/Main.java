package org.esilv.ibo.movies.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        // it has one error here. I think View.fxml is not be made into resources yet.
        // see movies.iml, View.fxml and Controller
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
        primaryStage.setTitle("Group one");
        primaryStage.setScene(new Scene(root, 400, 450));

        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
