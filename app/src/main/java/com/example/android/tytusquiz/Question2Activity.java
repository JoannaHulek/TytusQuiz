package com.example.android.tytusquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Question2Activity extends AppCompatActivity {

    private Bundle saveData;
    boolean[] answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        saveData = getIntent().getExtras();
        answers = saveData.getBooleanArray("answers");
    }

    public void nextQuestion(View v) {
        CheckBox romekCheckBox = (CheckBox) findViewById(R.id.romek_check_box);
        boolean romekIsChecked = romekCheckBox.isChecked();

        CheckBox atomekCheckBox = (CheckBox) findViewById(R.id.atomek_check_box);
        boolean atomekIsChecked = atomekCheckBox.isChecked();

        CheckBox flipNFlapCheckBox = (CheckBox) findViewById(R.id.flip_n_flap_check_box);
        boolean flipNFlapIsChecked = flipNFlapCheckBox.isChecked();

        CheckBox captainAmericaCheckBox = (CheckBox) findViewById(R.id.captain_america_check_box);
        boolean captainAmericaIsChecked = captainAmericaCheckBox.isChecked();

        if (!romekIsChecked && !atomekIsChecked && !flipNFlapIsChecked && !captainAmericaIsChecked) {
            Toast.makeText(this, R.string.empty_answer123_communique, Toast.LENGTH_SHORT).show();
        } else {
            answers[1] = (romekIsChecked && atomekIsChecked && !flipNFlapIsChecked && !captainAmericaIsChecked);

            saveData.putBooleanArray("answers", answers);

            Intent i = new Intent(this, Question3Activity.class);
            i.putExtras(saveData);
            startActivity(i);
        }
    }

    public void previousQuestion(View v) {
        Intent i = new Intent(this, Question1Activity.class);
        i.putExtras(saveData);
        startActivity(i);
    }
}
