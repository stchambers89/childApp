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
import android.util.Log;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Handles the creation of a new game and handles shape/color matching.
 */
public class GameScreenActivity extends AppCompatActivity {

    private static final String TAG = "GameScreenActivity";
    private static final String ROUND = "round";
    private static final String GAME_MODE = "gameMode";
    public static final String SCORE = "score";
    public static final String MATCHES = "matches";
    private static final String HIGH_SCORE = "highScore";

    private int gameMode;
    List<Shape> listOfShapes;
    private int index;
    private int round;
    private Intent intent;
    private int score;
    private int highScore;
    private Game game;
    private boolean firstTry;
    private int matches;

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    private ImageView _shape1;
    private ImageView _shape2;
    private ImageView _shape3;
    private ImageView _mainShape;

    private boolean next;
    private Map<SelectedColor, Integer> colors;


    /**
     * onCreate creates the game instance and sets onTouchListeners for each of the shapes.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        //    getWindow().setEnterTransition(new Explode());
        //}

        /*if (game != null) {

        } else {*/
        super.onCreate(savedInstanceState);
        getGameMode();

        if (intent.getIntExtra(GameScreenActivity.ROUND, 1) != 1) {
            //round = intent.getIntExtra(GameScreenActivity.ROUND, 1);
            //score = intent.getIntExtra(GameScreenActivity.SCORE, 0);
            game = (Game) intent.getParcelableExtra("name_of_extra");

            Log.i(TAG, "game created via parcelable");

        } else {
            game = new Game(gameMode);
            game.set_round(1);
            game.set_score(0);
            Log.i(TAG, "score set");
        }

        Log.i(TAG, "game instantiated");


        /*********** SHARED PREFERENCES ********************/
        prefs = getApplicationContext().getSharedPreferences(HIGH_SCORE, Context.MODE_PRIVATE);
        editor = prefs.edit();
        Log.i(TAG, "sPref");

        /*********** SET COLORS ********************/
        setRgbColors();
        Log.i(TAG, "colors set");

        //super.onCreate(savedInstanceState);
        //getGameMode();

        /************ SET CONTENT VIEW ****************/
        //Set background based off of gameMode
        switch(game.get_gameMode()) {
            case 1:
                setContentView(R.layout.activity_game_screen);
                break;

            case 2:
                setContentView(R.layout.activity_game_screen_color);
                break;

            case 3:
                setContentView(R.layout.activity_game_screen_night);
                break;
        }
        firstTry = true;
        Log.i(TAG, "content view created");


        /************ GET ROUND & SCORE ********************/
        //game.set_round(1);

        // BASE CASE
        if (intent.getIntExtra(GameScreenActivity.ROUND, 1) != 1) {
            //round = intent.getIntExtra(GameScreenActivity.ROUND, 1);
            //score = intent.getIntExtra(GameScreenActivity.SCORE, 0);
            matches = intent.getIntExtra(GameScreenActivity.MATCHES, 0);
            //round = intent.getIntExtra(GameScreenActivity.ROUND, 1);
            //score = intent.getIntExtra(GameScreenActivity.SCORE, 0);
            game = (Game) intent.getParcelableExtra("name_of_extra");

            Log.i(TAG, "game created via parcelable");

        } else {
            game.set_score(0);
            Log.i(TAG, "score set");
        }

        /************* CHECK FOR DATA FROM INSTANCE STATE *****************/
        if (savedInstanceState != null) {
            assert game != null;
            game.set_gameMode(savedInstanceState.getInt(GAME_MODE, 0));
            game.set_round(savedInstanceState.getInt(ROUND, 1));
            game.set_score(savedInstanceState.getInt(SCORE, 0));
            game.set_shapes(getShapes(savedInstanceState));

            Log.i(TAG, "got instance state");
        }
        else {
            highScore = prefs.getInt(HIGH_SCORE, 0);

            // build new shapes each round
            ShapeBuilder shapeBuilder = new ShapeBuilder(gameMode);
            game.set_shapes(shapeBuilder.getListofShapes());

            Log.i(TAG, "shapes set correctly in game.set_shape(List<Shape>)");
        }

