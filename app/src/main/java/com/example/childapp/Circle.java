package com.example.childapp;

import android.graphics.Color;
import android.util.Log;

import java.util.Random;


public class Circle extends Item implements Shape {

    //private Name shape;

    // DEFAULT
    public Circle(SelectedColor color) {
        super(Name.Circle, color);

        Log.i("Circle","Created a Circle");
        //Need getcolor() to pick random
        //Maybe keep all colors random at create time, then when we add them to data struc
        //we change one of the colors depending on "correct shape"
    }


    // DRAW
    public void draw() {
        // stub
    }

    /*public ShapeName getShape() {return ShapeName.Circle;}

    public Color getColor() {
        int[] shapeColor = getResources().getIntArray(R.array.shapeColors);
        int randomColor = shapeColor[new Random().nextInt(shapeColor.length)];

        return randomColor;
    }*/
}
