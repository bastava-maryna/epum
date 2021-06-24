package by.htp.algorithms.onedimarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MostPopularTerm {
	//9. В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. 
	//Если таких чисел несколько, то определить наименьшее из них.

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
		
		System.out.println("The sequence to proceed:");
		printArray(array);
		
		System.out.println("The least most popular term is: " + mostPopularTerm(array));
	}
	
	
	public static int mostPopularTerm(int[] array) {
		Arrays.sort(array);
		
		int maxCounter=1;
		int tempCounter=1;
		ArrayList<Integer> candidateList=new ArrayList<Integer>();
		
		for(int i=0;i<array.length-1;i++) {
			if(array[i]==array[i+1]) {
				tempCounter++;
			}else {
				if(tempCounter>maxCounter) {
					candidateList.clear();
					candidateList.add(array[i]);
					maxCounter=tempCounter;
				}else if(tempCounter==maxCounter) {
					candidateList.add(array[i]);
				}
				tempCounter=1;
			}
		}
		//printArray(array);
		//System.out.println(candidateList);	
		
		return candidateList.get(0);
	}
	
	
	public static int[] createArray(int numberOfElements) {
		int [] array=new int [numberOfElements];
		Random rand= new Random();
		
		for(int i=0;i<numberOfElements;i++) {
			array[i]=rand.nextInt(20)-10;
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
		for(int elem:array) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
}
