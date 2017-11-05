package com.djablonski.jadehealth;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Locale;

/**
 * Created by Jacob on 11/5/2017.
 */

public class informationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_activity);

        AssetManager am = informationActivity.this.getApplicationContext().getAssets();
        Typeface typeface = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "timeburnerbold.ttf"));

        //this is a comment
    }
}
