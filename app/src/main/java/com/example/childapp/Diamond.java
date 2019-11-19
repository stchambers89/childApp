package com.example.childapp;


import android.util.Log;

public class Diamond extends Item implements Shape{

    public Diamond(SelectedColor color) {
        super(Name.Diamond, color);
        Log.i("Diamond","Created a "  + color + " Diamond");
    }

    @Override
    public void draw() {
        // stub
    }

    @Override
    public Name getShapeName() { return getShape(); }

    @Override
    public SelectedColor getShapeColor() { return getColor(); }

    @Override
    public void changeShapeColor(SelectedColor color) { changeColor(color); }
}
