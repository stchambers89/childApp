package com.example.childapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Activity that shows the user's score and achievement
 *
 * @author Ryan Arveseth, Steven Chambers, Adam Gerhartz
 */
public class EndingScreenActivity extends AppCompatActivity {

    static int numOfTrophies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ending_screen);
        numOfTrophies = 0;

        // build a pop up by simply altering the window dimensions
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        // scale window dimensions
        getWindow().setLayout((int) (width * 0.9), (int) (height * 0.85));

    }

    /**
     * Go Home navigates back to MainActivity
     * @param view
     */
    public void goHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Save the user's achievements to the SharedPreferences file
     * @param view
     */
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

