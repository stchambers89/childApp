package com.example.childapp;

import android.graphics.Color;

import java.util.Random;

import static androidx.core.graphics.drawable.IconCompat.getResources;

public class Circle extends Item {

    // DEFAULT
    public Circle() {
        super("circle", "blue");
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