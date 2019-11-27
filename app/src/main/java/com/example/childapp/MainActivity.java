package com.example.childapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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


}



