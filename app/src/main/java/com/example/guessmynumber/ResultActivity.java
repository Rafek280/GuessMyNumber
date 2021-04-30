package com.example.guessmynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {

    TextView finalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        finalText = (TextView) findViewById(R.id.finalText);

      //  System.out.println(MainActivity.getInstance().getValueEdittext(MainActivity.getInstance().guessNumber));
      //  System.out.println(MainActivity.getInstance().currentrandomnumber);

     /*   if(MainActivity.getInstance().getValueEdittext(MainActivity.getInstance().guessNumber)>MainActivity.getInstance().currentrandomnumber){
            finalText.setText("Your guess of " + MainActivity.getInstance().getValueEdittext(MainActivity.getInstance().guessNumber) + " is TOO HIGH!");
        }
        if(MainActivity.getInstance().getValueEdittext(MainActivity.getInstance().guessNumber)<MainActivity.getInstance().currentrandomnumber){
            finalText.setText("Your guess of " + MainActivity.getInstance().getValueEdittext(MainActivity.getInstance().guessNumber) + " is TOO LOW!");
        }
        if(MainActivity.getInstance().getValueEdittext(MainActivity.getInstance().guessNumber)==MainActivity.getInstance().currentrandomnumber){
            finalText.setText("Your guess of " + MainActivity.getInstance().getValueEdittext(MainActivity.getInstance().guessNumber) + " is correct!");
        }/*

       /* (MainActivity)getActiv

        if(MainActivity.getValueEdittext(MainActivity.guessNumber)>MainActivity.currentrandomnumber){
            System.out.println("Your guess of " + getValueEdittext(guessNumber) + " is TOO HIGH!");
        }
        if(getValueEdittext(guessNumber)<currentrandomnumber){
            System.out.println("Your guess of " + getValueEdittext(guessNumber) + " is TOO LOW!");
        }
        if(getValueEdittext(guessNumber)==currentrandomnumber){
            System.out.println("Excellent! " + getValueEdittext(guessNumber) + " is correct!");
        }*/
    }
}