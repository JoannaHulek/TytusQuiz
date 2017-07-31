package com.example.android.tytusquiz;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question1Activity extends AppCompatActivity {

    private Bundle saveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        saveData = getIntent().getExtras();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void nextQuestion(View v) {

        RadioGroup question1Answers = (RadioGroup) findViewById(R.id.question1_answers);
        RadioButton selectedAnswer = (RadioButton) findViewById(question1Answers.getCheckedRadioButtonId());

        if (selectedAnswer == null) {
            Toast.makeText(this, R.string.empty_answer123_communique, Toast.LENGTH_SHORT).show();
        } else {
            RadioButton tytusDeZooRadioButton = (RadioButton) findViewById(R.id.tytus_de_zoo_radio_button);
            boolean[] answersArray = new boolean[5];
            answersArray[0] = tytusDeZooRadioButton.isChecked();
            saveData.putBooleanArray("answers", answersArray);

            Intent i = new Intent(this, Question2Activity.class);
            i.putExtras(saveData);
            startActivity(i);
        }
    }
}
