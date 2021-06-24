package by.htp.basic.loop;

import java.util.Scanner;

public class SequenceSum {
	//1. Напишите программу, где пользователь вводит любое целое положительное число. 
	//А программа суммирует все числа от 1 до введенного пользователем числа.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int value=enterValue(sc, "Enter positive number: ");
		
		System.out.println("The sum of numbers from 0 to "+ value +" is "+ sum(value));
	}
	
	public static int sum(int value) {
		int sum=0;
		
		for(int i=1;i<=value;i++ ) {
			sum+=i;
		}
		return sum;
	}
	
	public static int enterValue(Scanner sc,String message) {
		int value;
		
		System.out.println(message);
		
		do {
			while(!sc.hasNextInt()) {
				System.out.println("Your input is not an integer. Try again: ");
				sc.next();
			}
			
			value=sc.nextInt();
			if(value<=0) {
				System.out.println("You should enter positive number. Try again: ");
			}
		}while(value<=0);
		
		return value;
	}

}
