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

    //A collection can be used easily with iterator (like in C++)
    public Collection<Movie> getMovies()
    {
        return hashMap.values();
    }
}

