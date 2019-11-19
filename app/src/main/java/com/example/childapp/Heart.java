package com.example.childapp;

import android.util.Log;

public class Heart extends Item implements Shape {

    public Heart(SelectedColor color) {

        super(Name.Heart, color);
        Log.i("Heart","Created a Heart");
    }

    @Override
    public void draw() {

    }
}
