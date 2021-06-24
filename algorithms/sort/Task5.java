package by.htp.algorithms.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task5 {
	/*5. Сортировка вставками. 
	 Дана последовательность чисел a1,a2...,an . 
	 Требуется переставить числа в порядке возрастания. 
	 Делается это следующим образом. Пусть a1,a2 ,... ,ai - упорядоченная последовательность, т. е.
	a1<=a2<...<=an. Берется следующее число ai+1 a и вставляется в последовательность так, чтобы новая
	последовательность была тоже возрастающей. 
	Процесс производится до тех пор, пока все элементы от i+1 до n не будут перебраны. 
	Примечание. Место помещения очередного элемента в отсортированную часть производить с помощью двоичного поиска. 
	Двоичный поиск оформить в виде отдельной функции.
	*/

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int size=enterValue(sc, "Enter the size of the array: ");
		
		int []array=createArray(size);
		//int []array= {1,1,1,1,1,1,1};
		
		System.out.println("Given array:");
		printArray(array);
		
		System.out.println("The element which less than maximal element but bigger than the others:");
		System.out.println(calculate(array));
		
		System.out.println("Sorted array:");
		Arrays.sort(array);
		printArray(array);
		
		sc.close();
	}

	
	public static int enterValue(Scanner sc, String message) {
		int value=0;
		System.out.println(message);
		
		while(!sc.hasNextInt()) {
			System.out.println("Your input is not a integer number. Try again:");
			sc.next();
		}
		
		value=sc.nextInt();
		
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

	
	public static  int calculate(int[]array) {
		int result=0;
		int count=0;
		
		for (int i=0; i<array.length;i++) {
			int cur_max=array[i];
			int max_index=i;
			
			for(int j=i+1;j<array.length;j++) {
				
				if(array[j]>cur_max) {
					cur_max=array[j];
					max_index=j;
				}	
			}	
			
			if(max_index!=i) {
				int temp=array[i];
				array[i]=array[max_index];
				array[max_index]=temp;
				
				if(count==0) {
					result=array[i];
					count++;
				}
				else if(result!=array[i]) {  //skip equal
					result=array[i];
					count++;
				}
				
				if(count==2) {
					return result;
				}
			}
		}
		
		return result;
	}
}