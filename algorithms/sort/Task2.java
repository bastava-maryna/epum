package by.htp.algorithms.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
	//2. Даны две последовательности a1<=a2<=,,,<=an  и b1<=b2<=,,,<=bn . 
	//Образовать из них новую последовательность чисел так, чтобы она тоже была неубывающей. 
	//Примечание. Дополнительный массив не использовать.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int size1=enterValue(sc, "Enter the size of first array: ");
		int size2=enterValue(sc, "Enter the size of second array: ");
		
		int []array1=createNotDescendingArray(size1);
		int []array2=createNotDescendingArray(size2);
		
		System.out.println("First sequence:");
		printArray(array1);
		
		System.out.println("Second sequence:");
		printArray(array2);
		
		System.out.println("Result:");
		printArray(combine(array1,array2));
		
		sc.close();
	}

	
	public static int enterValue(Scanner sc, String message) {
		int value=0;
		System.out.println(message);
		
		do {
			while(!sc.hasNextInt()) {
				System.out.println("Your input is not a integer number. Try again:");
				sc.next();
			}
			value=sc.nextInt();
			
			if(value<=0) {
				System.out.println("You enter negative number or 0. Try again:");
			}
		}
		while (value<=0);
		
		return value;	
	}
	
	
	public static int enterLimitedValue(Scanner sc, String message, int limit) {
		int value=0;
		System.out.println(message);
		
		do {
			while(!sc.hasNextInt()) {
				System.out.println("Your input is not a integer number. Try again:");
				sc.next();
			}
			value=sc.nextInt();
			
			if(value>=limit || value<0) {
				System.out.println("Your number is out of bound. Try again:");
			}
		}
		while (value>=limit || value<0);
		
		return value;	
	}
	
	
	public static int[] combine(int[]array1,int[]array2){
		int[]result=new int[array1.length+array2.length];
		
		int i=0;
		int j=0;

		while(i<array1.length && j<array2.length) {
			if(array1[i]<array2[j]) {
				result[i+j]=array1[i];
				i++;
			}
			else  {
				result[i+j]=array2[j];
				j++;
			}
		}
		
		while(i<array1.length) {
			result[i+j]=array1[i];
			i++;
		}
		
		while(j<array2.length) {
			result[i+j]=array2[j];
			j++;
		}	
			
		return result;
	}
	
	
	public static int[] createNotDescendingArray(int numberOfElements) {
		int [] array=new int [numberOfElements];
		Random rand= new Random();
		
		for(int i=0;i<numberOfElements;i++) {
			array[i]=rand.nextInt(30)-15;
		}
		
		Arrays.sort(array);
		
		return array;
	}
	
	
	public static void printArray(int[]array) {
		for(int elem:array) {
			System.out.printf("%5d",elem);
		}
		System.out.println();
	}
}
