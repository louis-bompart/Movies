package org.esilv.ibo.movies.view;
/**
 * Created by Raihan on 24/11/2015.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.esilv.ibo.movies.control.Controller;
import org.esilv.ibo.movies.model.Movie;

public class Add extends Application {

    private final Controller controller;
    private TextField movieTextField;
    private TextField categoryTextField;

    public Add(Controller controller) {
        this.controller = controller;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("Add a movie");

        //Grid panel
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5); //horizontal
        grid.setVgap(5); //vertical
        grid.setPadding(new Insets(25, 25, 25, 25));

        //Scene scene = new Scene(grid, 5, 5);
        primaryStage.setScene(new Scene(grid, 500, 250));

        //Movie
        final Label movieLabel = new Label("Movie :");
        grid.add(movieLabel, 0, 0);
        movieTextField = new TextField();
        grid.add(movieTextField, 1, 0);

        //Category
        final Label categoryLabel = new Label("Category :");
        grid.add(categoryLabel, 0, 1);
        categoryTextField = new TextField();
        grid.add(categoryTextField, 1, 1);

        //Button
        Button btn = new Button();
        btn.setText("Add");
        btn.setOnAction(event -> {
            controller.AddMovie(new Movie(movieTextField.getText(), categoryTextField.getText()));
            primaryStage.close();
        });
        grid.add(btn, 1, 3);
        primaryStage.show();
    }
}
