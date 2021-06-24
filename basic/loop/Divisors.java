package by.htp.basic.loop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Divisors {
	//7. Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
	//m и n вводятся с клавиатуры.

	public static void main(String[] args) {
		int m;
		int n;
		
		Scanner sc=new Scanner(System.in);
		
		do {
			m= enterValue(sc, "Enter m:");
			n= enterValue(sc, "Enter n:");	
		}while(isValid(m,n)==false);
		
		List<Integer>[]result=calculate(m,n);
		
		for(int i=0; i<=n-m; i++) {
			System.out.print("For "+ (i+m) + " divisors different from 1 and "+ (i+m) +" are: " );
			
			for(int divisor : result[i])
				if(divisor>1 && divisor!=i+m) {
					System.out.print(divisor + " ");
				}
			System.out.println();
		}
	}
	
	
	public static int enterValue(Scanner sc, String message) {
		int value=0;
		
		System.out.println(message);
		
		do {
			while(!sc.hasNextInt()) {
				System.out.println("Your input is not an integer. Try again: ");
				sc.next();
			}
			value=sc.nextInt();
			if(value<=0) {
				System.out.println("You should enter number bigger than 0");
			}
		
		}while(value<=0);
		
		return value;
	}
	
	
	public static List<Integer>[] calculate(int m, int n){
		int digitNumber=n-m+1;
		@SuppressWarnings("unchecked")
		List<Integer>[] result= new ArrayList [digitNumber];
		
		for(int i=0, digit=m; i<digitNumber && digit<=n;i++,digit++) {
			result[i]=new ArrayList<Integer>();
			
			for(int divisor=1;divisor<=digit;divisor++) {
				if(digit%divisor==0) {
					result[i].add(divisor);
				}
			}
		}
	
		return result;
	}
	
	
	public static boolean isValid (int m, int n) {
		if(m>=n) {
			System.out.println("m should be smaller than n");
			return false;
		}
		return true;
	}
}
