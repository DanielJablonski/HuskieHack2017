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
        setContentView(R.layout.information_activity);

        logo = findViewById(R.id.imageView);
        recommendation = findViewById(R.id.recommendText);
        String painIndex = getIntent().getStringExtra("painIndex");
        int userPain = Integer.parseInt(painIndex);

        AssetManager am = informationActivity.this.getApplicationContext().getAssets();
        Typeface typeface = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "timeburnerbold.ttf"));

        recommendation.setTypeface(typeface);

        String hum = getIntent().getStringExtra("humidity");
        float humidity = Float.parseFloat(hum);
        float dangerScore = (userPain *  humidity)*10;

        if(dangerScore >= 100)
        {
            recommendation.setText("Due to the extreme pain you seem to be experiencing we recommend immediate surgery.");
        }
        else if (dangerScore >= 50 && dangerScore <= 99)
        {
            recommendation.setText("Due to the high humidity in the air and the pain you seem to be experiencing we recommend that you take anti-inflammatory pills before going outdoors.");
        }
        else if (dangerScore >= 15 && dangerScore < 50)
        {
            recommendation.setText("Due to the relatively high humidity levels we recommend that you we recommend that you apply an ice pack to the painful areas.");
        }

        else {
            recommendation.setText("Due to the low humidity and temperature recorded by the device we recommend that you simply massage and stretch the affected area.");

        }
    }
}
