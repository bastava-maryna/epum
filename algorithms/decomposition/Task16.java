package by.htp.algorithms.decomposition;

import java.util.ArrayList;
import java.util.Scanner;

public class Task16 {
	//16. Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры. 
	//Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int number_digits=enterValue(sc,"Enter number digits in numbers from 2 to 8:");  
		//int number_digits=6;
		System.out.println("You enter:\nnumber of digits in numbers = " + number_digits );
		
		long sum=calculate(number_digits);
		
		System.out.println("The sum of numbers with only odd digits is:\n"+ sum);
		System.out.println("The number of even digits in sum is:\n"+ calculateEvenDigits(sum));
		
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
			
			if(value<2 || value>8) {
				System.out.println("You enter number less than 2 or bigger than 8. Try again: ");
			}
		}
		while(value<2 || value>8);
		
		return value;
	}
	
	
	public static long calculate(int number_size) {
		long sum=0;
		
		if(number_size==0) {
			return sum;
		}
		
		ArrayList<Integer> selected_numbers=findNumbers(number_size);
		System.out.println(selected_numbers.toString());
		System.out.println("selected "+selected_numbers.size()+" numbers");
		sum=sumArrayList(selected_numbers);
		
		return sum;
	}
	
	
	public static int calculateEvenDigits(long number) {
		int number_size=findNumberSize(number);
		int[] digits=createNumberDigitsArray(number,number_size);
		int count_even=0;
		
		for(int elem : digits) {
			if(!isOdd(elem)) {
				count_even++;
			}
		}
		
		return count_even;
	}
	
	
	public static ArrayList<Integer> findNumbers(int number_size){
		ArrayList<Integer>result=new ArrayList<Integer>();
		
		if(number_size==1) {
			for(int i=1;i<=9;i+=2) {
				result.add(i);
			}
			
			return result;
		}
		
		int min_number=minNumber(number_size);
		int max_number=maxNumber(number_size);
		
		result.add(max_number);
		
		for (int i=min_number+1;i<max_number;i+=2) {  
			if(isAllDigitsOdd(i,number_size)) {
				result.add(i);
			}
		}
		
		return result;
	}
	
	
	public static boolean isAllDigitsOdd(int number, int number_size) {
		int [] digits=createNumberDigitsArray(number,number_size); //is it correct?? or should create and rewrite
		
		for(int elem : digits) {
			if(!isOdd(elem)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public static int[] createNumberDigitsArray(long number, int number_size) {
		int[] result=new int[number_size];
		int i=0;
		
		while(number>0) {
			result[i++]=(int)number%10;
			number=number/10;
		}
		
		return result;
	}
	
	
	public static int maxNumber(int number_size) {
		return (int)Math.pow(10, number_size)-1;
	}
	
	
	public static int minNumber(int number_size) {
		return  (int)Math.pow(10, number_size-1);
	}
	
	
	public static boolean isOdd(int number) { 
		if(number%2==0) {
			return false;
		}
		
		return true;
	}
	
	
	public static int sumOfDigits(int number) {
		if(number==0) {
			return 0;
		}
		
		int number_size=findNumberSize(number);
		
		int []digits=createNumberDigitsArray(number,number_size);
		int sum=0;
		for(int elem:digits) {
			sum+=elem;
		}
		
		return sum;
	}
	
	
	public static int findNumberSize(long number) {
		if(number==0) {
			return 1;
		}
		return (int)Math.ceil(Math.log10(number+0.5));
	}
	
	
	public static long sumArrayList(ArrayList<Integer>list ){
		long sum=0;
		
		if(list.size()==0 ) {
			return sum;
		}
		
		for(Integer elem:list) {
			sum+=elem;
		}
	
		return sum;
	}
		
	
	public static void printArray(int[]array) {
		for(int elem:array) {
			System.out.printf("%5d",elem);
		}
		System.out.println();
	}
	
}
