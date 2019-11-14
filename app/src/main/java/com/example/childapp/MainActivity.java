package com.example.childapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 *
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

        //return game.getGameMode();   // in order for onClick to work, it cannot return anything
    }


    // STRETCH CHALLENGE --- OTHER GAME MODES
    /*public static int initiateGameModeTwo(View view) {
        // DON'T FORGET TO ADD MULTI-THREADING
        Game game = new Game(2);
        game.run();
        return game.getGameMode();
    }

    // STRETCH CHALLENGE --- OTHER GAME MODES
    public static int initiateGameModeThree(View view) {
        // DON'T FORGET TO ADD MULTI-THREADING
        Game game = new Game(3);
        game.run();
        return game.getGameMode();
    }*/

}



