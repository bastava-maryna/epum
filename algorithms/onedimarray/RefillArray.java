package by.htp.algorithms.onedimarray;

import java.util.Random;
import java.util.Scanner;

public class RefillArray {
	//10. Дан целочисленный массив с количеством элементов п. 
	//Сжать массив, выбросив из него каждый второй элемент (освободившиеся элементы заполнить нулями). 
	//Примечание. Дополнительный массив не использовать

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
		
		System.out.println("The array to proceed:");
		printArray(array);
		
		refill(array);
		
		System.out.println("The final array: ");
		printArray(array);
	}
	
	
	public static void refill(int[] array) {
		
		for(int i=1;i<array.length;i+=2) {
			array[i]=0;
		}	
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
