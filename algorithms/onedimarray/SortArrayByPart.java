package by.htp.algorithms.onedimarray;

import java.util.Random;
import java.util.Scanner;

public class SortArrayByPart {
	//3. Дан массив действительных чисел, размерность которого N. 
	//Подсчитать, сколько в нем отрицательных,положительных и нулевых элементов.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int numberOfElements=0;
		
		do {
			numberOfElements=enterValue(sc, "Enter the number of elements: ");
			
			if(numberOfElements<=0) {
				System.out.println("You should eneter positive number. Try again: ");
			}
		}while(numberOfElements<=0);
		
		double []array=createArray(numberOfElements);
		int []partition=sortArrayByPart(array);
		
		System.out.println("Array to proceed:");
		printArray(array);
		
		System.out.println("The number of negative elements in array: " + partition[0]);
		System.out.println("The number of zero elements in array: " + partition[1]);
		System.out.println("The number of positive elements in array: " + partition[2]);
	}
	
	
	//type[0] will store number of negative elements 
	//type[1] will store number of zero elements 
	//type[2] will store number of positive elements 
	public static int[] sortArrayByPart(double[] array) {
		int[]type=new int[3];
		
		for(int i=0;i<array.length;i++) {
			if(array[i]<0) {
				type[0]++;						//negative
			}else if(array[i]>0) {
				type[2]++;						//positive
			}
		}
		type[1]=array.length-type[0]-type[2];   //zero
		
		return type;
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
