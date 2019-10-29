package com.example.wk06team;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addEvens(View v) {
        RunnableEven even = new RunnableEven(this);
        Thread t = new Thread(even);

        t.start();

    }

    public void addOdds(View v) {
        RunnableOdd odd = new RunnableOdd(this);
        Thread t = new Thread(odd);

        t.start();

    }
}
