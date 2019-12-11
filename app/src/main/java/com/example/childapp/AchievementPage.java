package com.example.childapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Achievement page class views a pop up that displays the achievements
 *
 */
public class AchievementPage extends AppCompatActivity {

    private int goldTrophies;
    private int silverTrophies;
    private int bronzeTrophies;
    static int level;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    private TextView bronzeNum;
    private TextView silverNum;
    private TextView goldNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_achievement_page);

        // build a pop up by simply altering the window dimensions
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        Intent intent = getIntent();


        sharedPref = getSharedPreferences("achievement_file", MODE_PRIVATE);

        bronzeTrophies = sharedPref.getInt("bronzeCount",0);
        silverTrophies = sharedPref.getInt("silverCount",0);
        goldTrophies = sharedPref.getInt("goldCount",0);

        Log.i("Gold Trophies",String.valueOf(goldTrophies));
        Log.i("Silver Trophies",String.valueOf(silverTrophies));
        Log.i("Bronze Trophies",String.valueOf(bronzeTrophies));

        ImageView bronze = (ImageView) findViewById(R.id.bronze);
        ImageView silver = (ImageView) findViewById(R.id.silver);
        ImageView gold = (ImageView) findViewById(R.id.gold);
        ImageView current = (ImageView) findViewById(R.id.winning);
        bronzeNum = findViewById(R.id.bronzeNumber);
        silverNum = findViewById(R.id.silverNumber);
        goldNum = findViewById(R.id.goldNumber);



        bronze.setImageDrawable(getResources().getDrawable(R.drawable.star));
        silver.setImageDrawable(getResources().getDrawable(R.drawable.star));
        gold.setImageDrawable(getResources().getDrawable(R.drawable.star));
        current.setImageDrawable(getResources().getDrawable(R.drawable.trophy));

        bronze.setColorFilter(Color.rgb(205,127,50));
        silver.setColorFilter(Color.rgb(170,169,173));
        gold.setColorFilter(Color.rgb(255,215,0));


        bronzeNum.setText(String.valueOf(bronzeTrophies));
        silverNum.setText(String.valueOf(silverTrophies));
        goldNum.setText(String.valueOf(goldTrophies));

        editor = sharedPref.edit();

        switch (level) {
            case 3:
                editor.putInt("bronzeCount", bronzeTrophies);
                break;
            case 2:
                editor.putInt("silverCount", silverTrophies);
                break;
            case 1:
                editor.putInt("goldCount", goldTrophies);
                break;
        }
        editor.apply();


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

    @Override
    public void onBackPressed() {

    }

}
