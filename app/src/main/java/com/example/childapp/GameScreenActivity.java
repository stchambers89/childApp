package com.example.childapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.google.gson.Gson;
import android.content.SharedPreferences;
import android.os.Bundle;

public class GameScreenActivity extends AppCompatActivity {

    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        // Create a ViewModel the first time the system calls an activity's onCreate() method.
        // Re-created activities receive the same CustomViewModel instance created by the first activity.

        CustomViewModel model = ViewModelProviders.of(this).get(CustomViewModel.class);
        model.getShapes().observe(this, shapes -> {
            // Update UI
        });
    }


    /**
     * This callback should use "ViewModel" to handle configuration changes (like screen rotation) and
     * "onSaveInstanceState()" as a back-up to handle system-initiated process death.
     * https://developer.android.com/topic/libraries/architecture/saving-states.html
     */
    @Override
    protected void onStop() {
        super.onStop();
    }
}
