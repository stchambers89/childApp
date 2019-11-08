package com.example.childapp;

import android.graphics.Color;

public abstract class Shape {

    // private member
    private Name _name;
    private Color _color;

    public Shape(Name name, Color color) {
        _name = name;
        _color = color;
    }

    // pure virtual function
    abstract void draw();

    // GETTERS
    public Name getShape() {
        return _name;
    }

    public Color getColor() {
        return _color;
    }


    // SETTER

    //abstract ShapeName getShape();

    //abstract Color getColor();



}
