package com.example.childapp;

import android.util.Log;

import java.io.Serializable;

/**
 * The Star class handles the creation of a Star shape
 */
public class Star extends Shape implements Serializable {

    public Star(SelectedColor color) {
        super(Name.Star, color);
        Log.i("Star","Created a "  + color + " Star");
    }
}
