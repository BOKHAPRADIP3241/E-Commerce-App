package com.example.e_commerce.Model;


public class CategoryModel {
    String name,icon,color,brief;
    int id;

    public CategoryModel(String name, String icon, String color, String brief, int id) {
        this.name = name;
        this.icon = icon;
        this.color = color;
        this.brief = brief;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
