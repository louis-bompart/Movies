package org.esilv.ibo.movies.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.esilv.ibo.movies.model.Movie;
import org.esilv.ibo.movies.model.Movies;
import org.esilv.ibo.movies.view.Add;
import org.esilv.ibo.movies.view.AlertTemplate;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
            WriteCSV();
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

    public List<String> getTitle()
    {
        List<String> str = new ArrayList<String>();
        Collection<Movie> movieCollection = movies.getMovies();
        for (Movie movie: movieCollection) {
            str.add(movie.getTitle());
        }
        return str;
    }

    public List<Movie> getMovies()
    {
        List<Movie> movieList = new ArrayList<Movie>();
        Collection<Movie> movieCollection = movies.getMovies();
        for (Movie movie: movieCollection) {
            movieList.add(movie);
        }
        return movieList;
    }

    public void WriteCSV()
    {
        String path = "C:\\Users\\Raihan\\Desktop\\movies.csv";  //path store

        try
        {
            FileWriter writer;  //Function to write

            writer = new FileWriter(path, true);  //take path

            List<Movie> mov = getMovies();

            for(Movie m : mov) //foreach
            {
                writer.write(m.getTitle().toString());
                writer.write(";"); //CSV separator
                writer.write(m.getCategory().toString());
                writer.write("\r\n");
            }

            System.out.println("Write success!");

            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }


}

