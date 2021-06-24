package by.htp.algorithms.onedimarray;

import java.util.Random;
import java.util.Scanner;

//0 and 1 are not prime numbers
//primes 2,3,5,7,11,13,17,19,23
public class SumOfPrimeIndex {
	//6. Задана последовательность N вещественных чисел. 
	//Вычислить сумму чисел, порядковые номера которых являются простыми числами.

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
		
		System.out.println("The numbers to proceed:");
		printArray(array);
		
		System.out.println("The sum of numbers with prime indexes is equal: "+ sumOfPrimeIndex(array));
	}
	
	
	public static boolean isPrime(int number) {
		if(number<2) {
			return false;
		}else if(number==2){
			return true;
		}else if(number%2==0) {
			return false;
		}
		for(int i=3;i<=Math.sqrt(number);i+=2) {
			if (number%i==0) {
				return false;
			}
		}	
			
		return true;
	}
	
	
	public static double sumOfPrimeIndex(double[] array){
		int arrayLen=array.length;
		double sum=0;
		
		if(arrayLen<2) {
			return 0;
		}else {
			sum+= array[1];              //add array[1] without call isPrime()
		}
		for(int i=2;i<arrayLen;i++) {
			if (isPrime(i+1)) {
				sum+= array[i];
			}
		}
		
		return sum;
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
		int index=1;
		for(double elem:array) {
			System.out.println("["+ (index++)+ "] " + elem);
		}
	}
}
