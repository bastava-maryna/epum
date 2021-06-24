package by.htp.algorithms.sort;

import java.util.Random;
import java.util.Scanner;

public class Task1 {
	//1. Заданы два одномерных массива с различным количеством элементов и натуральное число k. 
	//Объединить их в один массив, включив второй массив между k-м и (k+1) - м элементами первого,
	//при этом не используя дополнительный массив.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int size1=enterValue(sc, "Enter the size of first array: ");
		int size2=enterValue(sc, "Enter the size of second array: ");
		
		int []array1=createArray(size1);
		int []array2=createArray(size2);
		
		int pivot=enterLimitedValue(sc,"Enter pivot - nonnegative number less than "+ size1+" : ",size1);	
		
		System.out.println("First array:");
		printArray(array1);
		
		System.out.println("Second array:");
		printArray(array2);
		
		System.out.println("Pivot: "+pivot);
		
		System.out.println("Result:");
		printArray(combine(array1,array2,pivot));
		
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
	
	
	public static int[] combine(int[]array1,int[]array2,int pivot){
		int[]result=new int[array1.length+array2.length];
		
		for (int i=0;i<=pivot;i++) {
			result[i]=array1[i];
		}
		
		for (int i=0;i<array2.length;i++) {
			result[i+pivot+1]=array2[i];
		}
		
		for (int i=pivot+1;i<array1.length;i++) {
			result[i+array2.length]=array1[i];
		}
		
		return result;
	}
	
	
	public static int[] createArray(int numberOfElements) {
		int [] array=new int [numberOfElements];
		Random rand= new Random();
		
		for(int i=0;i<numberOfElements;i++) {
			array[i]=rand.nextInt(30)-15;
		}
		return array;
	}
	
	
	public static void printArray(int[]array) {
		for(int elem:array) {
			System.out.printf("%5d",elem);
		}
		System.out.println();
	}
}