        // more drawing
        TextView roundNum = findViewById(R.id.roundNum);
        Log.i(TAG, "roundNum initialized");
        roundNum.setText(Integer.toString(game.get_round()));
        Log.i(TAG, "text set");
        TextView cScore = findViewById(R.id.currentScore);
        cScore.setText("Score: " + game.get_score());

        Log.i(TAG, "text and score drawn correctly");

        next = false;

        _shape1 = (ImageView) findViewById(R.id.shape1);
        _shape2 = (ImageView) findViewById(R.id.shape2);
        _shape3 = (ImageView) findViewById(R.id.shape3);
        _mainShape = (ImageView) findViewById(R.id.mainShape);

        Log.i(TAG, "shapes drawn correctly");

        index = 0;

        //Log.i(TAG, "MAIN SHAPE: " + listOfShapes.get(0).toString());
        //Log.i(TAG, "SHAPE 1: " + listOfShapes.get(1).toString());
        //Log.i(TAG, "SHAPE 2: " + listOfShapes.get(2).toString());
        //Log.i(TAG, "SHAPE 3: " + listOfShapes.get(3).toString());

            for (Shape shape : game.get_shapes()) {
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

        Log.i(TAG, "shapes drawn correctly # 2");

        _shape1.setOnTouchListener(onTouchListener(_shape1));
        _shape2.setOnTouchListener(onTouchListener(_shape2));
        _shape3.setOnTouchListener(onTouchListener(_shape3));

        Log.i(TAG, "shapes correctly dragable");

        _mainShape.setOnDragListener(onDragListener());

        Log.i(TAG, "shapes dragable 2");
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
                    ImageView dragView = (ImageView) event.getLocalState();
                    // Compare
                    switch (game.get_gameMode()) {
                        case 1:
                            // get shape only
                            if (_mainShape.getTag().toString().equals(dragView.getTag().toString())) {
                                Log.i("MATCH", "You got a match!");
                                next = true;
                            }
                            break;
                        case 2:
                            // get color only
                            if (_mainShape.getColorFilter().equals(dragView.getColorFilter())) {
                                Log.i("MATCH", "You got a match!");
                                next = true;
                            }
                            break;
                        case 3:
                            // get shape and color
                            if (_mainShape.getTag().toString().equals(dragView.getTag().toString()) && _mainShape.getColorFilter().equals(dragView.getColorFilter())) {
                                Log.i("MATCH", "You got a match!");
                                next = true;
                            }
                    }

                    if (next && game.get_round() < 10) {
                        game.set_round(game.get_round() + 1);
                        game.set_score(game.get_score() + 10);
                        Log.i(SCORE, "SCORE BEFORE INTENT IS CREATED: " + String.valueOf(game.get_score()));

                        Log.i("ROUND:", "ROUND BEFORE INTENT IS CREATED: " + String.valueOf(game.get_round()));
                        Intent intent = getIntent();
                        //intent.putExtra(ROUND, round);
                        //intent.putExtra(SCORE, score);

                        intent.putExtra(MATCHES, (firstTry) ? ++matches : matches);

                        intent.putExtra(ROUND, game.get_round());
                        //intent.putExtra(SCORE, score);
                        intent.putExtra("name_of_extra", game);
                        finish();
                        startActivity(intent);
                    }
                    else if (next && game.get_round() >= 10) {
                        Log.i(TAG, "ROUND OVER 10");
                        //editor.putInt(ROUND, 1);
                        game.set_score(game.get_score() + 10);
                        Log.i(SCORE, String.valueOf(game.get_score()));
                        if (game.get_score() > highScore) {
                            editor.putInt(HIGH_SCORE, game.get_score());
                        }

                        if (firstTry) {
                            matches++;
                        }

                        editor.apply();
                        endingScreen(v);
                    }
                    else {
                        // We don't have a match
                        firstTry = false;
                        game.set_score(game.get_score() - 10);
                        TextView cScore = findViewById(R.id.currentScore);
                        cScore.setText("Score: " + game.get_score());
                        Log.i(SCORE, String.valueOf(game.get_score()));
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


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        game.set_gameMode(savedInstanceState.getInt(GAME_MODE, 0));
        game.set_round(savedInstanceState.getInt(ROUND, 1));
        game.set_score(savedInstanceState.getInt(SCORE, 0));
        //highScore = savedInstanceState.getInt(HIGH_SCORE, 0);

        String tempString = (String) savedInstanceState.get("jsonObj");
        Log.i("SAVED-TEMP STRING", tempString);

        try {
            JSONArray arr = new JSONArray(tempString);

            for (int i = 0; i < arr.length(); i++) {
                JSONObject s = arr.getJSONObject(i);
                Log.i("SAVED NAME", s.getString("_name"));
                Log.i("SAVED COLOR", s.getString("_color"));
            }

            game.set_shapes(ShapeBuilder.getShapesFromJsonArray(arr));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void goToMenu(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



    public void endingScreen(View view) {
        //li.setBackgroundColor();
        // simply test ending screen
        Intent intent = new Intent(this, EndingScreenActivity.class);

        intent.putExtra(SCORE, game.get_score());
        intent.putExtra(MATCHES, matches);

        startActivity(intent);
    }
    /*
    /**
     * This handles the saving of the instance state (mainly for when the screen is
     * being changing to landscape/portrait mode).
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (round < 10) {
            outState.putInt(ROUND, game.get_round());
            outState.putInt(SCORE, game.get_score());
        }
        else {
            game.set_round(1);
            game.set_score(0);
            outState.putInt(ROUND, 1);
            outState.putInt(SCORE, 0);
        }
        outState.putInt(HIGH_SCORE, highScore);
        Gson gson = new Gson();

        String shapeList = gson.toJson(game.get_shapes());
        Log.i(TAG, shapeList);

        outState.putString("jsonObj", shapeList);

        outState.putInt(GAME_MODE, game.get_gameMode());

        Log.i("SAVING-GAMEMODE", String.valueOf(game.get_gameMode()));
        Log.i("SAVING-ROUND", String.valueOf(game.get_round()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Set RGB Colors maps the Enum class (SelectedColor) with a rgb value.
     */
    private void setRgbColors() {
        colors = new HashMap<SelectedColor, Integer>();

        // primary colors
        colors.put(SelectedColor.Red, Color.RED);
        colors.put(SelectedColor.Yellow, Color.YELLOW);
        colors.put(SelectedColor.Blue, Color.BLUE);

        // secondary colors
        colors.put(SelectedColor.Green, Color.rgb(57, 255, 20));
        colors.put(SelectedColor.Orange, Color.rgb(255,159,0));
        colors.put(SelectedColor.Purple, Color.rgb(255,0,255));
    }

    /**
     * Get Game Mode gets the Integer
     */
    private void getGameMode() {
        intent = getIntent();
        gameMode = (intent.getIntExtra(MainActivity.GAME_MODE, -1));
    }

    /**
     * This function gets a list of shapes from the saved instance state.
     *
     * @param savedInstanceState is used to get the String to be serialized
     * @return list of shapes
     */
    private List<Shape> getShapes(Bundle savedInstanceState) {
        String tempString = (String) savedInstanceState.get("jsonObj");
        Log.i("SAVED-TEMP STRING", tempString);

        try {

            JSONArray arr = new JSONArray(tempString);

            for (int i = 0; i < arr.length(); i++) {
                JSONObject s = arr.getJSONObject(i);
                Log.i("SAVED NAME", s.getString("_name"));
                Log.i("SAVED COLOR", s.getString("_color"));
            }

            game.set_shapes(ShapeBuilder.getShapesFromJsonArray(arr));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return game.get_shapes();
    }
}
