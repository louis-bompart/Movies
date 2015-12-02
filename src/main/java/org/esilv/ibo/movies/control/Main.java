package org.esilv.ibo.movies.control;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.esilv.ibo.movies.view.Add;
import org.esilv.ibo.movies.view.DeleteConfirm;

import javax.swing.text.html.ListView;

/**
 * Movies
 * Created by louis on 24/11/2015.
 */
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

    @FXML
    private void handlePlus() {
        Stage stage = new Stage();
        Add add = new Add(control);
        add.start(stage);
    }
    @FXML
    private void handleMinus() {
        DeleteConfirm deleteConfirm = new DeleteConfirm();
        boolean test = deleteConfirm.doDelete();
        DeleteConfirm deleteConfirm1 = new DeleteConfirm();
    }
}
