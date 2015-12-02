package org.esilv.ibo.movies.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View.fxml"));
        primaryStage.setTitle("Group one");
        primaryStage.setScene(new Scene(root, 700, 475));

        primaryStage.show();


        /*
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5); //horizontal
        grid.setVgap(5); //verticale
        grid.setPadding(new Insets(25,25,25,25));
        primaryStage.setScene(new Scene(grid, 500, 250));

        ListView<String> list = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList("Single", "Double", "Suite", "Family App");
        list.setItems(items);

        grid.add(list, 0,1);

        primaryStage.show();
        */


    }
}
