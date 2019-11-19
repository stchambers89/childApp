package com.example.childapp;

import android.graphics.Color;
import android.util.Log;

public class Square extends Item implements Shape {


    // DEFAULT CONSTRUCTOR
    public Square(SelectedColor color) {
        super(Name.Square, color);
        Log.i("Square","Created a Square");
    }

    @Override
    public void draw() {
        // stub
    }

}
