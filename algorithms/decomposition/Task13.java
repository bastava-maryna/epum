package by.htp.algorithms.decomposition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task13 {
	//13. Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43). 
	//Найти и напечатать все пары «близнецов» из отрезка [n,2n], 
	//где n - заданное натуральное число больше 2. 
	//Для решения задачи использовать декомпозицию.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int number=enterValue(sc,"Enter natural number bigger than 2 to define interval [n,2n]:");
		
		System.out.println("You enter:\nnumber=" + number);
		System.out.println("Interval=[" + number+ ", "+2*number+"]");
		
		calculate(number);
		
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
			
			if(value<=2) {
				System.out.println("You enter not a proper number. Try again: ");
			}
			
		}
		while(value<=2);
		
		return value;
	}
	
	
	public static void calculate(int number) {
		int[]prime_array=findPrimesInInterval(number);
		
		System.out.println("Prime numbers in the given interval:");
		printArray(prime_array);
		
		System.out.println("The twins numbers are: ");
		for(int i=1;i<prime_array.length;i++) {
			if((prime_array[i]-prime_array[i-1])==2) {
				System.out.println("("+prime_array[i-1]+","+prime_array[i]+")");
			}
		}
	}
	
	
	public static boolean isPrime(int number) {
		for(int i=2;i<=Math.sqrt(number);i++) {
			if(number%i==0) {
				return false;
			}
		}
		return true;
	}
	
	
	public static int[] findPrimesInInterval(int number){
		ArrayList<Integer> prime_list=new ArrayList<Integer>();
		
		for(int i=number;i<=2*number;i++) {
			if(isPrime(i)) {
				prime_list.add(i);
			}
		}
		
		return fromArrayListToArray(prime_list);
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
