package com.example.gamecrush;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NumberGuess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumberGuessData.initGame();
        updateDisplay(R.id.Range, NumberGuessData.lBound, NumberGuessData.uBound);

    }

    public void makeGuess(View v){
        TextView t = findViewById(R.id.source);
        String input = t.getText().toString();
        TextView range = findViewById(R.id.Range);
        int response = Integer.parseInt(input);

        int res = NumberGuessData.wasGuessCorrect(response);
        if (res == 0){
            range.setText("Success");
        }else if(res > 0){
            NumberGuessData.uBound = response;
            updateDisplay(R.id.Range, NumberGuessData.lBound, response);
        }else{
            NumberGuessData.lBound = response;
            updateDisplay(R.id.Range, response, NumberGuessData.uBound);
        }
    }

    public void updateDisplay(int resource,int lBound, int uBound){
        TextView t = findViewById(resource);
        t.setText("Range is Between" + " " + lBound + " - " + uBound);
    }
}