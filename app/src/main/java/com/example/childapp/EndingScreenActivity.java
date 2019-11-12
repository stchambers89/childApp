package com.example.childapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

public class EndingScreenActivity extends AppCompatActivity {

    static int numOfTrophies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending_screen);
        numOfTrophies = 0;
    }

    public void endOnStrongNote(View view) {
        // display Congratulations
        Log.i("Ending Screen", "Congratulations!");

        // Display Trophy won
        Log.i("Ending Screen", "You have " + numOfTrophies + "trophies!");

        // increment number of trophies
        numOfTrophies++;

        // Save to shared preferences
        SharedPreferences sharedPref = getSharedPreferences("achievement_file", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("Trophy Count", numOfTrophies);
        editor.apply();

    }

}

