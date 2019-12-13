package com.example.childapp;

import android.util.Log;

import java.io.Serializable;

public class Heart extends Shape implements Serializable {

    public Heart(SelectedColor color) {

        super(Name.Heart, color);
        Log.i("Heart","Created a " + color + " Heart");
    }

}
