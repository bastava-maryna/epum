package by.htp.algorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task7 {
	/*
	 7. Пусть даны две неубывающие последовательности действительных чисел a1<=a2<=...<=an и b1<=b2<=...<=bm.
     Требуется указать те места, на которые нужно вставлять элементы последовательности b1<=b2<=...<=bm в первую
     последовательность так, чтобы новая последовательность оставалась возрастающей.
	 */

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int size1=enterValue(sc, "Enter the size of first array: ");
		int size2=enterValue(sc, "Enter the size of second array: ");
		
		int []array1=createNotDescendingArray(size1);
		int []array2=createNotDescendingArray(size2);
		
		//int []array1= {-13,-12,-9,-7,-6,0,7,8,11,13};
		//int []array2= {-15,-7,-2,-1,0,0,1,11,13};
		
		//int []array1= {-13,7,8,11};
		//int []array2= {13};
		
		
		System.out.println("First sequence:");
		printArray(array1);
		
		System.out.println("Second sequence:");
		printArray(array2);
		
		System.out.println("Result:");
		System.out.println(findInsertionPlaces(array1,array2));
		
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
	
	
	public static ArrayList<Integer> findInsertionPlaces(int[]array1,int[]array2){
		int size1=array1.length;
		int size2=array2.length;
		ArrayList<Integer>index_list=new ArrayList<Integer>();
		int index=0;
		
		for(int i=0;i<size2;i++) {
			for(int j=index;j<size1;j++){
				//System.out.println("i="+i+" j="  + j +" index=" +index);
				if (array2[i]<=array1[j]) {
					index_list.add(j);
					index=j;
					break;
				}
				if(j==size1-1) {
					index_list.add(size1);
				}
			}
		}
		      		
		return index_list;
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
