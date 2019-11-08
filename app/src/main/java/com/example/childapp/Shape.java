package com.example.childapp;

import android.graphics.Color;

public abstract class Shape {

    // private member
    private Name _shape;
    private Color _color;

    public Shape(Name shape, Color color) {
        _shape = shape;
        _color = color;
    }

    // pure virtual function
    abstract void draw();

    // GETTERS
    public Name getShape() {
        return _shape;
    }

    public Color getColor() {
        return _color;
    }


    // SETTER

    //abstract ShapeName getShape();

    //abstract Color getColor();



}
