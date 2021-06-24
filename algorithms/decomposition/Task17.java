package by.htp.algorithms.decomposition;

import java.util.Scanner;

public class Task17 {
	//17. Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. 
	//Сколько таких действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int number=enterValue(sc,"Enter number :");  
		
		System.out.println("You enter:\nnumber = " + number );
		System.out.println("The number of repeats:\n"+ calculate(number));
		
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
			
			if(value<0 ) {
				System.out.println("You enter not a natural number. Try again: ");
			}
		}
		while(value<0);
		
		return value;
	}
	
	
	public static int calculate(int number) {
		int count=0;
		
		if(number==0) {
			return count;
		}
	
		do {
			number=makeStep(number);	
			count++;
			
		}	while(number>0);
		
		return count;
	}
	
	
	public static int makeStep(int number) {
		int sum_of_digits=sumOfDigits(number);
		number-=sum_of_digits;
		
		return number;
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
	
}
