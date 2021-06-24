package by.htp.algorithms.decomposition;

import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
	//2. Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int number1=enterValue(sc,"Enter first number:");
		int number2=enterValue(sc,"Enter second number:");
		int number3=enterValue(sc,"Enter third number:");
		int number4=enterValue(sc,"Enter forth number:");
		
		System.out.println("You enter:\nnumber1=" + number1 + "\nnumber2=" + number2 + "\nnumber3=" + number3 + "\nnumber4=" + number4 + "\n");
		System.out.println("Greatest common factor=" + findGreatestCommonFactor(number1,number2,number3,number4 ));
		
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
	
	
	public static int findGreatestCommonFactor(int number1, int number2, int number3, int number4) {
		int result=1;
		
		int temp1=(number1<number2)?number1:number2;
		int temp2=(number3<number4)?number3:number4;
		int min=(temp1<temp2)?temp1:temp2;
		
		ArrayList<Integer> prime_factors=findPrimeFactors(min);
		
		for(int elem:prime_factors) {
			if(number1%elem==0 && number2%elem==0 && number3%elem==0 && number4%elem==0) {
				result*=elem;
			}
		}
		
		return result;
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
