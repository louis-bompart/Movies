package org.esilv.ibo.movies.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Louis on 02/12/2015.
 */
public class Movies
{
    private final Set<Movie> movieSet;

    public Movies() {
        movieSet = new HashSet<>();
    }

    public void AddMovie(Movie movie)
    {
        if (!movieSet.contains(movie)) {
            movieSet.add(movie);
        }

    }

    public void RmMovie(Movie movie) {
        if (movieSet.contains(movie)) {
            movieSet.remove(movie);
        }
    }

    public Iterator<Movie> getMovies()
    {
        return movieSet.iterator();
    }

}

