package by.htp.algorithms.decomposition;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task8 {
	//8. Задан массив D. 
	//Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
	//Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов массива с номерами от k до m.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int[]index_array= {1,3,4};
		Arrays.sort(index_array);
		int array_size=0;
		int control_size=0;
		
		do {
			control_size=index_array[index_array.length-1]+3;
			array_size=enterValue(sc, "Enter the number of elements no less than: "+control_size);
			if(array_size<control_size) {
				System.out.println("The array size is small for this task. Try again:");
			}
		}	while(array_size<control_size);
		
		int []array=createArray(array_size);
		
		System.out.println("The given array:");
		printArray(array);
		
		System.out.println("The result :");
		calculate(array,index_array);

		int start_index=enterValue(sc, "Enter the first index to find the sum of 3 consequative elements: ");
		System.out.println("The sum of 3 consequative elements start from "+start_index+" is:" +sumOf3ConsequativeElements(array,start_index));
	}
	
	
	public static void calculate(int[]array,int[]start_index) {
		int[]result=new int [3];
		
		for(int i=0;i<start_index.length;i++) {
			result[i]=sumOf3ConsequativeElements(array,start_index[i]);
		}
		
		printResult(result,start_index);
	}
	
	
	public static void validateInputParameters(int array_size, int start_index) {
		if (array_size<3) {
			System.out.println("The array size is too small for this task. Program is terminated");
			System.exit(0);
		}
		if (start_index>array_size-3) {
			System.out.println("The start index is too large for this task. Program is terminated");
			System.exit(0);
		}
		
	}
	
	
	public static int sumOf3ConsequativeElements(int[]array,int start_index) {
		validateInputParameters(array.length,start_index);
		
		int sum=0;
		
		for(int i=start_index;i<start_index+3;i++) {
			sum+=array[i];
		}
			
		return sum;
	}
		
	
	public static int[] createArray(int numberOfElements) {
		int [] array=new int [numberOfElements];
		Random rand= new Random();
		
		for(int i=0;i<numberOfElements;i++) {
			array[i]=rand.nextInt(30)-15;
		}
		return array;
	}
	
	
	public static int enterValue(Scanner sc, String message) {
		int value=0;
		System.out.println(message);
		
		do {
			while(!sc.hasNextInt()) {
				System.out.println("Your input is not an integer number. Try again:");
				sc.next();
			}
			
			value=sc.nextInt();
			
			if(value<=0) {
				System.out.println("You enter not a natral number  . Try again: ");
			}
		}
		while(value<=0);
		
		return value;
	}
	
	
	public static void printArray(int[]array) {
		for(int elem:array) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}


	public static void printResult(int[]result,int[]start_index) {
		for(int i=0;i<result.length;i++) {
			System.out.println("D["+start_index[i]+"]+D["+(start_index[i]+1)+"]+D["+(start_index[i]+2)+"]="+result[i]);
		}
	}
}
