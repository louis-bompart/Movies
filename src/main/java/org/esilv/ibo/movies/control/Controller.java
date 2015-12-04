package org.esilv.ibo.movies.control;

import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.esilv.ibo.movies.MainApp;
import org.esilv.ibo.movies.model.Movie;
import org.esilv.ibo.movies.model.Movies;
import org.esilv.ibo.movies.view.Add;
import org.esilv.ibo.movies.view.DeleteConfirm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mcas on 03/12/2015.
 */
public class Controller {

    private Movies movies;

    List<Movie> ListMovie;

    private Movie movie;

    @FXML
    private TableView<Movie> _tableOne;
    @FXML
    private javafx.scene.control.TableColumn<Movie, String> _title;
    @FXML
    private javafx.scene.control.TableColumn<Movie, String> _category;
    @FXML
    private javafx.scene.control.Label labelone;

    private MainApp mainApp;

    @FXML
    private void initialize()
    {
        // Initialize the person table with the two columns.
        _title.setCellValueFactory(cellData -> cellData.getValue().getTitle());
        _category.setCellValueFactory(cellData -> cellData.getValue().getCategory());
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        movies = mainApp.getMovies();
        _tableOne.setItems(mainApp.getMovieData());

    }
    @FXML
    private void handlePlus() {
        Stage stage = new Stage();
        Add add = new Add(movies,mainApp);
        add.start(stage);
    }
    @FXML
    private void handleMinus()
    {
        DeleteConfirm deleteConfirm = new DeleteConfirm();
        boolean test = deleteConfirm.doDelete();
        if( test = true)
        {
            int SelectedIndex = _tableOne.getSelectionModel().getSelectedIndex();
            _tableOne.getItems().remove(SelectedIndex);

            String t =  _title.getColumns().get(SelectedIndex).getText().toString();
            String c =  _category.getColumns().get(SelectedIndex).getText().toString();

            Movie m = new Movie(t,c);

            //Lorsqu'on selectionne une ligne, on doit etre en mesure de selectionner en même temps les colonnes
            movies.RmMovie(m);
            //movies.removeMovie(ListMovie.get(SelectedIndex));
        }

    }

}
