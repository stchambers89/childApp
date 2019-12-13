package com.example.childapp;


import android.util.Log;

import java.io.Serializable;

/**
 * The Diamond class handles the creation of a Diamond shape
 */
public class Diamond extends Shape implements Serializable {

    public Diamond(SelectedColor color) {
        super(Name.Diamond, color);
        Log.i("Diamond","Created a "  + color + " Diamond");
    }
}
