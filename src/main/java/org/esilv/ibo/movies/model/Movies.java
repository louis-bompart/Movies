package org.esilv.ibo.movies.model;

import org.esilv.ibo.movies.view.AlertTemplate;

import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.util.*;

/**
 * Created by Louis on 02/12/2015.
 */
public class Movies
{
    HashMap<Integer, Movie> hashMap;

    public Movies() {
        hashMap = new HashMap<Integer, Movie>();
    }

    public boolean AddMovie(Movie movie)
    {

        if (hashMap.containsKey(movie.hashCode()))
        {
            return false;
        }
        hashMap.put(movie.hashCode(), movie);

        return true;
    }

    public boolean RmMovie(int hashcode) {
        if (!hashMap.containsKey(hashcode)) {
            hashMap.remove(hashcode);
            return false;
        }
        return true;
    }

    public void addMovie(String title, String category)
    {

        Movie movie = new Movie(title, category);

        if(AddMovie(movie))
        {
            String[] alert = {"Success","Your movie has been added"};
            AlertTemplate alertTemplate = new AlertTemplate(alert);
            alertTemplate.showAlert();
            //WriteCSV();
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

        if(RmMovie(movie.hashCode()))
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
        Collection<Movie> movieCollection = hashMap.values();
        for (Movie movie: movieCollection) {
            str.add(movie.getTitle());
        }
        return str;
    }

    public List<Movie> getMovies()
    {
        List<Movie> movieList = new ArrayList<Movie>();
        Collection<Movie> movieCollection = hashMap.values();
        for (Movie movie: movieCollection) {
            movieList.add(movie);
        }
        return movieList;
    }

    public void WriteCSV()
    {
        String path = "movies.csv";  //path store

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

