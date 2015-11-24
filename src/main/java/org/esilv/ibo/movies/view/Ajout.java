package org.esilv.ibo.movies.view;/**
 * Created by Raihan on 24/11/2015.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Ajout extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Ajouter un film");

        //Grid panel
        GridPane grid  = new GridPane();

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5); //horizontale
        grid.setVgap(5); //verticale
        grid.setPadding(new Insets(25,25,25,25));

        //Scene scene = new Scene(grid, 5, 5);
        primaryStage.setScene(new Scene(grid, 500, 250));

        //Film
        Label film = new Label("Film :");
        grid.add(film, 0, 0);
        TextField filmm = new TextField();
        grid.add(filmm, 1, 0);

        //Category
        Label category = new Label("Category :");
        grid.add(category, 0, 1);
        TextField categoryy = new TextField();
        grid.add(categoryy, 1, 1);

        //button
        Button btn = new Button();
        btn.setText("Ajouter");
        grid.add(btn, 1, 3);

        primaryStage.show();
    }
}
