package org.esilv.ibo.movies.model;

import java.lang.Override;
import java.lang.String;

public class Film {

    String title;
    String category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Film(String title, String category) {
        this.title = title;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Film { " +
                "title = " + title +
                ", category = " + category +
                '}';
    }
}
