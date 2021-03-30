package com.example.gamecrush;
import java.util.Random;

public class NumberGuessData {

    public static int uBound = 100;
    public static int lBound = 0;
    public static int target;

    public static void initGame(){
        Random ran = new Random();
        target = lBound + ran.nextInt((uBound - lBound) + 1);
    }

    public static int wasGuessCorrect(int guess){
        return guess - target;
    }
}
