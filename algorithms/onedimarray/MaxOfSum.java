package by.htp.algorithms.onedimarray;

import java.util.Random;
import java.util.Scanner;

public class MaxOfSum {
	//7. Даны действительные числа n a1,a2,... ,an. 
	//Найти  max(a1+a2n ,a2+a2n-1 ,... ,an+an+1 ) 

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int numberOfElements=0;
		
		do {
			numberOfElements=enterValue(sc, "Enter the number of elements: ");
			
			if(numberOfElements<=0 || (numberOfElements%2)!=0) {
				System.out.println("You should eneter positive even number. Try again: ");
			}
		}while(numberOfElements<=0 || (numberOfElements%2)!=0);
		
		double []array=createArray(numberOfElements);
		
		System.out.println("The numbers to proceed:");
		printArray(array);
		
		System.out.println("The answer is : "+ maxOfSum(array));
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
	
	public static double maxOfSum(double[] array){
		int arrayLen=array.length;
		double max=array[0]+array[arrayLen-1];
		double curSum=0;
		//System.out.println("a(1) + a("+ arrayLen +") = "+max);
		
		for(int i=1;i<arrayLen/2;i++) {
			curSum=array[i]+array[arrayLen-1-i];
			//System.out.println("a("+ (i+1)+") + a("+ (arrayLen-i) +") = "+curSum);
			if(curSum>max) {
				max=curSum;
			}
		}
		
		return max;
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
