package com.djablonski.jadehealth;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by Jacob on 11/4/2017.
 */

public class dataScreen extends AppCompatActivity {

    private TextView painQuestion;
    private TextView pulseRateText;
    private TextView temperatureText;
    private TextView humidityText;
    private EditText painInfo;
    private Button moreInfoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_activity);

        painQuestion = findViewById(R.id.Question1);
        pulseRateText = findViewById(R.id.pulseRate);
        temperatureText = findViewById(R.id.temperature);
        humidityText = findViewById(R.id.humidty);
        painInfo = findViewById(R.id.userPainNumber);
        moreInfoBtn = findViewById(R.id.button);

        AssetManager am = dataScreen.this.getApplicationContext().getAssets();
        Typeface typeface = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "timeburnerbold.ttf"));

        painQuestion.setTypeface(typeface);
        pulseRateText.setTypeface(typeface);
        humidityText.setTypeface(typeface);
        temperatureText.setTypeface(typeface);



    }
}