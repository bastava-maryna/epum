package by.htp.algorithms.decomposition;

import java.util.Scanner;

public class Task1 {
	//1. Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
	//натуральных чисел:   see task list

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int first_number=enterValue(sc, "Enter first natural number:");
		int second_number=enterValue(sc, "Enter second natural number:");
		
		System.out.println("You enter:\nfirst_number=" + first_number+"\nsecond number="+second_number + "\n");
		
		System.out.println("Greatest common factorv =" + findGreatestCommonFactor(first_number,second_number));
		System.out.println("Least common multiple=" + findLeastCommonMultiple(first_number,second_number));
		
		sc.close();
	}
	
	
	public static int enterValue(Scanner sc, String message) {
		int value=0;
		System.out.println(message);
		
		do {
			while(!sc.hasNextInt()) {
				System.out.println("Your input is not integer number. Try again: ");
				sc.next();
			}
			value=sc.nextInt();
			
			if(value<=0) {
				System.out.println("Your input is not natural number. Try again: ");
			}
		}
		while (value<=0);
		
		return value;
	}
	
	
	public static int findGreatestCommonFactor(int first_number,int second_number) {
		int result=1;
		
		int range= (first_number<=second_number) ? first_number :second_number;
		
		for(int i=2;i<=range;i++) {
			if(first_number%i==0 && second_number%i==0) {
					result=i;
			}
		}
		
		return result;
	}
	
	
	public static int findLeastCommonMultiple(int first_number,int second_number) {
		int greatest_common_factor=findGreatestCommonFactor(first_number,second_number);
		
		return first_number*second_number/greatest_common_factor;
	}
}
