package com.example.segundoauqui.zooapp;

/**
 * Created by segundoauqui on 8/11/17.
 */

public class Categories {
    int id;
    String categories;
    String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categories(int id, String categories, String description) {
        this.id = id;
        this.categories = categories;
        this.description = description;
    }
}