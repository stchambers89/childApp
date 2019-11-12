package com.example.childapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class AchievementPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement_page);

        // get trophies
        SharedPreferences sharedPref = getSharedPreferences("achievement_file", MODE_PRIVATE);
        int numOfTrophies = sharedPref.getInt("Trophy Count", 0);

        // display number of trophies. <onCreate() would probably never display anything>
        Log.i("Achievements Page", "You have " + numOfTrophies + " trophies!");

    }
}
