package com.example.childapp;

//import android.graphics.Color;

import java.io.Serializable;

/**
 * SHAPE CLASS:
 * Abstract class of shape. Defines getters to find the actual shape and color of a given item
 */
public abstract class Shape implements Serializable {

    // private member
    private Name _name;
    private SelectedColor _color;

    public Shape(Name name, SelectedColor color) {
        _name = name;
        _color = color;
    }

    // GETTERS
    public Name getShape() {
        return _name;
    }

    public SelectedColor getColor() {
        return _color;
    }

}
