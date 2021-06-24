package by.htp.algorithms.sort;

import java.util.Random;
import java.util.Scanner;

public class Task8 {
	//8.Даны дроби p1/q1, p2/q2, ..., pn/qn ( i i p , q - натуральные).
	//Составить программу, которая приводит эти дроби к общему знаменателю и упорядочивает их в порядке возрастания.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int size=enterValue(sc, "Enter the number of fractions: ");
		
		int []numerators=createNaturalArray(size);
		int []denominators=createNaturalArray(size);
		
		//int []numerators=   {10,1,9};
		//int []denominators= {15,15,15};
		
		System.out.println("Initial fractions:");
		printFractionArray(numerators,denominators);
		
		System.out.println("Least common denominator:");
		System.out.println(findLeastCommonMultiple(denominators));
		
		System.out.println("Result:");
		sortFractions(numerators,denominators);
		printFractionArray1(numerators,denominators);
		
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
	
	
	public static int findMaxFromArray(int[]array) {
		int max=array[0];
		
		for (int i=1;i<array.length;i++) {
			if(array[i]>max) {
				max=array[i];
			}
		}
		
		return max;
	}
	
		
	public static int findLeastCommonMultiple (int[] denominators) {              //LeastCommonDenominator
		int max_denom=findMaxFromArray(denominators);
		int mult=1;
		
		while(true) {
			for(int i=0;i<denominators.length;i++) {
				if(max_denom*mult%denominators[i]!=0 ) {
					break;
				}
				else if( i==denominators.length-1) {
					return max_denom*mult;
				}
			}
			mult+=1;
		}   	
	}
	
	
	public static void reduceToCommonDenominator(int[]numerators, int[] denominators) {
		int common_denom=findLeastCommonMultiple(denominators);
		for(int i=0;i<numerators.length;i++) {
			numerators[i]=numerators[i]*common_denom/denominators[i];
			denominators[i]=common_denom;
		}
	}
	
	
	public static void sort(int[]array) {
		
		for(int j=0;j<array.length;j++) {				//decrease of search range
			int temp_min_index=j;
			for(int i=j+1;i<array.length;i++) {
				if(array[i]<array[i-1]) {				//find min
					temp_min_index=i;
				}
			}
			
			if(temp_min_index!=j) {						//swap		
				int temp=array[j];
				array[j]=array[temp_min_index];
				array[temp_min_index]=temp;
			}
		}
			
	}

	
	public static void sortFractions(int[]numerators, int[]denominators) {
		reduceToCommonDenominator(numerators, denominators);
		sort(numerators);
	}
	
	
	public static int[] createNaturalArray(int numberOfElements) {
		int [] array=new int [numberOfElements];
		Random rand= new Random();
		for(int i=0;i<numberOfElements;i++) {
			int number=0;
			do {
				number=rand.nextInt(30);
			}
			while(number==0);
			array[i]=number;
		}
		
		return array;
	}
	
	
	public static void printArray(int[]array) {
		for(int elem:array) {
			System.out.printf("%5d",elem);
		}
		System.out.println();
	}

	
	public static void printFractionArray(int[]numerators, int[] denominators) {
		for(int i=0;i<numerators.length;i++ ) {
			System.out.printf("%7d/%d",numerators[i],denominators[i]);
		}
		System.out.println();
	}
	
	
	public static void printFractionArray1(int[]numerators, int[] denominators) {
		for(int i=0;i<numerators.length;i++ ) {
			System.out.printf("%7d",numerators[i]);
		}
		System.out.println();
		for(int i=0;i<numerators.length;i++ ) {
			System.out.printf("%7s","--");
		}
		System.out.println();
		for(int i=0;i<numerators.length;i++ ) {
			System.out.printf("%7d",denominators[i]);
		}
		System.out.println();
	}
}
