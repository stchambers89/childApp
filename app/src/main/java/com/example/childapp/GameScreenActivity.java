package com.example.childapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
/**
 * Handles the creation of a new game and handles shape/color matching.
 */
public class GameScreenActivity extends AppCompatActivity {
    //Game game;
    ConstraintLayout li;
    private int gameMode;
    List<Shape> listOfShapes;
    private int index;
    private int round;
    private static final String TAG = "GameScreenActivity";
    private static final String STACK = "stack";
    private static final String GAME_MODE = "gameMode";
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private ImageView _shape1;
    private ImageView _shape2;
    private ImageView _shape3;
    private ImageView _mainShape;
    private boolean next;
    private ViewGroup mainLayout;
    private int xDelta;
    private int yDelta;

    private ViewGroup _rootLayout;

    /**
     * onCreate creates the game instance and sets onTouchListeners for each of the shapes.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Red, Yellow, Blue, Green, Orange, Purple
        /*
        if (savedInstanceState != null) {
            gameMode = savedInstanceState.getInt(GAME_MODE, 0);
            index = savedInstanceState.getInt("index", 0);
            for (int i = 0; i < index + 1; i++) {
                stackOfShapes.add(savedInstanceState.getParcelableArrayList("ListInStack" + i));
            }
        }
        */

        prefs = getApplicationContext().getSharedPreferences("ROUND_NUM", Context.MODE_PRIVATE);
        editor = prefs.edit();
        round = prefs.getInt("ROUND_NUM",1);

        Map<SelectedColor, Integer> colors = new HashMap<SelectedColor, Integer>();
        colors.put(SelectedColor.Red, Color.RED);
        colors.put(SelectedColor.Yellow, Color.YELLOW);
        colors.put(SelectedColor.Blue, Color.BLUE);
        colors.put(SelectedColor.Green, Color.GREEN);
        colors.put(SelectedColor.Orange, Color.rgb(255,165,0));
        colors.put(SelectedColor.Purple, Color.rgb(255,0,255));

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
        listOfShapes = shapeBuilder.getListofShapes();
        next = false;

        _shape1 = (ImageView) findViewById(R.id.shape1);
        _shape2 = (ImageView) findViewById(R.id.shape2);
        _shape3 = (ImageView) findViewById(R.id.shape3);
        _mainShape = (ImageView) findViewById(R.id.mainShape);

            index = 0;

            Log.i(TAG, "MAIN SHAPE: " + listOfShapes.get(0).toString());
            Log.i(TAG, "SHAPE 1: " + listOfShapes.get(1).toString());
            Log.i(TAG, "SHAPE 2: " + listOfShapes.get(2).toString());
            Log.i(TAG, "SHAPE 3: " + listOfShapes.get(3).toString());

            for (Shape shape : listOfShapes) {
                int c = colors.get(shape.getColor());
                switch (shape.getShape().toString()) {
                    // find shape structure
                    case "Circle":
                        //
                        switch (index) {
                            case 0:
                                _mainShape.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                                _mainShape.setColorFilter(c);
                                _mainShape.setTag(R.drawable.circle);
                                break;
                            case 1:
                                _shape1.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                                _shape1.setColorFilter(c);
                                _shape1.setTag(R.drawable.circle);
                                break;
                            case 2:
                                _shape2.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                                _shape2.setColorFilter(c);
                                _shape2.setTag(R.drawable.circle);
                                break;
                            case 3:
                                _shape3.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                                _shape3.setColorFilter(c);
                                _shape3.setTag(R.drawable.circle);
                                break;
                        }

                    case "Diamond":
                        switch (index) {
                            case 0:
                                _mainShape.setImageDrawable(getResources().getDrawable(R.drawable.diamond));
                                _mainShape.setColorFilter(c);
                                _mainShape.setTag(R.drawable.diamond);
                                break;
                            case 1:
                                _shape1.setImageDrawable(getResources().getDrawable(R.drawable.diamond));
                                _shape1.setColorFilter(c);
                                _shape1.setTag(R.drawable.diamond);
                                break;
                            case 2:
                                _shape2.setImageDrawable(getResources().getDrawable(R.drawable.diamond));
                                _shape2.setColorFilter(c);
                                _shape2.setTag(R.drawable.diamond);
                                break;
                            case 3:
                                _shape3.setImageDrawable(getResources().getDrawable(R.drawable.diamond));
                                _shape3.setColorFilter(c);
                                _shape3.setTag(R.drawable.diamond);
                                break;
                        }
                        break;
                    case "Heart":
                        switch (index) {
                            case 0:
                                _mainShape.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                                _mainShape.setColorFilter(c);
                                _mainShape.setTag(R.drawable.heart);
                                break;
                            case 1:
                                _shape1.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                                _shape1.setColorFilter(c);
                                _shape1.setTag(R.drawable.heart);
                                break;
                            case 2:
                                _shape2.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                                _shape2.setColorFilter(c);
                                _shape2.setTag(R.drawable.heart);
                                break;
                            case 3:
                                _shape3.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                                _shape3.setColorFilter(c);
                                _shape3.setTag(R.drawable.heart);
                                break;
                        }
                        break;
                    case "Square":
                        switch (index) {
                            case 0:
                                _mainShape.setImageDrawable(getResources().getDrawable(R.drawable.square));
                                _mainShape.setColorFilter(c);
                                _mainShape.setTag(R.drawable.square);
                                break;
                            case 1:
                                _shape1.setImageDrawable(getResources().getDrawable(R.drawable.square));
                                _shape1.setColorFilter(c);
                                _shape1.setTag(R.drawable.square);
                                break;
                            case 2:
                                _shape2.setImageDrawable(getResources().getDrawable(R.drawable.square));
                                _shape2.setColorFilter(c);
                                _shape2.setTag(R.drawable.square);
                                break;
                            case 3:
                                _shape3.setImageDrawable(getResources().getDrawable(R.drawable.square));
                                _shape3.setColorFilter(c);
                                _shape3.setTag(R.drawable.square);
                                break;
                        }
                        break;
                    case "Star":
                        switch (index) {
                            case 0:
                                _mainShape.setImageDrawable(getResources().getDrawable(R.drawable.star));
                                _mainShape.setColorFilter(c);
                                _mainShape.setTag(R.drawable.star);
                                break;
                            case 1:
                                _shape1.setImageDrawable(getResources().getDrawable(R.drawable.star));
                                _shape1.setColorFilter(c);
                                _shape1.setTag(R.drawable.star);
                                break;
                            case 2:
                                _shape2.setImageDrawable(getResources().getDrawable(R.drawable.star));
                                _shape2.setColorFilter(c);
                                _shape2.setTag(R.drawable.star);
                                break;
                            case 3:
                                _shape3.setImageDrawable(getResources().getDrawable(R.drawable.star));
                                _shape3.setColorFilter(c);
                                _shape3.setTag(R.drawable.star);
                                break;
                        }
                        break;
                    case "Triangle":
                        switch (index) {
                            case 0:
                                _mainShape.setImageDrawable(getResources().getDrawable(R.drawable.triangle));
                                _mainShape.setColorFilter(c);
                                _mainShape.setTag(R.drawable.triangle);
                                break;
                            case 1:
                                _shape1.setImageDrawable(getResources().getDrawable(R.drawable.triangle));
                                _shape1.setColorFilter(c);
                                _shape1.setTag(R.drawable.triangle);
                                break;
                            case 2:
                                _shape2.setImageDrawable(getResources().getDrawable(R.drawable.triangle));
                                _shape2.setColorFilter(c);
                                _shape2.setTag(R.drawable.triangle);
                                break;
                            case 3:
                                _shape3.setImageDrawable(getResources().getDrawable(R.drawable.triangle));
                                _shape3.setColorFilter(c);
                                _shape3.setTag(R.drawable.triangle);
                                break;
                        }
                        break;
                }
                index += 1;
            }

