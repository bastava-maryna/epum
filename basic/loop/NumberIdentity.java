package by.htp.basic.loop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberIdentity {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int firstNumber=enterValue(sc, "Enter first number: ");
		int secondNumber=enterValue(sc, "Enter second number: ");
		
		System.out.println("The common digits in " + firstNumber + " and " + secondNumber + " are: " + findCommonDigits(firstNumber, secondNumber));
	}

	
	public static List<Integer> findCommonDigits(int a, int b) {
		List<Integer>result=new ArrayList<>();
		char [] aChar= String.valueOf(a).toCharArray();
		char [] bChar= String.valueOf(b).toCharArray();

		for( char aDigit : aChar) {
			for(char bDigit :bChar) {
				if(aDigit==bDigit) {
					if(!result.contains(aDigit-'0')) {
						result.add(aDigit-'0');
					}	
				}
			}
		}		
		
		return result;
	}
	
			
	public static int enterValue(Scanner sc, String message) {
		int value;
		System.out.println(message);
		
		while(!sc.hasNextInt()) {
			System.out.println("Your input is not an integer. Try again:");
			sc.next();
		}
		value=sc.nextInt();
		
		return value;
	}
}
