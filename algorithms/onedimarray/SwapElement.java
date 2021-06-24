package by.htp.algorithms.onedimarray;

import java.util.Random;
import java.util.Scanner;

public class SwapElement {
	//4. Даны действительные числа а1 ,а2 ,..., аn . 
	//Поменять местами наибольший и наименьший элементы.

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
		
		System.out.println("Sequence to proceed:");
		printArray(array);
		
		swapMaxMinElement(array);
		
		System.out.println("After:");
		printArray(array);
	}
	
	//we have no rule about equal elements
	//function swaps elements with min indexes
	public static void swapMaxMinElement(double[] array) {
		int maxIndex=0;
		int minIndex=0;
		double max=array[0];
		double min=array[0];
		
		for(int i=0;i<array.length;i++) {
			if(array[i]<min) {
				min=array[i];
				minIndex=i;
			}else if(array[i]>max) {
				max=array[i];
				maxIndex=i;
			}
		}
		
		//System.out.println("minimal element: " + min);
		//System.out.println("maximal element: " + max);
		
		if(maxIndex!=minIndex) {
			array[minIndex]=max;
			array[maxIndex]=min;
		}
	}
	
	//return indexes of elements swapped
	public static int[] swapMaxMinElement1(int[] array) {
		int maxIndex=0;
		int minIndex=0;
		int max=array[0];
		int min=array[0];
		
		for(int i=0;i<array.length;i++) {
			if(array[i]<min) {
				min=array[i];
				minIndex=i;
			}else if(array[i]>max) {
				max=array[i];
				maxIndex=i;
			}
		}
		//-1 means that nothing was swapped
		if(maxIndex==minIndex) {
			return (new int[] {-1,-1});
		}
		
		array[minIndex]=max;
		array[maxIndex]=min;
		
		return (new int[]{minIndex,maxIndex});
	}
	
	public static double[] createArray(int numberOfElements) {
		double [] array=new double [numberOfElements];
		Random rand= new Random();
		
		for(int i=0;i<numberOfElements;i++) {
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
