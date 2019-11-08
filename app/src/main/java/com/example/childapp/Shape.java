package com.example.childapp;

//import android.graphics.Color;

public abstract class Shape {

    // private member
    private Name _name;
    private SelectedColor _color;

    public Shape(Name name, SelectedColor color) {
        _name = name;
        _color = color;
    }

    // pure virtual function
    abstract void draw();

    // GETTERS
    public Name getShape() {
        return _name;
    }

    public SelectedColor getColor() {
        return _color;
    }


    // SETTER

    //abstract ShapeName getShape();

    //abstract Color getColor();



}
