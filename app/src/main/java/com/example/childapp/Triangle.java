package com.example.childapp;

import android.util.Log;

public class Triangle extends Item implements Shape {

    public Triangle(SelectedColor color) {

        super(Name.Triangle, color);
        Log.i("Triangle","Created a Triangle");
    }

    @Override
    public void draw() {

    }
}
