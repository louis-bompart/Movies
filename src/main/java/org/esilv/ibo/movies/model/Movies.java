package org.esilv.ibo.movies.model;

import java.util.HashMap;

/**
 * Created by Louis on 02/12/2015.
 */
public class Movies {
    HashMap<Integer, Movie> hashMap;

    public Movies() {
    }

    public void AddMovie(Movie movie) {
        if (!hashMap.containsKey(movie.hashCode()))
            hashMap.put(movie.hashCode(), movie);
    }

    public void RmMovie(int hashcode) {
        if (hashMap.containsKey(hashcode)) {
            hashMap.remove(hashcode);
        }
    }
}

