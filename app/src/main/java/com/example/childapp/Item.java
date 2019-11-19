package com.example.childapp;

//import android.graphics.Color;

public abstract class Item {

    // private member
    private Name _name;
    private SelectedColor _color;

    public Item(Name name, SelectedColor color) {
        _name = name;
        _color = color;
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
