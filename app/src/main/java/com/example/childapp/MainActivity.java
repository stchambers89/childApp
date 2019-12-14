package com.example.childapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Main activity that displays the menu/selection screen.
 *
 * @author Ryan Arveseth, Steven Chambers, Adam Gerhartz
 * this is how to create javadoc, use second answer its better:
 * https://stackoverflow.com/questions/29162820/how-to-create-javadoc-using-android-studio-without-r-and-buildconfig/31302641#31302641
 */
public class MainActivity extends AppCompatActivity {

    public static final String GAME_MODE = "com.example.childapp.GAMEMODE";
    private ImageView shape_game;
    private ImageView color_game;
    private ImageView shape_and_color_game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shape_game = (ImageView) findViewById(R.id.shape_game);
        color_game = (ImageView) findViewById(R.id.color_game);
        shape_and_color_game = (ImageView) findViewById(R.id.shape_and_color_game);
    }

    /**
     * This method is run when @id "shape_game"'s onClick event is triggered.
     * This runs the program.
     * @param view
     */

    public void initiateGameModeOne(View view) {
        Intent intent = new Intent(this, GameScreenActivity.class);
        intent.putExtra(GAME_MODE, 1);
        startActivity(intent);
    }

    /**
     * This method is run when @id "color_game"'s onClick event is triggered.
     * This runs the second game mode.
     * @param view
     */
    public void initiateGameModeTwo(View view) {
        Intent intent = new Intent(this, GameScreenActivity.class);
        intent.putExtra(GAME_MODE, 2);
        startActivity(intent);
    }

    /**
     * This method is run when @id "shape_and_color_game"'s onClick event is triggered.
     * This runs the third game mode
     * @param view
     */
    public void initiateGameModeThree(View view) {
        Intent intent = new Intent(this, GameScreenActivity.class);
        intent.putExtra(GAME_MODE, 3);
        startActivity(intent);
    }

    /**
     * This method will invoke a new activity that displays achievements
     * @param view
     */
    public void runAchievementPage(View view) {
        Intent intent = new Intent(this, AchievementPage.class);
        startActivity(intent);
    }
}



