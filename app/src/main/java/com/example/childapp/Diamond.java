package com.example.childapp;


public class Diamond extends Item implements Shape{

    public Diamond(SelectedColor color) {
        super(Name.Diamond, color);
    }

    @Override
    public void draw() {
        // stub
    }
}
