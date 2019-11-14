package com.example.childapp;

public class Triangle extends Item implements Shape {

    public Triangle(SelectedColor color) {

        super(Name.Triangle, color);
    }

    @Override
    public void draw() {

    }
}
