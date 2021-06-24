package by.htp.algorithms.onedimarray;


import java.util.Random;
import java.util.Scanner;

public class MinTerminator {
	//8. Дана последовательность целых чисел n a1,a1,... ,an . 
	//Образовать новую последовательность, выбросив из исходной те члены, которые равны min(a1,a2,... ,an) .

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
		
		System.out.println("The result :");
		printArray(minTerminate(array));
	}
	
	
	public static int[] minTerminate(int[] array) {
		int min=array[0];
		int minCount=1;
		
		for(int i=1;i<array.length;i++) {
			if(array[i]==min) {
				minCount++;
			}else if(array[i]<min) {
				min=array[i];
				minCount=1;
			}
		}
		
		int[] result= new int[array.length-minCount];
		int j=0;
		
		for(int i=0;i<array.length;i++) {
			if(array[i]==min) {
				continue;
			}else {
				result[j++]=array[i];
			}
		}
		
		return result;
	}
	
	
	public static int[] createArray(int numberOfElements) {
		int [] array=new int [numberOfElements];
		Random rand= new Random();
		
		for(int i=0;i<numberOfElements;i++) {
			array[i]=rand.nextInt(30)-15;
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
