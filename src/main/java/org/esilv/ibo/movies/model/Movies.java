package org.esilv.ibo.movies.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Louis on 02/12/2015.
 */
public class Movies
{
    Set<Movie> movieSet;

    public Movies() {
        movieSet = new HashSet<Movie>();
    }

    public boolean AddMovie(Movie movie)
    {

        if (!movieSet.contains(movie)) {
            movieSet.add(movie);
            return true;
        }

        return false;
    }

    public boolean RmMovie(Movie movie) {
        if (movieSet.contains(movie)) {
            movieSet.remove(movie);
            return true;
        }
        return false;
    }

    public Iterator<Movie> getMovies()
    {
        return movieSet.iterator();
    }

}

