package com.example.childapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * Achievement page class views a pop up that displays the achievements
 *
 */
public class AchievementPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement_page);

        // alter window dimensions to display popup
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        // scale
        getWindow().setLayout((int) (width * 0.9), (int) (height * 0.85));

        // get trophies from SharedPreferences
        SharedPreferences sharedPref = getSharedPreferences("achievement_file", MODE_PRIVATE);
        int numOfTrophies = sharedPref.getInt("Trophy Count", 0);

        // display number of trophies. <onCreate() would probably never display anything>
        Log.i("Achievements Page", "You have " + numOfTrophies + " trophies!");

    }
}
