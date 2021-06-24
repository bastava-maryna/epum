package by.htp.algorithms.sort;

import java.util.Random;
import java.util.Scanner;

public class Task4 {
	/*4. Сортировка обменами. Дана последовательность чисел n a1<=a2<=...<=an .
	 Требуется переставить числа в порядке возрастания. 
	 Для этого сравниваются два соседних числа a1 и ai+1. Если ai>ai+1, то делается перестановка. 
	 Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
	 Составить алгоритм сортировки, подсчитывая при этом количества перестановок.
	*/

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int size=enterValue(sc, "Enter the size of the sequence: ");
		
		int []array=createArray(size);
		
		System.out.println("Given sequence:");
		printArray(array);
		
		System.out.println("Result:");
		int number_of_swaps=sortBySwap(array);
		printArray(array);
		System.out.println("Number of swaps: "+number_of_swaps);
		
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
	
	
	public static int[] createArray(int numberOfElements) {
		int [] array=new int [numberOfElements];
		Random rand= new Random();
		
		for(int i=0;i<numberOfElements;i++) {
			array[i]=rand.nextInt(50)-25;
		}
		
		return array;
	}
	
	
	public static void printArray(int[]array) {
		for(int elem:array) {
			System.out.printf("%5d",elem);
		}
		System.out.println();
	}

	public static int sortBySwap(int [] array) {
		int size=array.length;
		int swaps=0;
		
		for(int j=0;j<size;j++) {
			
			for(int i=0;i<size-1;i++) {
				if(array[i]>array[i+1] ) {
					int temp=array[i];
					array[i]=array[i+1];
					array[i+1]=temp;
					swaps++;
				}
			}			
		}
		
		return swaps;
	}
	
}
