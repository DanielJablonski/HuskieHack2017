package com.djablonski.jadehealth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Jacob on 11/4/2017.
 */

public class QuestionnaireActivty extends AppCompatActivity {

    private TextView title;
    private TextView sex;
    private TextView age;
    private TextView height;
    private TextView weight;
    private CheckBox femaleBox;
    private CheckBox maleBox;
    private EditText ageInfo;
    private EditText heightInfo;
    private EditText weightInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionnaire_activty);

        title = findViewById(R.id.textView);
        sex = findViewById(R.id.textView1);


    }
}