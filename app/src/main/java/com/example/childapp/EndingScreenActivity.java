package com.example.childapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.gson.Gson;

public class EndingScreenActivity extends AppCompatActivity {

    int Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending_screen);
    }
/*
    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences achievements = getSharedPreferences("ACHIEVEMENTS", MODE_PRIVATE);
        SharedPreferences.Editor editor = achievements.edit();

        SharedPreferences sharedPref = getSharedPreferences("ACHIEVEMENTS", MODE_PRIVATE);


        Gson gson = new Gson();
        gson.toJson(_game.get_shapes());

        editor.putString("shapes", gson.toString());

    }
  */

}

