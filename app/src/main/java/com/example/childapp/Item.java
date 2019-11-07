package com.example.childapp;

import android.graphics.Color;

public abstract class Item {

    // private member
    private String _name;
    private String _color;

    public Item(String name, String color) {
        _name = name;
        _color = color;
    }

    // pure virtual function
    abstract void draw();

    // GETTERS
    public String getName() {
        return _name;
    }

    public String getColor() {
        return _color;
    }


    // SETTER

    //abstract ShapeName getShape();

    //abstract Color getColor();



}
