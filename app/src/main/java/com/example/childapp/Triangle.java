package com.example.childapp;

public class Triangle extends Item implements Shape {

    public Triangle() {
        super(Name.Triangle, SelectedColor.Yellow);
    }

    @Override
    public void draw() {

    }
}
