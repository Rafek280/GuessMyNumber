package com.example.guessmynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    SeekBar seekBar2;
    EditText lowerBound;
    EditText upperBound;
    Button generate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        lowerBound = (EditText) findViewById(R.id.lowerBound);
        upperBound = (EditText) findViewById(R.id.upperBound);
        generate = (Button) findViewById(R.id.generate);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "A secret number has been generated randomly. Go, guess it!", Toast.LENGTH_LONG).show();
            }
        });

        seekbarAnimationen();
        generateRandomNumber();
        getValueEdittext(upperBound);
    }


    public void seekbarAnimationen() {

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean b) {
                   upperBound.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar2) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar2) {

            }
        });
    }

    public void generateRandomNumber(){
        int min = 0;
        int max = 1000;

        //Generate random int value from 50 to 100
        System.out.println("Random value in int from "+min+" to "+max+ ":");
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        System.out.println("HIEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEER" + random_int);
    }



    public void getValueEdittext(EditText editText){

        String value = editText.getText().toString();

        try{
            int finalValue=Integer.parseInt(value);
            System.out.println(finalValue); // output = 25
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

    }

}