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
        final Movie other = (Movie) obj;
        return (title.equals(other.title) && category.equals(other.category));
    }

    @Override
    public int hashCode() {
        return title.hashCode() + category.hashCode();
    }
}
