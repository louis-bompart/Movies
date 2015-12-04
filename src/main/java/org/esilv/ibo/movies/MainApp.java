package org.esilv.ibo.movies; /**
 * Created by Mcas on 03/12/2015.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.esilv.ibo.movies.control.Controller;
import org.esilv.ibo.movies.model.Movie;
import org.esilv.ibo.movies.model.Movies;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

public class MainApp extends Application {

    private final Movies movies;
    private final ObservableList<Movie> movieDataTab;
    private final ObservableList<PieChart.Data> movieDataChart;
    private Stage primaryStage;
    private BorderPane rootLayout;

    public MainApp() {
        movies = new Movies();
        movieDataTab = FXCollections.observableArrayList();
        movieDataChart = FXCollections.observableArrayList();
    }

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

    public ObservableList<PieChart.Data> getMovieDataChart() {
        return movieDataChart;
    }

    public ObservableList<Movie> getMovieDataTab() {
        return movieDataTab;
    }

    public Movies getMovies()
    {
        return movies;
    }

    private void initRootLayout()
    {
        try
        {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/View/RootLayout.fxml"));
            rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showMovieOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/View/View.fxml"));
            VBox movieOverview = loader.load();

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
        movieDataTab.clear();
        movieDataChart.clear();
        Iterator<Movie> movieIterator = movies.getMovies();
        Map<String, Integer> categories = new HashMap<>();
        for(;movieIterator.hasNext();)
        {
            Movie movie = movieIterator.next();
            movieDataTab.add(movie);
            if (categories.containsKey(movie.getCategory())) {
                categories.replace(movie.getCategory(), categories.get(movie.getCategory()) + 1);
            } else {
                categories.put(movie.getCategory(), 1);
            }
        }
        movieDataChart.addAll(categories.keySet().stream().map(key -> new PieChart.Data(key, categories.get(key))).collect(Collectors.toList()));
    }
}
