package com.example.childapp;

import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import android.content.SharedPreferences;
import android.os.Bundle;

public class GameScreen extends AppCompatActivity {

    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
    }
    // Here's our main game activity

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences sharedPref = getSharedPreferences("GAME_STATE", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putInt("gameMode", game.get_gameMode());

        Gson gson = new Gson();
        gson.toJson(game.get_shapes());

        editor.putString("shapes", gson.toString());

    }

}
