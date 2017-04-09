package com.example.android.tytusquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Arrays;
import java.util.List;

public class QuizReviewActivity extends AppCompatActivity {

    private Bundle saveData;
    boolean[] answers;
    private int score;
    private String name;
    private String scoreMessage;
    private String reviewMessage;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_review);
        saveData = getIntent().getExtras();
        answers = saveData.getBooleanArray("answers");
        name = saveData.getString("name");

        calculateScore();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void calculateScore() {
        for (int i = 0; i < 5; i++) {
            if (answers[i]) score++;
        }

        scoreMessage = "Twój wynik to: " + score;

        TextView scoreField = (TextView) findViewById(R.id.score_text_view);
        scoreField.setText(scoreMessage);

        prepareReviewMessage();
    }

    private void prepareReviewMessage() {
        List<Integer> review_parts_1 = Arrays.asList(R.string.review_0_part1, R.string.review_1_part1, R.string.review_2_part1, R.string.review_3_part1, R.string.review_4_part1, R.string.review_5_part1);
        List<Integer> review_parts_2 = Arrays.asList(R.string.review_0_part2, R.string.review_1_part2, R.string.review_2_part2, R.string.review_3_part2, R.string.review_4_part2, R.string.review_5_part2);

        reviewMessage = getString(review_parts_1.get(score)) + name + getString(review_parts_2.get(score));

        TextView riviewField = (TextView) findViewById(R.id.review_text_view);
        riviewField.setText(reviewMessage);
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
        send.putExtra(Intent.EXTRA_STREAM, scoreMessage + "/n/n" + reviewMessage);
        if (send.resolveActivity(getPackageManager()) != null) {
            startActivity(send);
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("QuizReview Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}