package com.example.childapp;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int _gameMode;
    private List<Shape> _shapes;

    Game(int gameMode) {
        _gameMode = gameMode;
        _shapes = new ArrayList<Shape>();
    }

    Game(int gameMode, ArrayList<Shape> shapes) {
        _gameMode = gameMode;
        _shapes = shapes;
    }

}
