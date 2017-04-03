package com.example.android.quizapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.score);
        ((TextView)findViewById(R.id.scoreTitle)).setText(R.string.scoreTitle);

        int finalScore = getIntent().getIntExtra("score", 0);
        ((TextView)findViewById(R.id.scoreNum)).setText((""+finalScore));

        switch(finalScore){
            case 4:
                ((TextView)findViewById(R.id.scoreComment)).setText(R.string.scorePerfect);
                break;
            case 3:
            case 2:
                ((TextView)findViewById(R.id.scoreComment)).setText(R.string.scoreGood);
                break;
            case 1:
            case 0:
                ((TextView)findViewById(R.id.scoreComment)).setText(R.string.scoreBad);
                break;
            default:
                break;
        }

        Toast.makeText(this, "Final score: " + finalScore, Toast.LENGTH_SHORT).show();
    }

    public void onTryAgainClicked(View view){
        Intent intent = new Intent(getApplicationContext(), Question1Activity.class);
        startActivity(intent);
    }
}
