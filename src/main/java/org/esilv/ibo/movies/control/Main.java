package org.esilv.ibo.movies.control;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.esilv.ibo.movies.model.Movie;
import org.esilv.ibo.movies.view.Add;
import org.esilv.ibo.movies.view.DeleteConfirm;

import javax.swing.table.TableColumn;
import javax.swing.text.html.ListView;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Movies
 * Created by louis on 24/11/2015.
 */
public class Main extends Application {

    private static Control control;

    List<Movie> mov = new ArrayList<Movie>(); //movie LIST

    private final ObservableList<Movie> data = FXCollections.observableArrayList(mov);

    public static void main(String[] args)
    {
        Application.launch(Main.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View.fxml"));
        primaryStage.setTitle("Main Form");
        primaryStage.setScene(new Scene(root, 700, 475));

        //root();

        primaryStage.show();
        control = new Control();
    }

    @FXML
    private javafx.scene.control.TableColumn<Movie, String> _title;

    @FXML
    private javafx.scene.control.TableColumn<Movie, String> _kind;

    @FXML
    private TableView<Movie> _tableOne = new TableView<Movie>();

    @FXML
    public void handleLoad()
    {
        Movie m = new Movie("ok","ok");

        try
        {
            //if(mov.size() != 0)
            {
                _title.setCellValueFactory(new PropertyValueFactory<Movie, String>("title")); //doesn't work
                _kind.setCellValueFactory(new PropertyValueFactory<Movie, String>("category")); //doesn't work
                _tableOne.setItems(data);
                _tableOne.setVisible(true);

                //_tableOne.getColumns().addAll(_title,_kind);

            }
        }

        catch (Exception  e)
        {
            e.printStackTrace();
        }
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
