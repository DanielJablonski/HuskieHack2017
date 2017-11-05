package com.djablonski.jadehealth;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Jacob on 11/4/2017.
 */

public class QuestionnaireActivty extends AppCompatActivity {

    private TextView title,weight,sex,age,height;
    private Button submit;
    private RadioButton femaleBox,maleBox;
    private EditText ageInfo,heightInfo,weightInfo;
    private DatabaseReference ref;
    private String sexString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionnaire_activty);

        title = findViewById(R.id.textView);
        sex = findViewById(R.id.textView1);
        age = findViewById(R.id.textView2);
        height = findViewById(R.id.textView3);
        weight = findViewById(R.id.textView4);
        submit = findViewById(R.id.submitBtn);
        maleBox = findViewById(R.id.maleCheckBox);
        femaleBox = findViewById(R.id.femaleCheckBox);
        ageInfo = findViewById(R.id.ageEdit);
        heightInfo = findViewById(R.id.heightEdit);
        weightInfo = findViewById(R.id.weightEdit);
        ref = FirebaseDatabase.getInstance().getReference().child("users");


        AssetManager am = QuestionnaireActivty.this.getApplicationContext().getAssets();
        Typeface typeface = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "timeburnerbold.ttf"));

        title.setTypeface(typeface);
        sex.setTypeface(typeface);
        age.setTypeface(typeface);
        height.setTypeface(typeface);
        weight.setTypeface(typeface);
        submit.setTypeface(typeface);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(maleBox.isChecked())
                    sexString = "Male";
                else
                    sexString = "Female";
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("/" + FirebaseAuth.getInstance().getUid() + "/", toMap());
                ref.updateChildren(map, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                    }
                });
            }
        });


    }
    public Map<String, Object> toMap()
    {
        HashMap<String, Object> result = new HashMap<>();
        result.put("sex", sexString);
        result.put("age", ageInfo.getText().toString());
        result.put("height", heightInfo.getText().toString());
        result.put("weight", weightInfo.getText().toString());
        result.put("email", FirebaseAuth.getInstance().getCurrentUser().getEmail());
        result.put("name", FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
        return result;
    }
}