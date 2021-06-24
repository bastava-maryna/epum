package by.htp.basic.loop;

import java.util.Scanner;

public class SeriesSum {
	//5. Даны числовой ряд и некоторое число е. 
	//Найти сумму тех членов ряда, модуль которых больше или равен заданному е. 
	//Общий член ряда имеет вид: see task list

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		float e=enterValue(sc, "Enter positive value of e ");
		System.out.println("When e= " + e + " result is " + calculate(e));
	}
	
	public static float enterValue(Scanner sc, String message) {
		float value=0;
		
		System.out.println(message);
		
		do {
			while(!sc.hasNextFloat()) {
				System.out.println("Your input is not a number. Try again: ");
				sc.next();
			}
			
			value=sc.nextFloat();
			if(value<=0) {
				System.out.println("Value should be bigger than 0. Try again: ");
			}
		}while(value<=0);
		
		return value;
	}
	
	public static double calculate(float e) {
		double result=0;
		int n=0;
		
		do {
			double term=1/Math.pow(2, n)+1/Math.pow(3, n);

			if(term<e) {
				break;
			}
			//System.out.println("term"+ n + " = "+term);
			result+=term;
			n++;
		}while(true);
		
		return result;
	}
	
	

}
