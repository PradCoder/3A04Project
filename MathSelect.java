import java.math.*;
import java.util.*;

public class MathSelect {

	private int score;
	private int correct;
	

	public MathSelect() {
		score = 0;
		run();
	}
	
	private void run() {
		while(score<5) {
			generate();
			guess();
		}
		if(score == 5) {
			System.out.println("You Win!");
		}
		
	}
	
	
	private void generate() {
		correct = (int)(5*Math.random() + 1);
		for(int i = 1; i < 6; i++) {	
			if(i == correct) {
				PrintQuestion(i, true);
			}
			else {
				PrintQuestion(i, false);
			}
		}
	}
	
	private void guess() {
		Scanner guessScan = new Scanner(System.in);
		int userGuess;
		
		System.out.println("Enter the correct equation(1-5): ");
		userGuess = guessScan.nextInt();
		
		if(userGuess == correct) {
			score+=1;
			System.out.println("Correct Answer!");
			System.out.println("Score = " + score);
		}else {
			score = 0;
			System.out.println("Incorrect Answer");
			System.out.println("Score = " + score);
		}
		
	}
	
	private void PrintQuestion(int current, boolean valid) {
		int operation = (int)(3*Math.random());
		int num1,num2, answer;
		if(valid) {
			if(operation == 0) {
				num1 = (int)(10*Math.random()+1);
				num2 = (int)(10*Math.random()+1);
				answer = num1+num2;
				System.out.println(current + ". " + num1 + '+' + num2 + " = " + answer);
			}else if(operation == 1) {
				num1 = (int)(10*Math.random()+1);
				num2 = (int)(10*Math.random()+1);
				answer = num1*num2;
				System.out.println(current + ". " + num1 + 'x' + num2 + " = " + answer);
			}else if(operation == 2) {
				num1 = (int)(10*Math.random()+1);
				num2 = (int)(10*Math.random()+1);
				answer = num1-num2;
				System.out.println(current + ". " + num1 + '-' + num2 + " = " + answer);
			}
		}else {
			if(operation == 0) {
				num1 = (int)(10*Math.random()+1);
				num2 = (int)(10*Math.random()+1);
				answer = num1+num2 + 1;
				System.out.println(current + ". " + num1 + '+' + num2 + " = " + answer);
			}else if(operation == 1) {
				num1 = (int)(10*Math.random()+1);
				num2 = (int)(10*Math.random()+1);
				answer = num1*num2 + 1;
				System.out.println(current + ". " + num1 + 'x' + num2 + " = " + answer);
			}else if(operation == 2) {
				num1 = (int)(10*Math.random()+1);
				num2 = (int)(10*Math.random()+1);
				answer = num1-num2 + 1;
				System.out.println(current + ". " + num1 + '-' + num2 + " = " + answer);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		MathSelect test = new MathSelect();
	}

}
