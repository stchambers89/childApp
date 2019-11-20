package com.example.childapp;

import android.util.Log;

public class Star extends Shape {

    public Star(SelectedColor color) {
        super(Name.Star, color);
        Log.i("Star","Created a "  + color + " Star");
    }


    public void draw() {

    }
}
