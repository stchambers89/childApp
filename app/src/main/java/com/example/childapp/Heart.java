package com.example.childapp;

import android.util.Log;

public class Heart extends Shape {

    public Heart(SelectedColor color) {

        super(Name.Heart, color);
        Log.i("Heart","Created a " + color + " Heart");
    }

}
