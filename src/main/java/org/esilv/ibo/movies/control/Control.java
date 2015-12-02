package org.esilv.ibo.movies.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.esilv.ibo.movies.model.Movie;
import org.esilv.ibo.movies.model.Movies;
import org.esilv.ibo.movies.view.Add;
import org.esilv.ibo.movies.view.AlertTemplate;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.List;

/**
 * Created by Mikko on 02/12/2015.
 */
public class Control {

    private Movies movies;
    public Control()
    {
        movies = new Movies();
    }

    public void addMovie(String title, String category)
    {

        Movie movie = new Movie(title, category);

        if(movies.AddMovie(movie))
        {
            String[] alert = {"Success","Your movie has been added"};
            AlertTemplate alertTemplate = new AlertTemplate(alert);
            alertTemplate.showAlert();
        }
        else
        {
            String[] alert = {"Failure","Your movie exists already"};
            AlertTemplate alertTemplate = new AlertTemplate(alert);
            alertTemplate.showAlert();
        }

    }

    public void removeMovie(Movie movie)
    {

        if(movies.RmMovie(movie.hashCode()))
        {
            String[] alert = {"Success","Your movie has been deleted"};
            AlertTemplate alertTemplate = new AlertTemplate(alert);
            alertTemplate.showAlert();
        }
        else
        {
            String[] alert = {"Failure","Your movie doesn't exist in our database"};
            AlertTemplate alertTemplate = new AlertTemplate(alert);
            alertTemplate.showAlert();
        }
    }

    @FXML
    private void handlePlus() {
        Stage stage = new Stage();
        Add add = new Add();
        add.start(stage);
    }
    @FXML
    private void handleMinus() {

    }


}

