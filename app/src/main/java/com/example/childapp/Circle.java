package com.example.childapp;

import android.graphics.Color;
import android.util.Log;

import java.util.Random;

/**
 * CIRCLE CLASS:
 * instructions on how to build a circle and the draw method
 */
public class Circle extends Shape {

    //private Name shape;

    // DEFAULT
    public Circle(SelectedColor color) {
        super(Name.Circle, color);

        Log.i("Circle","Created a " + color + " Circle");
        //Need getcolor() to pick random
        //Maybe keep all colors random at create time, then when we add them to data struc
        //we change one of the colors depending on "correct shape"
    }


    // DRAW
    @Override
    public void draw() {
        // stub
    }

    /*public ShapeName getShape() {return ShapeName.Circle;}

    public Color getColor() {
        int[] shapeColor = getResources().getIntArray(R.array.shapeColors);
        int randomColor = shapeColor[new Random().nextInt(shapeColor.length)];

        return randomColor;
    }  */

}
