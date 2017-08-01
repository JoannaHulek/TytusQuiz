package com.example.android.tytusquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class QuizReviewActivity extends AppCompatActivity {

    private Bundle saveData;
    private int score;
    private String name;
    private String scoreMessage;
    private String reviewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_review);
        saveData = getIntent().getExtras();
        score = saveData.getInt("score");
        name = saveData.getString("name");

        prepareReviewMessage();
    }

    private void prepareReviewMessage() {
        scoreMessage = getString(R.string.your_score) + score;

        TextView scoreField = (TextView) findViewById(R.id.score_text_view);
        scoreField.setText(scoreMessage);

        List<Integer> review_parts_1 = Arrays.asList(R.string.review_0_part1, R.string.review_1_part1, R.string.review_2_part1, R.string.review_3_part1, R.string.review_4_part1, R.string.review_5_part1);
        List<Integer> review_parts_2 = Arrays.asList(R.string.review_0_part2, R.string.review_1_part2, R.string.review_2_part2, R.string.review_3_part2, R.string.review_4_part2, R.string.review_5_part2);

        reviewMessage = getString(review_parts_1.get(score)) + name + getString(review_parts_2.get(score));

        TextView reviewField = (TextView) findViewById(R.id.review_text_view);
        reviewField.setText(reviewMessage);
    }

    public void again(View v) {
        Intent i = new Intent(this, QuestionnaireActivity.class);
        startActivity(i);
    }

    public void sendMail(View v) {

        Intent send = new Intent(Intent.ACTION_SEND);
        send.setType("*/*");
        send.putExtra(Intent.EXTRA_EMAIL, "");
        send.putExtra(Intent.EXTRA_SUBJECT, "Tytus Quiz review");
        send.putExtra(Intent.EXTRA_TEXT, scoreMessage + reviewMessage);
        if (send.resolveActivity(getPackageManager()) != null) {
            startActivity(send);
        }
    }
}
