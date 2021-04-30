package com.example.guessmynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int currentrandomnumber=0;
    SeekBar seekBar;
    SeekBar seekBar2;
    EditText lowerBound;
    EditText upperBound;
    Button generate;
    EditText guessNumber;
    Button evaluate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        lowerBound = (EditText) findViewById(R.id.lowerBound);
        upperBound = (EditText) findViewById(R.id.upperBound);
        guessNumber = (EditText) findViewById(R.id.guessNumber);
        generate = (Button) findViewById(R.id.generate);
        evaluate = (Button) findViewById(R.id.evaluate);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "A secret number has been generated randomly. Go, guess it!", Toast.LENGTH_LONG).show();
                currentrandomnumber=generateRandomNumber();
            }
        });

        evaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(getValueEdittext(guessNumber)>currentrandomnumber){
                    System.out.println("Your guess of " + getValueEdittext(guessNumber) + " is TOO HIGH!");
                }
                if(getValueEdittext(guessNumber)<currentrandomnumber){
                    System.out.println("Your guess of " + getValueEdittext(guessNumber) + " is TOO LOW!");
                }
                if(getValueEdittext(guessNumber)==currentrandomnumber){
                    System.out.println("Excellent! " + getValueEdittext(guessNumber) + " is correct!");
                }

            }
        });

        seekbarUpperBound();
        seekbarLowerBound();
        generateRandomNumber();

        getValueEdittext(upperBound);
        getValueEdittext(lowerBound);



        new Thread(new Runnable() {
            @Override
            public void run() {
                //your 1st command
                while (true) {
                    edittexttoseekbar();
                    //you can use a for here and check if the command was executed or just wait and execute the 2nd command
                    try {

                        Thread.sleep(500); //wait 2 seconds
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

    }

    public void seekbarLowerBound() {

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                lowerBound.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            seekBar.setMax(getValueEdittext(upperBound));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void seekbarUpperBound() {

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean b) {
                upperBound.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar2) {
                seekBar2.setMin(getValueEdittext(lowerBound));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar2) {

            }
        });
    }

    public void edittexttoseekbar(){



            try {
                if(getValueEdittext(upperBound)>0 && getValueEdittext(upperBound)<=1000 ){
                seekBar2.setProgress(getValueEdittext(upperBound));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            try {
        if(getValueEdittext(lowerBound)>0 && getValueEdittext(lowerBound)<=1000 ) {
            seekBar.setProgress(getValueEdittext(lowerBound));
        }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    public int generateRandomNumber() {
        int min = getValueEdittext(lowerBound);
        int max = getValueEdittext(upperBound);;

        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        System.out.println("HEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE" + random_int);
        return random_int;
    }


    public int getValueEdittext(EditText editText) {

        String value = editText.getText().toString();

        //try {
            int finalValue = Integer.parseInt(value);
            System.out.println(finalValue); // output = 25
      //  } catch (NumberFormatException ex) {
        //    ex.printStackTrace();
        //}

        return finalValue;
}
}