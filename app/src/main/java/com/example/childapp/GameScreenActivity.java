package com.example.childapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.ConstraintTableLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;
import java.util.Stack;

public class GameScreenActivity extends AppCompatActivity {

    //Game game;
    ConstraintLayout li;
    private int gameMode;

    private static final String TAG = "GameScreenActivity";

    private ImageView _shape1;
    private ImageView _shape2;
    private ImageView _shape3;
    private ImageView _mainShape;



    private ViewGroup mainLayout;
    private int xDelta;
    private int yDelta;

    private ViewGroup _rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        li = findViewById(R.id.gamescreen_background);

        Intent intent = getIntent();
        gameMode = intent.getIntExtra(MainActivity.GAME_MODE, -1);

        Log.i(TAG, "Game_mode=" + gameMode);
        if (gameMode == -1) {
            Log.e(TAG, "ERROR: GAME MODE SHOULD NEVER BE -1");
        }

        ShapeBuilder shapeBuilder = new ShapeBuilder(gameMode);
        Stack<List<Shape>> stackOfShapes = shapeBuilder.getStackofShapes();

        // for loop 10 times

        _shape1 = (ImageView) findViewById(R.id.shape1);
        _shape2 = (ImageView) findViewById(R.id.shape2);
        _shape3 = (ImageView) findViewById(R.id.shape3);
        _mainShape = (ImageView) findViewById(R.id.mainShape);

        int index;
        for (int i = 0; i < 10; i++) {


            List<Shape> round = stackOfShapes.pop();
            index = 0;

            Log.i(TAG, "MAIN SHAPE: " + round.get(0).toString());
            Log.i(TAG, "SHAPE 1: " + round.get(1).toString());
            Log.i(TAG, "SHAPE 2: " + round.get(2).toString());
            Log.i(TAG, "SHAPE 3: " + round.get(3).toString());

            for (Shape shape : round) {

                switch (shape.getShape().toString()) {
                    // find shape structure
                    case "Circle":
                        //
                        switch (index) {
                            case 0:
                                _mainShape.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                                break;
                            case 1:
                                _shape1.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                                break;
                            case 2:
                                _shape2.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                                break;
                            case 3:
                                _shape3.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                                break;
                        }

                    case "Diamond":
                        switch (index) {
                            case 0:
                                _mainShape.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                                break;
                            case 1:
                                _shape1.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                                break;
                            case 2:
                                _shape2.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                                break;
                            case 3:
                                _shape3.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                                break;
                        }
                        Log.i(TAG, "DIAMOND INSTEAD OF HEART");
                        break;
                    case "Heart":
                        switch (index) {
                            case 0:
                                _mainShape.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                                break;
                            case 1:
                                _shape1.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                                break;
                            case 2:
                                _shape2.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                                break;
                            case 3:
                                _shape3.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                                break;
                        }
                        break;
                    case "Square":
                        switch (index) {
                            case 0:
                                _mainShape.setImageDrawable(getResources().getDrawable(R.drawable.square));
                                break;
                            case 1:
                                _shape1.setImageDrawable(getResources().getDrawable(R.drawable.square));
                                break;
                            case 2:
                                _shape2.setImageDrawable(getResources().getDrawable(R.drawable.square));
                                break;
                            case 3:
                                _shape3.setImageDrawable(getResources().getDrawable(R.drawable.square));
                                break;
                        }
                        break;
                    case "Star":
                        switch (index) {
                            case 0:
                                _mainShape.setImageDrawable(getResources().getDrawable(R.drawable.star));
                                break;
                            case 1:
                                _shape1.setImageDrawable(getResources().getDrawable(R.drawable.star));
                                break;
                            case 2:
                                _shape2.setImageDrawable(getResources().getDrawable(R.drawable.star));
                                break;
                            case 3:
                                _shape3.setImageDrawable(getResources().getDrawable(R.drawable.star));
                                break;
                        }
                        break;
                    case "Triangle":
                        switch (index) {
                            case 0:
                                _mainShape.setImageDrawable(getResources().getDrawable(R.drawable.triangle));
                                break;
                            case 1:
                                _shape1.setImageDrawable(getResources().getDrawable(R.drawable.triangle));
                                break;
                            case 2:
                                _shape2.setImageDrawable(getResources().getDrawable(R.drawable.triangle));
                                break;
                            case 3:
                                _shape3.setImageDrawable(getResources().getDrawable(R.drawable.triangle));
                                break;
                        }
                        break;
                }
                index += 1;
            }
        }

        // assign/change shapes to views

        // change color based on color of shape
        //switch if round.get(0).getColor() == "RED":








        _shape1.setOnTouchListener(onTouchListener(_shape1));
        _shape2.setOnTouchListener(onTouchListener(_shape2));
        _shape3.setOnTouchListener(onTouchListener(_shape3));


        /*_shape1.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        _shape2.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        _shape3.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        _mainShape.setImageDrawable(getResources().getDrawable(R.drawable.circle));*/


        _mainShape.setOnDragListener(onDragListener());
    }

    private View.OnTouchListener onTouchListener(ImageView img) {

        return (v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(img);
                v.startDrag(data, shadow, v, 0);
                return true;
            }
            return false;
        };
    }


    private View.OnDragListener onDragListener() {
        return new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                //final int action = event.getAction();
                if (event.getResult()) {
                    Log.i("DROP", "Successfully Dropped the Shape into MainShape");
                    // Compare 
                }
                return true;
            }
        };
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

        // simply test ending screen
        Intent intent = new Intent(this, EndingScreenActivity.class);
        startActivity(intent);


    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
