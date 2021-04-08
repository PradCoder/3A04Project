package com.example.mathselect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MathSelect extends AppCompatActivity {
    int score;
    int correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathselect);
        score = 0;
        TextView Score = findViewById(R.id.Score);
        Score.setText("Score: " + score);
        generate();
    }

//    private void run(){
//
//        generate();
//        while(score<5){
//            generate();
//        }
//        if(score == 5){
//            TextView FinalDecision = findViewById(R.id.FinalDecision);
//            FinalDecision.setText("You Win!");
//        }
//    }

    private void generate(){
        TextView Answer = findViewById(R.id.Answer);
        EditText Attempt = findViewById(R.id.Attempt);
        Attempt.setText("");
        Answer.setText("");
        correct = (int)(5*Math.random() + 1);
        for(int i = 1; i < 6; i++){
            DisplayQuestion(i, i == correct);
        }
    }

    public void onSubmitClick(View view){
        TextView Answer = findViewById(R.id.Answer);
        EditText Attempt = findViewById(R.id.Attempt);
        TextView Score = findViewById(R.id.Score);
        int userAnswer = Integer.parseInt(Attempt.getText().toString());
        if(userAnswer == correct){
            Answer.setText("Correct Answer!");
            score++;
            Score.setText("Score: " + score);
        }else{
            Answer.setText("Incorrect Answer");
            score = 0;
            Score.setText("Score: "+score);
        }
        if(score<5){
            generate();
        }else{
            Attempt.setText("");
            Answer.setText("");
            TextView FinalDecision = findViewById(R.id.FinalDecision);
            FinalDecision.setText("You Win!");
        }

    }

    private void DisplayQuestion(int current, boolean valid) {
        int operation = (int)(3 * Math.random());
        int num1, num2, answer;
        answer = 0;
        num1 = (int) (10 * Math.random() + 1);
        num2 = (int) (10 * Math.random() + 1);
        if (valid) {
            if (operation == 0) {
                answer = num1 + num2;
            } else if (operation == 1) {
                answer = num1 * num2;
            } else if (operation == 2) {
                answer = num1 - num2;
            }
        } else {
            if (operation == 0) {
                answer = num1 + num2 + 1;
            } else if (operation == 1) {
                answer = num1 * num2 + 1;
            } else if (operation == 2) {
                answer = num1 - num2 + 1;
            }
        }
        SetQuestionText(current, num1, num2, answer, operation);
    }

    private void SetQuestionText(int current, int num1, int num2, int answer, int operation){
        TextView Option1 = findViewById(R.id.Option1);
        TextView Option2 = findViewById(R.id.Option2);
        TextView Option3 = findViewById(R.id.Option3);
        TextView Option4 = findViewById(R.id.Option4);
        TextView Option5 = findViewById(R.id.Option5);
        if(operation == 0){
            if(current == 1){
                Option1.setText(num1 + "+" + num2 + " = "+ answer);
            }
            else if(current == 2){
                Option2.setText(num1 + "+" + num2 + " = "+ answer);
            }
            else if(current == 3){
                Option3.setText(num1 + "+" + num2 + " = "+ answer);
            }
            else if(current == 4){
                Option4.setText(num1 + "+" + num2 + " = "+ answer);
            }
            else if(current == 5){
                Option5.setText(num1 + "+" + num2 + " = "+ answer);
            }
        }else if(operation == 1){
            if(current == 1){
                Option1.setText(num1 + "*" + num2 + " = "+ answer);
            }
            else if(current == 2){
                Option2.setText(num1 + "*" + num2 + " = "+ answer);
            }
            else if(current == 3){
                Option3.setText(num1 + "*" + num2 + " = "+ answer);
            }
            else if(current == 4){
                Option4.setText(num1 + "*" + num2 + " = "+ answer);
            }
            else if(current == 5){
                Option5.setText(num1 + "*" + num2 + " = "+ answer);
            }
        }else if(operation == 2){
            if(current == 1){
                Option1.setText(num1 + "-" + num2 + " = "+ answer);
            }
            else if(current == 2){
                Option2.setText(num1 + "-" + num2 + " = "+ answer);
            }
            else if(current == 3){
                Option3.setText(num1 + "-" + num2 + " = "+ answer);
            }
            else if(current == 4){
                Option4.setText(num1 + "-" + num2 + " = "+ answer);
            }
            else if(current == 5){
                Option5.setText(num1 + "-" + num2 + " = "+ answer);
            }
        }
    }



}