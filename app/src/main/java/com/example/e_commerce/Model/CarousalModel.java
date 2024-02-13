package com.example.e_commerce.Model;

public class CarousalModel {
    int id;
    String image;

    public CarousalModel(int id, String image) {
        this.id = id;
        this.image = image;
    }
    public CarousalModel(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
