package org.esilv.ibo.movies.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Movie {

    private SimpleStringProperty title;
    private SimpleStringProperty category;

    public Movie(String Ttitle, String Ccategory) {
        this.title = new SimpleStringProperty(Ttitle);
        this.category = new SimpleStringProperty(Ccategory);
    }

    public StringProperty getTitle() {
        return title;
    }

    public void setTitle(String Ttitle) {
        this.title.set(Ttitle);
    }

    public StringProperty getCategory() {
        return category;
    }

    public void setCategory(String Ccategory) {
        this.category.set(Ccategory);
    }
}
