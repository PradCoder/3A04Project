package com.example.tenmathquestions;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] operations = {"+", "-", "*", "/"};
    private int score = 0;
    private int add;
    private int subtract;
    private int multiply;
    private int divide;
    private int rand1;
    private int rand2;
    private int randOp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mathQuestionGenerator();
    }

    public void obSubmitClick(View view) {
        TextView answer = findViewById(R.id.answer);
        EditText userGuess = findViewById(R.id.userGuess);
        int userAnswer = Integer.parseInt(userGuess.getText().toString());
        if (this.randOp == 0) {
            if (userAnswer == this.add) {
                answer.setText("Correct!");
                score++;
            }
            else {
                answer.setText("Incorrect; the answer was: " + this.add);
            }
        }
        else if (this.randOp == 1) {
            if (userAnswer == this.subtract) {
                answer.setText("Correct!");
                score++;
            }
            else {
                answer.setText("Incorrect; the answer was: " + this.subtract);
            }
        }
        else if (this.randOp == 2) {
            if (userAnswer == this.multiply) {
                answer.setText("Correct!");
                score++;
            }
            else {
                answer.setText("Incorrect; the answer was: " + this.multiply);
            }
        }
        else {
            if (userAnswer == this.divide) {
                answer.setText("Correct!");
                score++;
            }
            else {
                answer.setText("Incorrect; the answer was: " + this.divide);
            }
        }
        if (score < 10) {
            mathQuestionGenerator();
        }
        userGuess.getText().clear();
    }

    private void mathQuestionGenerator() {
        this.rand1 = (int)(10 * Math.random()) + 1;
        this.rand2 = (int)(10 * Math.random()) + 1;
        this.randOp = (int)(4 * Math.random());

        this.add = rand1 + rand2;
        this.subtract = rand1 - rand2;
        this.multiply = rand1 * rand2;
        this.divide = rand1 / rand2;
        if (this.randOp == 3) {
            while (this.rand1 % this.rand2 != 0) {
                this.rand2 = (int)(10 * Math.random() + 1);
                this.divide = this.rand1 / this.rand2;
            }
        }

        TextView score = findViewById(R.id.score);
        score.setText("Score: " + this.score);

        TextView value1 = findViewById(R.id.value1);
        value1.setText("" + this.rand1);

        TextView operator = findViewById(R.id.operator);
        operator.setText("" + this.operations[this.randOp]);

        TextView value2 = findViewById(R.id.value2);
        value2.setText("" + this.rand2);


    }
}