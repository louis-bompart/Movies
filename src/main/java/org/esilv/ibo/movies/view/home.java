package org.esilv.ibo.movies.view;/**
 * Created by alex on 24/11/2015.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class home extends Application {
    DeleteConfirm deleteConfirm;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        deleteConfirm = new DeleteConfirm();
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 850, 500));
        primaryStage.show();

        //Delete button
        Button deleteButton = new Button();
        deleteButton.setText("Delete");
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                deleteConfirm.doDelete();
            }
        });
        //Mind placing the button at its rightfull place
        //root.getChildren().add(btn);

    }
}