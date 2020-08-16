package com.harshit.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText ex_min,ex_max;
    Button ex_button;
    TextView answer;

    Random r;
    int min,max,output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout relativeLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


        r = new Random();

        ex_min = (EditText) findViewById(R.id.ex_min);
        ex_max = (EditText) findViewById(R.id.ex_max);
        ex_button = (Button) findViewById(R.id.ex_button);
        answer = (TextView) findViewById(R.id.answer);

        ex_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String tempMin, tempMax;
                    tempMin = ex_min.getText().toString();
                    tempMax = ex_max.getText().toString();
                    if (!tempMin.equals("") && !tempMax.equals("")) {
                        min = Integer.parseInt(tempMin);
                        max = Integer.parseInt(tempMax);

                        if (max < min) {
                            Toast.makeText(getApplicationContext(), "invalid input", Toast.LENGTH_LONG).show();

                        } else {
                            output = r.nextInt((max - min) + 1) + min;
                            answer.setText(" " + output);

                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "please enter the numbers", Toast.LENGTH_LONG).show();
                    }
                } catch(NumberFormatException e){ }
            }
        });

    }
}