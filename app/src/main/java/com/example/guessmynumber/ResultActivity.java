package com.example.guessmynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {

    TextView finalText;
    Button dismiss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        finalText = (TextView) findViewById(R.id.finalText);
        dismiss = (Button) findViewById(R.id.dismiss);

        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backMainActivity();
            }
        });

        finalText.setText(String.valueOf(MainActivity.currentrandomnumber));//Here will be check the current random number and the given number from User

        System.out.println("HIER IST DIE RANDOM NUMBER" + MainActivity.currentrandomnumber);

        if(MainActivity.currentscore<=0){
            finalText.setText("Your Score is 0!\n You Lost!");
        }
        else if(MainActivity.guessNumberInt>MainActivity.currentrandomnumber){//Bigger than
            finalText.setText("Your guess of " + MainActivity.guessNumberInt  + " is TOO HIGH!");
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFB2A5"));
        }
        else if(MainActivity.guessNumberInt<MainActivity.currentrandomnumber){//Lower than
            finalText.setText("Your guess of " + MainActivity.guessNumberInt  + " is TOO LOW!");
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#C6DAF8"));
        }
        else if(MainActivity.guessNumberInt==MainActivity.currentrandomnumber){// same as
            finalText.setText("Excellent!\n " + MainActivity.guessNumberInt + " is correct!");
        }


    }
    void backMainActivity(){
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(intent);
    }

}