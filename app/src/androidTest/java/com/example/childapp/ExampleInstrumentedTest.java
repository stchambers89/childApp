package com.example.childapp;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.childapp", appContext.getPackageName());
    }

    @Test
    public void addition() {
       // assertEquals(4, 2 + 3);
       //// Log i()

    }

    @Test
    public void matchCorrect() {
        //assertEquals("It's a match", 1, matchShape.getMatch);
    }

    @Test
    public void buttonOne_initiates_game_matching_shapes() {

        //Game g = new Game(1);
        //assertEquals(1, g.getGameMode());

    }

    @Test
    public void shape_added_to_list(){

    }



}
