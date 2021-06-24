package by.htp.basic.branching;

import java.util.Scanner;

public class FunctionValue4 {
	//5. Вычислить значение функции:see task list

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x= enterValue(sc,"Enter x: ");
		
		System.out.println( "x= "+ x + ";  F(x)= " +calculate(x));
		sc.close();
	}
	
	
	public static double calculate(int x) {
		int temp1= x*x -3*x +9;
		double temp2= 1/(Math.pow(x, 3)+6);
		
		return (x>3) ? temp2 : temp1;	
	}
	
	
	public static int enterValue(Scanner sc, String message) {
		int value; 
		
		System.out.println(message);
		
		while(!sc.hasNextInt()) {
			System.out.println("Your input is not an Integer.BYTES try again: ");
			sc.next();
		}
		value=sc.nextInt();
		
		return value;
	}
}
