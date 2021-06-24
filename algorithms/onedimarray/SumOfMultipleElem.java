package by.htp.algorithms.onedimarray;

import java.util.Random;
import java.util.Scanner;

public class SumOfMultipleElem {
	//1. В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int numberOfElements=0;
		int multiple=1;
		
		do {
			numberOfElements=enterValue(sc, "Enter the number of elements: ");
			
			if(numberOfElements<=0) {
				System.out.println("You should eneter positive number. Try again: ");
			}
		}while(numberOfElements<=0);
		
		do {
			multiple=enterValue(sc, "Enter the multiple: ");
			
			if(multiple==0) {
				System.out.println("You eneter wrong value (0). Try again: ");
			}
		} while(multiple==0);
		
		int []array=createArray(numberOfElements);
		
		System.out.println("Array to proceed: ");
		printArray(array);
		System.out.println("Sum of elements multiple to " + multiple + " is: " + sumOfMultipleElem(array, multiple));
	}
	
	
	public static int[] createArray(int numberOfElements) {
		int [] array=new int [numberOfElements];
		Random rand= new Random();
		
		for(int i=0;i<numberOfElements;i++) {
			array[i]=rand.nextInt(100);
		}
		return array;
	}
	
	public static int sumOfMultipleElem(int [] array, int multiple) {
		int sum=0;
		
		for(int elem:array ) {
			if(elem%multiple==0) {
				sum+=elem;
			}
		}
		
		return sum;
	}
	
	
	public static void printArray(int[]array) {
		for(int elem:array) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
	
	
	public static int enterValue(Scanner sc, String message){
		int value;
		
		System.out.println(message);
		
		while(!sc.hasNextInt()) {
			System.out.println("Your input is not an integer. Try again: ");
			sc.next();
		}
		value=sc.nextInt();
				
		return value;
	}	
}
