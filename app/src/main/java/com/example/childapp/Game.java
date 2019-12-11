package com.example.childapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private int gameMode;
    private List<Shape> shapes;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private Context context;
    private Activity a;
    private int round;
    private int score;
    private int getGameMode;

    Game(Context context) {
        a = (GameScreenActivity) context;
        round = 1;
    }

    public void setGameMode(int mode) {
        this.gameMode = mode;
    }

    public int getGameMode() {
        return gameMode;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public Map<SelectedColor, Integer> initiateColors() {
        Map<SelectedColor, Integer> colors = new HashMap<SelectedColor, Integer>();
        colors.put(SelectedColor.Red, Color.RED);
        colors.put(SelectedColor.Yellow, Color.YELLOW);
        colors.put(SelectedColor.Blue, Color.BLUE);
        colors.put(SelectedColor.Green, Color.rgb(57, 255, 20));
        colors.put(SelectedColor.Orange, Color.rgb(255,159,0));
        colors.put(SelectedColor.Purple, Color.rgb(255,0,255));
        return colors;
    }

    public void setContentView() {
        //Set background based off of gameMode
        switch(gameMode) {
            case 1:
                a.setContentView(R.layout.activity_game_screen);
                break;

            case 2:
                a.setContentView(R.layout.activity_game_screen_color);
                break;

            case 3:
                a.setContentView(R.layout.activity_game_screen_night);
                break;
        }
    }



    
}
