package org.esilv.ibo.movies.model;

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
        try
        {

            String path = "C:\\Users\\Raihan\\Desktop\\movies.csv";  //path store

            ArrayList<HashMap<Integer, Movie>> myArrayList = new ArrayList<HashMap<Integer, Movie>>(); //Convert Hashmap to List

            if (hashMap.containsKey(movie.hashCode()))
            {
                return false;
            }
            hashMap.put(movie.hashCode(), movie);

            myArrayList.add(hashMap); //add to List


            FileWriter writer;  //Function to write

            writer = new FileWriter(path, true);  //take path

            for (int i =0; i < myArrayList.size(); i++)  //Browse all hashmap data
            {
                writer.write(myArrayList.get(i).get(movie.hashCode()).getTitle().toString());
                writer.write(";"); //CSV separator
                writer.write(myArrayList.get(i).get(movie.hashCode()).getCategory().toString());
                writer.write("\r\n");
            }

            System.out.println("Write success!");

            writer.close();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }

        return true;

    }

    public boolean RmMovie(int hashcode) {
        if (!hashMap.containsKey(hashcode)) {
            hashMap.remove(hashcode);
            return false;
        }
        return true;
    }

    //A collection can be used easily with iterator (like in C++)
    public Collection<Movie> getMovies()
    {
        return hashMap.values();
    }
}

