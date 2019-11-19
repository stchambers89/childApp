package com.example.childapp;

import android.util.Log;

public class Triangle extends Item implements Shape {

    public Triangle(SelectedColor color) {

        super(Name.Triangle, color);
        Log.i("Triangle","Created a " + color + " Triangle");
    }

    @Override
    public void draw() {

    }

    @Override
    public Name getShapeName() { return getShape(); }

    @Override
    public SelectedColor getShapeColor() { return getColor(); }

    @Override
    public void changeShapeColor(SelectedColor color) { changeColor(color); }
}
