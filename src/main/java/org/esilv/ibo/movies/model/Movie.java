package org.esilv.ibo.movies.model;

import javafx.beans.property.SimpleStringProperty;

public class Movie {

    private SimpleStringProperty title;
    private SimpleStringProperty category;

    public Movie(String Ttitle, String Ccategory) {
        this.title = new SimpleStringProperty(Ttitle);
        this.category = new SimpleStringProperty(Ccategory);
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String Ttitle) {
        this.title.set(Ttitle);
    }

    public String getCategory() {
        return category.get();
    }

    public void setCategory(String Ccategory) {
        this.category.set(Ccategory);
    }
}
