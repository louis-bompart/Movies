package org.esilv.ibo.movies;/**
 * Created by Mcas on 03/12/2015.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.esilv.ibo.movies.control.Controller;
import org.esilv.ibo.movies.model.Movie;
import org.esilv.ibo.movies.model.Movies;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class MainApp extends Application {

    private Movies movies;
    private ObservableList<Movie> movieData = FXCollections.observableArrayList();
    private Stage primaryStage;
    private BorderPane rootLayout;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("MovieWatcher");
        initRootLayout();
        showMovieOverview();
    }

    public MainApp(){
        movies = new Movies();
    }


    public ObservableList<Movie> getMovieData() {
        return movieData;
    }

    public Movies getMovies()
    {
        return movies;
    }

    public void initRootLayout()
    {
        try
        {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/View/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMovieOverview(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/View/View.fxml"));
            VBox movieOverview = (VBox) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(movieOverview);

            // Give the controller access to the main app.
            Controller controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update()
    {
        movieData.clear();
        Iterator<Movie> movieIterator = movies.getMovies();
        for(;movieIterator.hasNext();)
        {
            movieData.add(movieIterator.next());
        }
    }
}
