package com.example.childapp;

import android.util.Log;

import java.io.Serializable;

/**
 * The Triangle class handles the creation of a Triangle shape
 */
public class Triangle extends Shape implements Serializable {

    public Triangle(SelectedColor color) {

        super(Name.Triangle, color);
        Log.i("Triangle","Created a " + color + " Triangle");
    }
}
