package com.example.android.quizapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.quizapp.R.id.question;

public class Question3Activity extends AppCompatActivity {

    private int scoreSoFar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_edit);

        ((TextView)findViewById(question)).setText(R.string.question3);

        scoreSoFar = getIntent().getIntExtra("score", 0);
    }

    public void onSubmitClicked(View view){

        Context context = getApplicationContext();

        CharSequence text;

        if(((EditText)findViewById(R.id.answer)).getText().toString().trim().toLowerCase().equals("pacific")){
            text = getString(R.string.correct);
            scoreSoFar++;
        } else
            text = getString(R.string.incorrect);

        Toast toast = Toast.makeText(context, text,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();

        Intent intent = new Intent(this, Question4Activity.class);
        intent.putExtra("score", (Integer) scoreSoFar);
        startActivity(intent);
    }
}
