package com.example.android.tytusquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Question3Activity extends AppCompatActivity {

    private Bundle saveData;
    boolean[] answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        saveData = getIntent().getExtras();
        answers = saveData.getBooleanArray("answers");
    }


    public void nextQuestion (View v){
        CheckBox henrykJerzyChmielewskiCheckBox = (CheckBox) findViewById(R.id.henryk_jerzy_chmielewski_check_box);
        boolean henrykJerzyChmielewskiIsChecked = henrykJerzyChmielewskiCheckBox.isChecked();

        CheckBox papcioChmielCheckBox = (CheckBox) findViewById(R.id.papcio_chmiel_check_box);
        boolean papcioChmielIsChecked = papcioChmielCheckBox.isChecked();

        CheckBox agataNowickaCheckBox = (CheckBox) findViewById(R.id.agata_nowicka_check_box);
        boolean agataNowickaIsChecked = agataNowickaCheckBox.isChecked();

        CheckBox haGaCheckBox = (CheckBox) findViewById(R.id.ha_ga_check_box);
        boolean haGaIsChecked = haGaCheckBox.isChecked();

        CheckBox januszChristaCheckBox = (CheckBox) findViewById(R.id.janusz_christa_check_box);
        boolean januszChristaIsChecked = januszChristaCheckBox.isChecked();

        CheckBox jeanJacquesSempeCheckBox = (CheckBox) findViewById(R.id.jean_jacques_sempe_check_box);
        boolean jeanJacquesSempeIsChecked = jeanJacquesSempeCheckBox.isChecked();

        CheckBox rafalSkarzyckiCheckBox = (CheckBox) findViewById(R.id.rafal_skarzycki_check_box);
        boolean rafalSkarzyckiIsChecked = rafalSkarzyckiCheckBox.isChecked();

        CheckBox reneGoscinnyCheckBox = (CheckBox) findViewById(R.id.rene_goscinny_check_Box);
        boolean reneGoscinnyIsChecked = reneGoscinnyCheckBox.isChecked();

        CheckBox scottAdamsCheckBox = (CheckBox) findViewById(R.id.scott_adams_check_box);
        boolean scottAdamsIsChecked = scottAdamsCheckBox.isChecked();

        CheckBox tomaszLewLesniakCheckBox = (CheckBox) findViewById(R.id.tomasz_lew_lesniak_check_box);
        boolean tomaszLewLesniakIsChecked = tomaszLewLesniakCheckBox.isChecked();

        if (!henrykJerzyChmielewskiIsChecked && !papcioChmielIsChecked
                && !agataNowickaIsChecked && !haGaIsChecked
                && !januszChristaIsChecked && !jeanJacquesSempeIsChecked
                && !rafalSkarzyckiIsChecked && !reneGoscinnyIsChecked
                && !scottAdamsIsChecked && !tomaszLewLesniakIsChecked){
            Toast.makeText(this, R.string.empty_answer123_communique, Toast.LENGTH_SHORT).show();
        }else {
            answers[2] = (henrykJerzyChmielewskiIsChecked && papcioChmielIsChecked
                    && !agataNowickaIsChecked && !haGaIsChecked && !januszChristaIsChecked && !jeanJacquesSempeIsChecked
                    && !rafalSkarzyckiIsChecked && !reneGoscinnyIsChecked && !scottAdamsIsChecked && !tomaszLewLesniakIsChecked);


            saveData.putBooleanArray("answers", answers);

            Intent i = new Intent(this, Question4Activity.class);
            i.putExtras(saveData);
            startActivity(i);
        }
    }

    public void previousQuestion (View v){

        Intent i = new Intent(this, Question2Activity.class);
        i.putExtras(saveData);
        startActivity(i);
    }
}
