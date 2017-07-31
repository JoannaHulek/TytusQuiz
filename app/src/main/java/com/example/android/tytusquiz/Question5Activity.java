package com.example.android.tytusquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Question5Activity extends AppCompatActivity {

    private Bundle saveData;
    boolean[] answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        saveData = getIntent().getExtras();
        answers = saveData.getBooleanArray("answers");
    }

    public void nextQuestion(View v) {

        EditText answer5Field = (EditText) findViewById(R.id.answer_5_input);
        if (answer5Field.getText().toString().isEmpty()) {
            Toast.makeText(this, R.string.empty_answer5_communique, Toast.LENGTH_SHORT).show();
        } else {
            String answer5 = answer5Field.getText().toString();
            answers[4] = (answer5.equalsIgnoreCase("Prasolot"));

            saveData.putBooleanArray("answers", answers);

            Intent i = new Intent(this, QuizReviewActivity.class);
            i.putExtras(saveData);
            startActivity(i);
        }
    }

    public void previousQuestion(View v) {

        Intent i = new Intent(this, Question4Activity.class);
        i.putExtras(saveData);
        startActivity(i);
    }
}
