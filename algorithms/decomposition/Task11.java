package by.htp.algorithms.decomposition;

import java.util.Scanner;

public class Task11 {
	//11. Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int number1=enterValue(sc,"Enter first number:");
		int number2=enterValue(sc,"Enter second number:");
		
		System.out.println("You enter:\nnumber1=" + number1 + "\nnumber2=" + number2 );
		compareNumberOfDigits(number1,number2);
		
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
			
			if(value<=0) {
				System.out.println("You enter not a natural number. Try again: ");
			}
		}
		while(value<=0);
		
		return value;
	}
	
	
	public static int findNumberDigitsInNumber(int number) {
		if(number==0) {
			return 1;
		}
		
		return  (int)Math.ceil(Math.log10(number+0.5));        // log(1)=0, log(10)=1,..., so need +0.5 to obtain correct answer
	}
	
	
	public static void compareNumberOfDigits(int number1, int number2) {
		int h=findNumberDigitsInNumber(number1);
		int j=findNumberDigitsInNumber(number2);
		int result= h>j ? 1 :
				    h<j ? 2 : 0 ;
		
		switch(result) {
			case 1: 
				System.out.println("The number with more digits is " + number1);
				break;
			case 2: 
				System.out.println("The number with more digits is " + number2);
				break;
			case 0: 
				System.out.println("The numbers have equal number of digits ");
		}
		
		//alternative variant,   what is better?
		/*
		if(h>j){
			System.out.println("The number with more digits is " + number1);
		}else if (h<j) {
			System.out.println("The number with more digits is " + number2);
		}
		else {
			System.out.println("The numbers have equal number of digits ");
		}
		*/
	}

}
