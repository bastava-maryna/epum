package by.htp.algorithms.decomposition;

import java.util.ArrayList;
import java.util.Scanner;

public class Task15 {
	//15. Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую последовательность 
    //(например, 1234, 5789). Для решения задачи использовать декомпозицию.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int number_digits=enterValue(sc,"Enter number digits in numbers from 2 to 9:");  
		//int number_digits=6;
		
		System.out.println("You enter:\nnumber of digits in numbers = " + number_digits );
		
		System.out.println(calculate(number_digits).toString());
		System.out.println(calculate1(number_digits).toString());
		
		sc.close();
	}
	
	    
	public static int enterValue(Scanner sc, String message) {
		int value=0;
		System.out.println(message);
		
		do {
			while(!sc.hasNextInt()) {
				System.out.println("Your input is not an integer number. Try again:");
				sc.next();
			}
			
			value=sc.nextInt();
			
			if(value<2 || value>9) {
				System.out.println("You enter number less than 2 or bigger than 9. Try again: ");
			}
		}
		while(value<2 || value>9);
		
		return value;
	}
	
	
	public static int firstDigitOfMaxNumber(int number_size) {
		return  9-number_size+1;        
	}
	
	
	public static int buildNumber(int start_digit,int number_size) {
		String result=""+start_digit;
		
		for(int j=1;j<number_size;j++) {
			result+=start_digit+j;
		}
		
		return Integer.parseInt(result);
	}
	
	
	public static ArrayList<Integer> calculate(int number_size) {
		ArrayList<Integer>result=new ArrayList<Integer>();
		int first_of_max=firstDigitOfMaxNumber(number_size);
		
		for (int i=1;i<=first_of_max;i++) {
			result.add(buildNumber(i,number_size));
		}
		
		return result;
	}

	
	public static ArrayList<Integer> calculate1(int number_size) {
		ArrayList<Integer>result=new ArrayList<Integer>();
		int first_number=firstNumber(number_size);
		int max_number=maxNumber(number_size);
		int difference=numberDifference(number_size);
		
		int current=first_number;
		while(current<=max_number) {
			result.add(current);
			current+=difference;
		}
		
		return result;
	}
	
	
	public static int numberDifference(int number_size) {
		int result=0;
		
		for (int i=(number_size-1);i>=0;i--) {
			result+=Math.pow(10, i);
		}	
		//alternative way : what`s better?
		/*
		String dif="111111111";
		dif=dif.substring(0, number_size);
		result=Integer.parseInt(dif);
		*/
		
		return result;
	}
	
	
	public static int firstNumber(int number_size) {
		String temp="1";
		
		for(int i=1;i<number_size;i++) {
			temp+=1+i;
		}
		
		return Integer.parseInt(temp);
	}
	
	
	public static int maxNumber(int number_size) { 
		int max=0;
		int first_digit=firstDigitOfMaxNumber(number_size);
		String temp=""+first_digit;
		
		for(int i=1;i<number_size;i++) {
			temp+=first_digit+i;
		}
		
		max=Integer.parseInt(temp);
		
		return max;
	}
	
}
