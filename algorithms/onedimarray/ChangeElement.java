package by.htp.algorithms.onedimarray;

import java.util.Random;
import java.util.Scanner;

public class ChangeElement {
	//2. Дана последовательность действительных чисел а1 ,а2 ,..., ап. 
	//Заменить все ее члены, большие данного Z, этимчислом. 
	//Подсчитать количество замен.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int pivot=0;
		
		double []sequence= createArray(enterValue(sc, "Enter number of elements in the sequence: "));
		pivot=enterValue(sc, "Enter number to compare and replace: ");
		
		System.out.println("The initial sequence:");
		printArray(sequence);
		
		System.out.println("The number of replacements: " + numberOfReplacements(sequence,pivot)+"\n");
		
		System.out.println("The final sequence:");
		printArray(sequence);
	}
	
	
	public static int numberOfReplacements(double []array, int pivot) {
		int count=0;
		
		for(int i=0;i<array.length;i++) {
			if(array[i]>pivot) {
				array[i]=pivot;
				count++;
			}
		}

		return count;
	}
	
	public static double[] createArray(int numberOfElements) {
		double [] array=new double [numberOfElements];
		Random rand= new Random();
		
		for(int i=0;i<numberOfElements;i++) {
			//nextDouble() generate numbers between 0 and 1
			array[i]=100*rand.nextDouble()-50;
		}
		return array;
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
	
	
	public static void printArray(double[]array) {
		for(double elem:array) {
			System.out.println(elem);
		}
	}
}
