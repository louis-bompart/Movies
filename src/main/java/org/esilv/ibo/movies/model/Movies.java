package org.esilv.ibo.movies.model;

import java.util.HashMap;

/**
 * Created by Louis on 02/12/2015.
 */
public class Movies {
    HashMap<Integer, Movie> hashMap;

    public Movies() {
    }

    public boolean AddMovie(Movie movie) {
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
}

