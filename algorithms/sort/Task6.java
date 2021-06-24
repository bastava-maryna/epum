package by.htp.algorithms.sort;

import java.util.Random;
import java.util.Scanner;

public class Task6 {
	/*6. Сортировка гномья. 
	 Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
	 Делается это следующим образом: сравниваются два соседних элемента ai  и ai+1. Если ai<=ai+1,
 	 то продвигаются на один элемент вперед. 
 	 Если ai>ai+1, то производится перестановка и сдвигаются на один элемент назад.
     Составить алгоритм этой сортировки.
	 */

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int size=enterValue(sc, "Enter the size of the sequence: ");
		
		double []array=createArray(size);
		//double []array= {12,4,4,6,-2,0,18,17};
		
		System.out.println("Given sequence:");
		printArray(array);
		
		System.out.println("Result:");
		sortGnome(array);
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
	
	
	public static double[] createArray(int numberOfElements) {
		double [] array=new double [numberOfElements];
		Random rand= new Random();
		
		for(int i=0;i<numberOfElements;i++) {
			array[i]=100*rand.nextDouble()-50;
		}
		
		return array;
	}
	
	
	public static void printArray(double[]array) {
		for(double elem:array) {
			System.out.printf("%7.2f",elem);
		}
		System.out.println();
	}

	
	public static void sortGnome(double [] array) {
		int size=array.length;
		
		for(int j=1;j<size;j++) {							
			int k=j;
		
			while(k>0 && array[k-1]>array[k]) {		
				double temp=array[k-1];
				array[k-1]=array[k];
				array[k]=temp;
				k--;
			}
		}				
	}
}
