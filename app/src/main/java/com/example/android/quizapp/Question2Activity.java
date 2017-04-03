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
import static com.example.android.quizapp.R.id.question;


public class Question2Activity extends AppCompatActivity {

    private int scoreSoFar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.question_radio);
        ((TextView)findViewById(question)).setText(R.string.question2);
        ((TextView)findViewById(answer1)).setText(R.string.q2_answer1);
        ((TextView)findViewById(answer2)).setText(R.string.q2_answer2);
        ((TextView)findViewById(answer3)).setText(R.string.q2_answer3);
        ((TextView)findViewById(answer4)).setText(R.string.q2_answer4);

        scoreSoFar = getIntent().getIntExtra("score", 0);
    }

    //programmatic implementation of radiogroup
    public void onRadioButtonClicked(View view) {

        ((RadioButton) view).setChecked(true);

        switch(view.getId()) {
            case answer1:
                ((RadioButton)findViewById(answer2)).setChecked(false);
                ((RadioButton)findViewById(answer3)).setChecked(false);
                ((RadioButton)findViewById(answer4)).setChecked(false);
                break;
            case answer2:
                ((RadioButton)findViewById(answer1)).setChecked(false);
                ((RadioButton)findViewById(answer3)).setChecked(false);
                ((RadioButton)findViewById(answer4)).setChecked(false);
                break;
            case answer3:
                ((RadioButton)findViewById(answer1)).setChecked(false);
                ((RadioButton)findViewById(answer2)).setChecked(false);
                ((RadioButton)findViewById(answer4)).setChecked(false);
                break;
            case answer4:
                ((RadioButton)findViewById(answer1)).setChecked(false);
                ((RadioButton)findViewById(answer2)).setChecked(false);
                ((RadioButton)findViewById(answer3)).setChecked(false);
                break;
            default:
                break;
        }
    }

    //Toasts whether answer correct or incorrect
    //Starts next activity
    public void onSubmitClicked(View view){

        Context context = getApplicationContext();

        CharSequence text;

        if(((RadioButton)findViewById(answer3)).isChecked()) {
            text = getString(R.string.correct);
            scoreSoFar++;
        }else
            text = getString(R.string.incorrect);

        Toast toast = Toast.makeText(context, text,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();

        Intent intent = new Intent(this, Question3Activity.class);
        intent.putExtra("score", (Integer) scoreSoFar);
        startActivity(intent);
    }
}
