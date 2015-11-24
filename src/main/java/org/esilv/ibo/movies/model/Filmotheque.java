package org.esilv.ibo.movies.model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.String;
import java.lang.System;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Maxime on 24/11/2015.
 */
public class Filmotheque {

    List<Film> listFilms;


    public Filmotheque() {
        this.listFilms = new ArrayList<Film>();
        }

    public void AddFilm()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the title of your film");
        String name = sc.nextLine();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter the type of your film");
        String type = sc2.nextLine();

        Film c = new Film(name, type);

        listFilms.add(c);
    }

    public void ReadList()
    {
        for (Film listFilm : listFilms) {
            System.out.println("listFilm = " + listFilm);
        }
    }

    public void SaveList()
    {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("SaveFilms.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //TODO : Gerer proprepment l'exception
        }

        for (Film listFilm : listFilms) {
            writer.println(listFilm);
        }

        writer.close();
    }



}

