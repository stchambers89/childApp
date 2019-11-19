package com.example.childapp;

public interface Shape {
    void draw();
    Name getShapeName();
    SelectedColor getShapeColor();
    void changeShapeColor(SelectedColor color);
}
