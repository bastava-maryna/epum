package by.htp.algorithms.onedimarray;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ValueBiggerIndex {
	//5. Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int numberOfElements=0;
		
		do {
			numberOfElements=enterValue(sc, "Enter the number of elements: ");
			
			if(numberOfElements<=0) {
				System.out.println("You should eneter positive number. Try again: ");
			}
		}while(numberOfElements<=0);
		
		int []array=createArray(numberOfElements);
		
		System.out.println("The numbers to proceed:");
		printArray(array);
		
		System.out.println("The numbers for which a(i)>i :");
		System.out.println(select(array));
	}
	
	
	public static ArrayList<Integer> select(int[] array) {
		ArrayList <Integer> result= new ArrayList<Integer>();		
		
		for(int i=0;i<array.length;i++) {
			if(array[i]>(i+1)) {
				result.add(array[i]);
			}
		}
		
		return result;
	}
	
	
	public static int[] createArray(int numberOfElements) {
		int [] array=new int [numberOfElements];
		Random rand= new Random();
		
		for(int i=0;i<numberOfElements;i++) {
			array[i]=rand.nextInt(40)-20;
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
	
	
	public static void printArray(int[]array) {
		
		int index=1;
		for(int elem:array) {
			System.out.println("["+ (index++)+ "]   " + elem);
		}
	}

}
