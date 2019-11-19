package com.example.childapp;

import android.util.Log;

public class Star extends Item implements Shape {

    public Star(SelectedColor color) {
        super(Name.Star, color);
        Log.i("Star","Created a Star");
    }

    @Override
    public void draw() {

    }
}
