package org.esilv.ibo.movies.model;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Movies
 * Created by louis on 24/11/2015.
 */
public class Main {
    public static void main(String[] args)
    {
        Filmotheque f = new Filmotheque();

        /*f.AddFilm();
        f.AddFilm();*/

        BufferedReader br = null;

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("./SaveFilms.csv"));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
                //TODO: A finir

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        //f.ReadList();

        //f.SaveList();






    }
}

