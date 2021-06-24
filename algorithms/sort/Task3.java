package by.htp.algorithms.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task3 {
	/*3. Сортировка выбором. 
	 Дана последовательность чисел n a1<=a2<=...<=an.
	 Требуется переставить элементы так, чтобы они были расположены по убыванию. 
	 Для этого в массиве, начиная с первого, выбирается наибольший элемент и ставится на первое место, 
	 а первый - на место наибольшего. 
	 Затем, начиная со второго, эта процедура повторяется. 
	 Написать алгоритм сортировки выбором.
	*/

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int size=enterValue(sc, "Enter the size of the sequence: ");
		
		int []array=createDecreasingArray(size);
		
		System.out.println("Given sequence:");
		printArray(array);
		
		System.out.println("Result:");
		sort(array);
		printArray(array);
		
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
	
	
	public static int[] createDecreasingArray(int numberOfElements) {
		int [] array=new int [numberOfElements];
		Random rand= new Random();
		
		for(int i=0;i<numberOfElements;i++) {
			array[i]=rand.nextInt(50)-25;
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

	
	public static void sort(int [] array) {
		int size=array.length;
		
		for(int j=0;j<size;j++) {
			int cur=array[j];
			int maxInd=j;
			
			for(int i=j+1;i<size;i++) {
				if(array[i]>cur ) {
					cur=array[i];
					maxInd=i;
				}
			}
			
			if(maxInd!=j) {
				int temp=array[j];
				array[j]=array[maxInd];
				array[maxInd]=temp;
			}
		}
	}
}
