package com.example.childapp;

import android.graphics.Color;

public abstract class Item {

    // private member
    private ShapeName _shape;
    private String _color;

    public Item(ShapeName shape, String color) {
        _shape = shape;
        _color = color;
    }

    // pure virtual function
    abstract void draw();

    // GETTERS
    public ShapeName getShape() {
        return _shape;
    }

    public String getColor() {
        return _color;
    }


    // SETTER

    //abstract ShapeName getShape();

    //abstract Color getColor();



}