        _shape1.setOnTouchListener(onTouchListener(_shape1));
        _shape2.setOnTouchListener(onTouchListener(_shape2));
        _shape3.setOnTouchListener(onTouchListener(_shape3));

        _mainShape.setOnDragListener(onDragListener());
    }


    /**
     * This is called when any of the three shapes are dragged.
     * @param img the imageview of the thing being dragged
     * @return returns true if the listener has consumed the event, false if otherwise
     */
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

    /**
     * Handles the shape-matching and detects if a shape has been dropped into the main shape
     * @return this will always return true
     */
    private View.OnDragListener onDragListener() {
        return new View.OnDragListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onDrag(View v, DragEvent event) {
                if (event.getResult()) {
                    int duration = Toast.LENGTH_SHORT;
                    String txt = "";
                    ImageView dragView = (ImageView) event.getLocalState();
                    // Compare
                    switch (gameMode) {
                        case 1:
                            // get shape only
                            if (_mainShape.getTag().toString().equals(dragView.getTag().toString())) {
                                Log.i("MATCH", "You got a match!");
                                // Go to the next round...
                                txt = "Correct Match";
                                next = true;
                            }
                            else {
                                txt = "Incorrect Match";
                            }
                            break;
                        case 2:
                            // get color only
                            if (_mainShape.getColorFilter().equals(dragView.getColorFilter())) {
                                Log.i("MATCH", "You got a match!");
                                // Go to the next round...
                                txt = "Correct Match";
                                next = true;
                            }
                            else {
                                txt = "Incorrect Match";
                            }
                            break;
                        case 3:
                            // get shape and color
                            if (_mainShape.getTag().toString().equals(dragView.getTag().toString()) && _mainShape.getColorFilter().equals(dragView.getColorFilter())) {
                                Log.i("MATCH", "You got a match!");
                                // Go to the next round...
                                txt = "Correct Match";
                                next = true;
                            }
                            else {
                                txt = "Incorrect Match";
                            }
                    }
                    Toast toast = Toast.makeText(getApplicationContext(), txt, duration);
                    toast.show();

                    if (next && round < 10) {
                        round += 1;
                        editor.putInt("ROUND_NUM", round);
                        editor.apply();
                        Log.i("ROUND:", String.valueOf(round));
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                    else {
                        editor.putInt("ROUND_NUM", 1);
                        editor.apply();
                        testEndingScreen(v);
                    }
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
    /*
    /**
     * This handles the saving of the instance state (mainly for when the screen is
     * being changing to landscape/portrait mode).
     * @param outState
     */
    /*@Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index", index);
        for (int i = 0; i < index + 1; i++) {
            outState.putParcelableArrayList("ListInStack" + i, (ArrayList<? extends Parcelable>) stackOfShapes.pop());
        }
        outState.putInt(GAME_MODE, gameMode);
    }*/

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
