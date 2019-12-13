package com.example.childapp;

import android.graphics.Color;
import android.util.Log;

import java.io.Serializable;

/**
 * The Square class handles the creation of a Square shape
 */
public class Square extends Shape implements Serializable {


    // DEFAULT CONSTRUCTOR
    public Square(SelectedColor color) {
        super(Name.Square, color);
        Log.i("Square","Created a "  + color + " Square");
    }
}
