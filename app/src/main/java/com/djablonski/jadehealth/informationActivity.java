package com.djablonski.jadehealth;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by Jacob on 11/5/2017.
 */

public class informationActivity extends AppCompatActivity {

    private ImageView logo;
    private TextView recommendation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_activity);

        logo = findViewById(R.id.imageView);
        recommendation = findViewById(R.id.recommendText);
        int painIndex = getIntent().getIntExtra("userPain", 0);

        AssetManager am = informationActivity.this.getApplicationContext().getAssets();
        Typeface typeface = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "timeburnerbold.ttf"));

        recommendation.setTypeface(typeface);

        if(painIndex > 10)
        {
            recommendation.setText("@string/recommendations_thermonuclearwar");
        }
        else if (painIndex >= 5 && painIndex <= 9);
        {
            recommendation.setText("@string/recommendations_overkill");
        }
        else if (painIndex >= 3 && painIndex <= 4)
        {
            recommendation.setText("@string/recommendations_severe");
        }

        else {
            recommendation.setText("@string/recommendations_mild");

        }
    }
}
