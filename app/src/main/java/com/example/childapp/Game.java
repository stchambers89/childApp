package com.example.childapp;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int _gameMode;
    private List<Shape> shapes;

    Game(int gameMode) {
        _gameMode = gameMode;
        shapes = new ArrayList<Shape>();
    }

    // CREATE SHAPES
    private void createShapes() {
        // stub
        // create instances of shapes
        // append to array
    }

    // DELETE ARRAY
    private void clearShapes() {
        // stub
        // question: clear the array or just update the indices?
        // performance issue --- look up what's better
    }

    // add color
    private void setColorsToShape() {
        // stub
        // handles color assignments
    }

    // DRIVER
    public void run() {
        // stub
        // driver
        // create four shapes
        // randomize color
        // check is matches
        // clears list if matched
    }

    private boolean matchShapes() {
        // stub needs to know which game mode
        // this handles the matching logic
        // might not need to pass gamemode
        //
        return true;
    }
}
