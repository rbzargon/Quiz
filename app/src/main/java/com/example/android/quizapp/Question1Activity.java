package com.example.android.quizapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.quizapp.R.id.answer1;
import static com.example.android.quizapp.R.id.answer2;
import static com.example.android.quizapp.R.id.answer3;
import static com.example.android.quizapp.R.id.answer4;


public class Question1Activity extends AppCompatActivity {

    private int scoreSoFar = 0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.question_radio);
        ((TextView) findViewById(R.id.question)).setText(R.string.question1);
        ((TextView) findViewById(R.id.answer1)).setText(R.string.q1_answer1);
        ((TextView) findViewById(R.id.answer2)).setText(R.string.q1_answer2);
        ((TextView) findViewById(R.id.answer3)).setText(R.string.q1_answer3);
        ((TextView) findViewById(R.id.answer4)).setText(R.string.q1_answer4);

    }

    //Programmatic control of RadioButtons
    //Unfortunately RadioGroup doesn't control them when there are views in between
    public void onRadioButtonClicked(View view) {

        ((RadioButton) view).setChecked(true);

        switch (view.getId()) {
            case answer1:
                ((RadioButton) findViewById(answer2)).setChecked(false);
                ((RadioButton) findViewById(answer3)).setChecked(false);
                ((RadioButton) findViewById(answer4)).setChecked(false);
                break;
            case answer2:
                ((RadioButton) findViewById(answer1)).setChecked(false);
                ((RadioButton) findViewById(answer3)).setChecked(false);
                ((RadioButton) findViewById(answer4)).setChecked(false);
                break;
            case answer3:
                ((RadioButton) findViewById(answer1)).setChecked(false);
                ((RadioButton) findViewById(answer2)).setChecked(false);
                ((RadioButton) findViewById(answer4)).setChecked(false);
                break;
            case answer4:
                ((RadioButton) findViewById(answer1)).setChecked(false);
                ((RadioButton) findViewById(answer2)).setChecked(false);
                ((RadioButton) findViewById(answer3)).setChecked(false);
                break;
            default:
                break;
        }

    }

    //Toasts whether answer correct or incorrect
    //Starts next question activity, passing the score
    public void onSubmitClicked(View view) {

        Context context = getApplicationContext();
        CharSequence text;

        if (((RadioButton) findViewById(answer1)).isChecked()) {
            text = getString(R.string.correct);
            scoreSoFar++;
        } else {
            text = getString(R.string.incorrect);
        }

        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();


        Intent intent = new Intent(this, Question2Activity.class);
        intent.putExtra("score", (Integer) scoreSoFar);
        startActivity(intent);
    }
}



