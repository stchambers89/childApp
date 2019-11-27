package com.example.childapp;


import android.util.Log;
/**
 * The Diamond class handles the creation of a Diamond shape
 */
public class Diamond extends Shape {

    public Diamond(SelectedColor color) {
        super(Name.Diamond, color);
        Log.i("Diamond","Created a "  + color + " Diamond");
    }
}
