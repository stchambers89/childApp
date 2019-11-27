package com.example.childapp;


import android.util.Log;

public class Diamond extends Shape {

    public Diamond(SelectedColor color) {
        super(Name.Diamond, color);
        Log.i("Diamond","Created a "  + color + " Diamond");
    }
}
