package org.esilv.ibo.movies.model;


/**
 * Movies
 * Created by louis on 24/11/2015.
 */
public class Main {
    public static void main(String[] args)
    {
        Filmotheque f = new Filmotheque();
        for (int i =0; i<3; i++)
        {
            f.AddFilm();
        }
        f.ReadList();

        f.SaveList();
    }
}

