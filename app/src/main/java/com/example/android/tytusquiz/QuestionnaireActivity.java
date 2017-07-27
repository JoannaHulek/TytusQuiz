package com.example.android.tytusquiz;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.name;

public class QuestionnaireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void startQuiz(View v){

        EditText nameField = (EditText) findViewById(R.id.name_input);

        if (nameField.getText().toString().trim().length() == 0) {
            Toast.makeText(this, R.string.empty_questionnarie_communique, Toast.LENGTH_SHORT).show();
        } else {

            String name = nameField.getText().toString();

            Intent i = new Intent(this, Question1Activity.class);
            i.putExtra("name", name);

            startActivity(i);
        }
    }
}
