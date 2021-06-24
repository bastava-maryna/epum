package by.htp.basic.branching;

import java.util.Scanner;

public class MaxMin {
//2. Найти max{min(a, b), min(c, d)}.	
	
//if we need find only max value, then all is ok
	
	public static void main(String[] args) {
		int a;
		int b;
		int c;
		int d;
		
		Scanner sc=new Scanner(System.in);
		a=enterValue(sc, "Enter a: ");
		b=enterValue(sc, "Enter b: ");
		c=enterValue(sc, "Enter c: ");
		d=enterValue(sc, "Enter d: ");
		
		System.out.println("You entered: \n" + "a = " + a + "\nb = "+ b +"\nc = "+ c + "\nd = "+ d);
		System.out.println("The max(min(a,b),min(c,d)) is " + max(min(a,b),min(c,d)))      ;
		
		sc.close();
	}
	
	public static int min(int a, int b) {
		return (a<b==true ? a : b );
	}
	
	public static int max(int a, int b) {
		return (a>b==true ? a : b );
	}
	
	public static int enterValue(Scanner sc,String message) {
		int value;
		
		System.out.println(message);
		
		while(!sc.hasNextInt()) {
			System.out.println("Your input not a number. Try again: ");
			sc.next();
		}
		value=sc.nextInt();
		
		return value;
	}

}
