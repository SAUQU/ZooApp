package com.example.segundoauqui.zooapp;

import java.io.Serializable;

/**
 * Created by segundoauqui on 8/12/17.
 */

public class Food implements Serializable{


    String dishName;
    int price;
    int calories;
    double rating;

    public Food(String dishName, int price, int calories, double rating) {
        this.dishName = dishName;
        this.price = price;
        this.calories = calories;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Food{" +
                "dishName='" + dishName + '\'' +
                ", price=" + price +
                ", calories=" + calories +
                ", rating=" + rating +
                '}';
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
