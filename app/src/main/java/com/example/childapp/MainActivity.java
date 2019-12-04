package com.example.childapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Main activity that displays the menu/selection screen.
 *
 * @author Ryan Arveseth, Steven Chambers, Adam Gerhartz
 * this is how to create javadoc, use second answer its better:
 * https://stackoverflow.com/questions/29162820/how-to-create-javadoc-using-android-studio-without-r-and-buildconfig/31302641#31302641
 */
public class MainActivity extends AppCompatActivity {

    public static final String GAME_MODE = "com.example.childapp.GAMEMODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is run when @id "shape_game"'s onClick event is triggered.
     * This runs the program.
     * @param view
     */
    public void initiateGameModeOne(View view) {
        // DON'T FORGET TO ADD MULTI-THREADING

        Intent intent = new Intent(this, GameScreenActivity.class);
        intent.putExtra(GAME_MODE, 1);
        //resetRoundAndScores();
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        //return game.getGameMode();   // in order for onClick to work, it cannot return anything
    }

    /**
     * This method is run when @id "color_game"'s onClick event is triggered.
     * This runs the second game mode.
     * @param view
     */
    public void initiateGameModeTwo(View view) {
        // DON'T FORGET TO ADD MULTI-THREADING

        Intent intent = new Intent(this, GameScreenActivity.class);
        intent.putExtra(GAME_MODE, 2);
        //resetRoundAndScores();
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        //return game.getGameMode();   // in order for onClick to work, it cannot return anything
    }

    /**
     * This method is run when @id "shape_and_color_game"'s onClick event is triggered.
     * This runs the third game mode
     * @param view
     */
    public void initiateGameModeThree(View view) {
        // DON'T FORGET TO ADD MULTI-THREADING

        Intent intent = new Intent(this, GameScreenActivity.class);
        intent.putExtra(GAME_MODE, 3);
        //resetRoundAndScores();
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        //return game.getGameMode();   // in order for onClick to work, it cannot return anything
    }


    /**
     * This method will invoke a new activity that displays achievements
     * @param view
     */
    public void runAcheivementPage(View view) {
        Intent intent = new Intent(this, AchievementPage.class);
        startActivity(intent);
    }


    /*public void resetRoundAndScores() {
        Log.i("RESETTING","Resetting Scores and Round");
        SharedPreferences prefs;
        SharedPreferences.Editor editor;
        prefs = getApplicationContext().getSharedPreferences("round", Context.MODE_PRIVATE);
        editor = prefs.edit();
        editor.putInt("round", 1);
        editor.putInt("score", 0);
        editor.apply();
    }*/

}



