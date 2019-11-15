package com.example.childapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

public class AchievementPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement_page);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.8));

        // get trophies
        SharedPreferences sharedPref = getSharedPreferences("achievement_file", MODE_PRIVATE);
        int numOfTrophies = sharedPref.getInt("Trophy Count", 0);

        // display number of trophies. <onCreate() would probably never display anything>
        Log.i("Achievements Page", "You have " + numOfTrophies + " trophies!");

    }
}
