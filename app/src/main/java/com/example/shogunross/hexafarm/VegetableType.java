package com.example.shogunross.hexafarm;

/**
 * Created by ShogunRoss on 11/17/2017.
 */

public class VegetableType {
    private String name;
    private String description;
    private int image;

    public VegetableType(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
