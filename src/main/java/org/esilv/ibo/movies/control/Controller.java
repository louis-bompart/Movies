package org.esilv.ibo.movies.control;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.esilv.ibo.movies.MainApp;
import org.esilv.ibo.movies.model.Movie;
import org.esilv.ibo.movies.model.Movies;
import org.esilv.ibo.movies.view.Add;
import org.esilv.ibo.movies.view.DeleteConfirm;

/**
 * Created by Mcas on 03/12/2015.
 */
public class Controller {

    private Movies movies;

    @FXML
    private TableView<Movie> _tableOne;
    @FXML
    private javafx.scene.control.TableColumn<Movie, String> _title;
    @FXML
    private javafx.scene.control.TableColumn<Movie, String> _category;
    @FXML
    private javafx.scene.chart.PieChart pieChartOne;

    private MainApp mainApp;

    @FXML
    private void initialize()
    {
        // Initialize the person table with the two columns.
        _title.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTitle()));
        _category.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCategory()));
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        movies = mainApp.getMovies();
        _tableOne.setItems(mainApp.getMovieDataTab());
        pieChartOne.setData(mainApp.getMovieDataChart());
    }
    @FXML
    private void handlePlus() {
        Stage stage = new Stage();
        Add add = new Add(this);
        add.start(stage);
    }
    @FXML
    private void handleMinus()
    {
        DeleteConfirm deleteConfirm = new DeleteConfirm();
        boolean test = deleteConfirm.doDelete();
        if (test)
        {
            Movie movie = _tableOne.getSelectionModel().getSelectedItem();
            if (movie != null) {
                RmMovie(movie);
            }
        }
    }

    public void AddMovie(Movie movie) {
        movies.AddMovie(movie);
        mainApp.update();
    }

    private void RmMovie(Movie movie) {
        if (movie != null) {
            movies.RmMovie(movie);
            mainApp.update();
        }
    }
}
