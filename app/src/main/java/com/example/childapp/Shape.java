package com.example.childapp;

//import android.graphics.Color;

public abstract class Shape {

    // private member
    private Name _name;
    private SelectedColor _color;
    // private boolean _isMain;

    public Shape(Name name, SelectedColor color/*, boolean isMain*/) {
        _name = name;
        _color = color;
        // _isMain = isMain;
    }

    // pure virtual function
    // abstract void draw();

    // GETTERS
    public Name getShape() {
        return _name;
    }

    public SelectedColor getColor() {
        return _color;
    }

    public void changeColor(SelectedColor color) { this._color = color; }

    // SETTER

    //abstract ShapeName getShape();

    //abstract Color getColor();

    // "Testing Adam Branch"



}
