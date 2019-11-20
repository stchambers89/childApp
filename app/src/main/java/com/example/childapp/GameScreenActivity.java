package com.example.childapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.ConstraintTableLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;
import java.util.Stack;

public class GameScreenActivity extends AppCompatActivity {

    //Game game;
    ConstraintLayout li;
    private int gameMode;

    private static final String TAG = "GameScreenActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        li = (ConstraintLayout) findViewById(R.id.gamescreen_background);

        Intent intent = getIntent();
        gameMode = intent.getIntExtra(MainActivity.GAME_MODE, -1);

        Log.i(TAG, "Game_mode=" + gameMode);
        if (gameMode == -1) {
            Log.e(TAG, "ERROR: GAME MODE SHOULD NEVER BE -1");
        }


        ShapeBuilder shapeBuilder = new ShapeBuilder(gameMode);
        Stack<List<Shape>> stackOfShapes = shapeBuilder.getStackofShapes();

    }
     /*   Log.v ("Launching issues", "This is launching from oncreate in game screen");
        Intent intent = getIntent();
        int gameMode = intent.getIntExtra(MainActivity.GAME_MODE, -1);
*/

       // if (gameMode == -1) {

        //}





        // Create a ViewModel the first time the system calls an activity's onCreate() method.
        // Re-created activities receive the same CustomViewModel instance created by the first activity.
        // https://developer.android.com/topic/libraries/architecture/viewmodel.html

       /* CustomViewModel model = ViewModelProviders.of(this).get(CustomViewModel.class);
        model.getShapes().observe(this, shapes -> {
            // Update UI
        });
    }


    /**
     * This callback should use "ViewModel" to handle configuration changes (like screen rotation) and
     * "onSaveInstanceState()" as a back-up to handle system-initiated process death.
     * https://developer.android.com/topic/libraries/architecture/saving-states.html
     */
   // @Override
    //protected void onStop() {
      //  super.onStop();
//    }


    public void testEndingScreen(View view) {
        //li.setBackgroundColor();

        // simplyt test ending screen
        Intent intent = new Intent(this, EndingScreenActivity.class);
        startActivity(intent);


    }
}
