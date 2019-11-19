package com.example.childapp;

import android.util.Log;

public class Heart extends Item implements Shape {

    public Heart(SelectedColor color) {

        super(Name.Heart, color);
        Log.i("Heart","Created a " + color + " Heart");
    }

    @Override
    public void draw() {

    }

    @Override
    public Name getShapeName() { return getShape(); }

    @Override
    public SelectedColor getShapeColor() { return getColor(); }

    @Override
    public void changeShapeColor(SelectedColor color) { changeColor(color); }
}
