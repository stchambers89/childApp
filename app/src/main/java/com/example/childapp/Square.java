package com.example.childapp;

import android.graphics.Color;

public class Square extends Item implements Shape {


    // DEFAULT CONSTRUCTOR
    public Square(SelectedColor color) {

        super(Name.Square, color);
    }

    @Override
    public void draw() {
        // stub
    }

}
