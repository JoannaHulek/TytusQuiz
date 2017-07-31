package com.example.android.tytusquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Question4Activity extends AppCompatActivity {

    private Bundle saveData;
    boolean[] answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        saveData = getIntent().getExtras();
        answers = saveData.getBooleanArray("answers");

        addItemsOnYearSpinner();
    }

    private Spinner yearSpinner;

    private void addItemsOnYearSpinner() {
        yearSpinner = (Spinner) findViewById(R.id.year_spinner);
        List<String> list = new ArrayList<>();
        list.add(getResources().getString(R.string.select_from_list));

        for (Integer i = 1945; i <= 2015; i++) {
            list.add(i.toString());
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(dataAdapter);
    }

    public void nextQuestion(View v) {

        String year = (String) yearSpinner.getSelectedItem();

        if (year.equals(getResources().getString(R.string.select_from_list))) {
            Toast.makeText(this, R.string.select_answer_from_list, Toast.LENGTH_SHORT).show();
        } else {
            answers[3] = (year.equals("1966"));

            saveData.putBooleanArray("answers", answers);

            Intent i = new Intent(this, Question5Activity.class);
            i.putExtras(saveData);
            startActivity(i);
        }
    }

    public void previousQuestion(View v) {

        Intent i = new Intent(this, Question3Activity.class);
        i.putExtras(saveData);
        startActivity(i);
    }
}
