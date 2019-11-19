package com.example.childapp;


import android.util.Log;

public class Diamond extends Item implements Shape{

    public Diamond(SelectedColor color) {
        super(Name.Diamond, color);
        Log.i("Diamond","Created a Diamond");
    }

    @Override
    public void draw() {
        // stub
    }
}
