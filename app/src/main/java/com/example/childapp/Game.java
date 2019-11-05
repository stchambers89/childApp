package com.example.childapp;

public class Game implements Runnable {
    private int gameMode;

    Game(int gameMode) { this.gameMode = gameMode; }

    public int getGameMode() { return gameMode; }

    @Override
    public void run() {

    }
}
