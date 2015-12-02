package org.esilv.ibo.movies.control;

import javafx.scene.control.Alert;
import org.esilv.ibo.movies.model.Movie;
import org.esilv.ibo.movies.model.Movies;
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
            //AlertTemplate alertTemplate = new AlertTemplate(alert);
            //alertTemplate.showAlert();
        }
        else
        {
            String[] alert = {"Failure","Your movie exists already"};
            //AlertTemplate alertTemplate = new AlertTemplate(alert);
            //alertTemplate.showAlert();
        }
    }




}

