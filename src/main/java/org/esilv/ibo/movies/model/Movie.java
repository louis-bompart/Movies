package org.esilv.ibo.movies.model;


public class Movie {

    private String title;
    private String category;

    public Movie(String title, String category) {
        this.title = title;
        this.category = category;
    }

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

    @Override
    public boolean equals(Object obj) {
        return (title == ((Movie) obj).getTitle() && category == ((Movie) obj).getCategory());
    }

    @Override
    public int hashCode() {
        return title.hashCode() + category.hashCode();
    }
}
