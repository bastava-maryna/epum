package by.htp.algorithms.decomposition;

import java.util.ArrayList;
import java.util.Scanner;

public class Task6 {
	//6. Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int number1=enterValue(sc,"Enter first number:");
		int number2=enterValue(sc,"Enter second number:");
		int number3=enterValue(sc,"Enter third number:");
		
		System.out.println("You enter:\nnumber1=" + number1 + "\nnumber2=" + number2 + "\nnumber3=" + number3 + "\n");
		System.out.println("These numbers are " + (isCoprimeNumbers(number1,number2,number3) ? "coprime" : "not coprime"));
		
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
	
	
	//vzaimno prostyje have no common divisor except 1
	public static boolean isCoprimeNumbers(int number1, int number2, int number3) {
		int temp=(number1<number2)?number1:number2;
		int min=(temp<number3)?temp:number3;
		
		ArrayList<Integer> prime_factors=findPrimeFactors(min);
		
		for(int elem:prime_factors) {
			if(number1%elem==0 && number2%elem==0 && number3%elem==0) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public static boolean isPrime(int number) {
		for(int i=2;i<=Math.sqrt(number);i++) {
			if(number%i==0) {
				return false;
			}
		}
		return true;
	}
	
	
	public static ArrayList<Integer> findPrimeFactors(int number){
		ArrayList<Integer> prime_list=new ArrayList<Integer>();
		
		for(int i=2;i<=number;i++) {
			if(isPrime(i) && number%i==0) {
				prime_list.add(i);
			}
		}
		
		return prime_list;
	}

}
