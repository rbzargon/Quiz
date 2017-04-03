package com.example.android.quizapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.quizapp.R.id.answer1;
import static com.example.android.quizapp.R.id.answer2;
import static com.example.android.quizapp.R.id.answer3;
import static com.example.android.quizapp.R.id.answer4;
import static com.example.android.quizapp.R.id.question;



public class Question4Activity extends AppCompatActivity {

    private int scoreSoFar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.question_checkbox);
        ((TextView) findViewById(question)).setText(R.string.question4);
        ((TextView) findViewById(answer1)).setText(R.string.q4_answer1);
        ((TextView) findViewById(answer2)).setText(R.string.q4_answer2);
        ((TextView) findViewById(answer3)).setText(R.string.q4_answer3);
        ((TextView) findViewById(answer4)).setText(R.string.q4_answer4);

        scoreSoFar = getIntent().getIntExtra("score", 0);
    }

    public void onSubmitClicked(View view){

        Context context = getApplicationContext();

        CharSequence text;

        if(   !((CheckBox)findViewById(answer1)).isChecked()
            && ((CheckBox)findViewById(answer2)).isChecked()
            && ((CheckBox)findViewById(answer3)).isChecked()
            && ((CheckBox)findViewById(answer4)).isChecked()) {
            text = getString(R.string.correct);
            scoreSoFar++;
        }else
            text = getString(R.string.incorrect);

        Toast toast = Toast.makeText(context, text,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();

        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra("score", (Integer) scoreSoFar);
        startActivity(intent);
    }
}