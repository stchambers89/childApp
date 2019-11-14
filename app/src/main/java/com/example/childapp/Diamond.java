package com.example.childapp;

public class Diamond extends Item implements Shape{

    public Diamond() {
        super(Name.Diamond, SelectedColor.Orange);
    }


    @Override
    public void draw() {
        // stub
    }
}
