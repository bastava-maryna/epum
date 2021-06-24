package by.htp.algorithms.decomposition;

import java.util.Scanner;

public class Task10 {
	//10. Дано натуральное число N. 
	//Написать метод(методы) для формирования массива, элементами которого являются цифры числа N.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int number=enterValue(sc,"Enter the natural number :");
		
		System.out.println("You enter number " + number);
		System.out.println("The array from the number`s digits is:"); 
		printArray(createArrayFromDigits(number));
		
		sc.close();
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
				System.out.println("You enter not a natural number. Try again: ");
			}
		}
		while(value<=0);
		
		return value;
	}

	
	//return -1 if position > than number of digits in number 
	public static int findDigitAtPosition(int number, int position) {
		int result=0;
		int temp=(int)(number/Math.pow(10, position-1));
		
		if(temp>0) {
			
			result=temp%10;
		}
		else{
			return -1;
		}
		
		return result;     
	}
	
	
	public static int findNumberDigitsInNumber(int number) {
		if(number==0) {
			return 1;
		}
		
		return  (int)Math.ceil(Math.log10(number+0.5));        // log(1)=0, log(10)=1,..., so need +0.5 to obtain correct answer
	}
	
	
	public static int[] createArrayFromDigits(int number) {
		int number_size=findNumberDigitsInNumber(number);
		int[] result=new int[number_size];
		
		for (int i=0;i<number_size;i++) {
			result[number_size-1-i]=findDigitAtPosition(number,i+1);
			
		}
		
		return result;
	}
	
	
	public static void printArray(int[]array) {
		for(int elem:array) {
			System.out.printf("%5d",elem);
		}
		System.out.println();
	}

}
