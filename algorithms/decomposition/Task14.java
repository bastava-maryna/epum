package by.htp.algorithms.decomposition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


//Armstrong number ia a number that is equal to the sum ob cubes of its digits.
//There are only 88 such numbers in decimal numerical system 
//1,2,3,4,5,6,7,8,9,153,370,371,407,1634,8208,9474,54748 ...

public class Task14 {
	//14. Натуральное число, в записи которого n цифр, называется числом Армстронга, 
	//если сумма его цифр, возведенная в степень n, равна самому числу. 
	//Найти все числа Армстронга от 1 до k. 
	//Для решения задачи использовать декомпозицию.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int numberK=enterValue(sc,"Enter number K:");  //define limit 
		//int numberK=10010;
		
		System.out.println("You enter:\nnumber K=" + numberK  );
		System.out.println("The Armstrong numbers:\n" + calculate(numberK));
		
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
			
			if(value<=1) {
				System.out.println("You enter number less than 1. Try again: ");
			}
		}
		while(value<=1);
		
		return value;
	}
	
	
	public static int findNumberDigitsInNumber(int number) {
		if(number==0) {
			return 1;
		}
		
		return  (int)Math.ceil(Math.log10(number+0.5));        // log(1)=0, log(10)=1,..., so need +0.5 to obtain correct answer
	}
	
	
	public static int maxLimit(int first,int limit_size) { 
		int max=(int)(first*Math.pow(10,limit_size-1))-1;
		
		return max;
	}
	
	
	public static int findFirstDigit(int number) {
		while(number<-9 || number>9) {
			number/=10;
		}
		return Math.abs(number);
	}
	
	
	public static int sumOfDigits(int number) {
		if(number==0) {
			return 0;
		}
		
		int sum=0;
		number=Math.abs(number);
		while(number>0) {
			sum+=number%10;
			number/=10;
		}
		
		return sum;
	}
	
		
	public static int valueToControl(int number, int number_size) {
		int []number_digits=createArrayFromDigits(number,number_size);
		int value=0;
		
		for(int i=0;i<number_size;i++) {
			int temp=(int)(Math.pow(number_digits[i],number_size));
			value+=temp;
		}	
		
		return value;
	}
	
	
	public static boolean isSatisfy(int number) {
		int number_size=findNumberDigitsInNumber(number);
		int value=valueToControl(number,number_size);
		
		return (value==number)?true:false;
	}	
	
	
	public static ArrayList<Integer> calculate(int limit) {
		ArrayList<Integer>result=new ArrayList<Integer>();
		for (int i=1;i<=limit;i++) {
			if(isSatisfy(i)) {
				result.add(i);
			}
		}
		
		return result;
	}

	
	public static int[] createArrayFromDigits(int number,int number_size) {
		int[] result=new int[number_size];
		
		for (int i=0;i<number_size;i++) {
			result[number_size-1-i]=findDigitAtPosition(number,i+1);
		}
		
		return result;
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
		
		
	public static int[] fromArrayListToArray(ArrayList<Integer>arlist) {
		int[] result=new int[arlist.size()];
		int i=0;
		
		for(Integer elem:arlist) {
			result[i++]=elem;
		}
		Arrays.sort(result);
		
		return result;
	}
	
	public static void printArray(int[]array) {
		for(int elem:array) {
			System.out.printf("%5d",elem);
		}
		System.out.println();
	}	

}
