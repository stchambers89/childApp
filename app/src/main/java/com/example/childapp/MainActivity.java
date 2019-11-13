package com.example.childapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

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
        Game game = new Game(1);
        game.run();
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



