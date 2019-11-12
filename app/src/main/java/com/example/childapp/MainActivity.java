package com.example.childapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   /* public static int initiateGameModeOne(View view) {
        // DON'T FORGET TO ADD MULTI-THREADING
        Game game = new Game(1);
        game.run();
        return game.getGameMode();
    }

    public static int initiateGameModeTwo(View view) {
        // DON'T FORGET TO ADD MULTI-THREADING
        Game game = new Game(2);
        game.run();
        return game.getGameMode();
    }

    public static int initiateGameModeThree(View view) {
        // DON'T FORGET TO ADD MULTI-THREADING
        Game game = new Game(3);
        game.run();
        return game.getGameMode();
    }*/
}



/*

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences achievements = getSharedPreferences("ACHIEVEMENTS", MODE_PRIVATE);
        SharedPreferences.Editor editor = achievements.edit();


        SharedPreferences achievements = getSharedPreferences("ACHIEVEMENTS", MODE_PRIVATE);


        editor.putInt("gameMode", _game.get_gameMode());

        Gson gson = new Gson();
        gson.toJson(_game.get_shapes());

        editor.putString("shapes", gson.toString());

    }


 */