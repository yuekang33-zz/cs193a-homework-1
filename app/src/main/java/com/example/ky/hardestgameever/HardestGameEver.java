package com.example.ky.hardestgameever;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.os.SystemClock;
import android.widget.Toast;

import android.widget.TextView;


import java.util.Random;
public class HardestGameEver extends AppCompatActivity {
    private int num;
    private int points;
    private long startTime;
    private long endTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardest_game_ever);

    }

    public void pickNumbers(View view) {
        //Button blue = (Button) findViewById(R.id.leftButton);
        //Button right = (Button) findViewById(R.id.rightButton);
        int id = view.getId();
        if(id == R.id.play){
            startTime = SystemClock.elapsedRealtime();
        }
        Random color = new Random();
        num = color.nextInt(3);
        //num1 = 0;
        //num2 = 0;
        ImageButton redImage = (ImageButton) findViewById(R.id.red);
        ImageButton blueImage = (ImageButton) findViewById(R.id.blue);
        ImageButton yellowImage = (ImageButton) findViewById(R.id.yellow);
        if (num == 0) {

            redImage.setImageResource(R.drawable.foot);
        } else if (num == 1) {
            blueImage.setImageResource(R.drawable.foot);
        } else {
            yellowImage.setImageResource(R.drawable.foot);
        }
    }

        public void getButton(View view){
            int id = view.getId();
            TextView score = (TextView) findViewById(R.id.score);
            Button play = (Button) findViewById(R.id.play);
            //ImageButton img = (ImageButton) findViewById(R.id.tmntbutton);

            if (id == R.id.red && num == 0) {
                points = points + 10;
                score.setText("Score: "+ points);
            } else if (id == R.id.blue && num == 1) {
                points = points + 10;
                score.setText("Score: " + points);
            } else if (id == R.id.yellow && num == 2) {
                points = points + 10;
                score.setText("Score: " + points);
            }
            if(points == 100){
                endTime = SystemClock.elapsedRealtime();
                long elapsedMilliSeconds = endTime - startTime;
                double elapsedSeconds = elapsedMilliSeconds / 1000.0;
                if(elapsedSeconds<=5){
                    Toast.makeText(this, "You win!", Toast.LENGTH_SHORT).show();
                    play.setText("^_^");
                }else{
                    Toast.makeText(this, "You fail!", Toast.LENGTH_SHORT).show();
                    play.setText(":-(");
                }
                return;

            }
            if(num == 0){
                ImageButton redImage = (ImageButton) findViewById(R.id.red);
                redImage.setImageResource(android.R.color.transparent);
            }else if(num ==1){
                ImageButton blueImage = (ImageButton) findViewById(R.id.blue);
                blueImage.setImageResource(android.R.color.transparent);
            }else{
                ImageButton yellowImage = (ImageButton) findViewById(R.id.yellow);
                yellowImage.setImageResource(android.R.color.transparent);
            }
            pickNumbers(view);
        }
    }


