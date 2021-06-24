package by.htp.basic.loop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FunctionValue5 {
	//2. Вычислить значения функции на отрезке [а,b] c шагом h:see task ist

	public static void main(String[] args) {
		int start;
		int end;
		int step;
		Scanner sc=new Scanner(System.in);
		
		do {
			start=enterValue(sc,"Enter the interval start point: ");
			end=enterValue(sc,"Enter the interval end point: ");;
			step=enterValue(sc,"Enter the step to use on interval: ");
		} while(validateInput(start,end,step)==false);
		
		System.out.println("The function values on the given interval [" + start + ", " + end + "] with step " + step + ":" );
		System.out.println(calculate(start,end,step));
	}
	
	
	public static List<Integer> calculate(int start, int end, int step) {
		List <Integer> result=new ArrayList<>();
		
		for(int x=start; x<=end;x+=step) {
			if(x>2) {
				result.add(x);
			}else {
				result.add(-x);
			}
		}
		
		return result;
	}
	
	
	public static int enterValue(Scanner sc, String message) {
		int value;
		
		System.out.println(message);
		
		while(!sc.hasNextInt()) {
			System.out.println("Your input is not an integer Try again: ");
			sc.next();
		}
		value=sc.nextInt();
		
		return value;
	}
	
	
	public static boolean validateInput(int start, int end, int step) {
		if (start>end || step<=0) {
			System.out.println("You enter:\nstart = " + start + "\nend = " + end + "\nstep = " + step);
			System.out.println("The interval`s start point should be bigger than its end point AND\nThe step should be positive number bigger than 0");
			return false;
		}
		
		return true;
	}
}
