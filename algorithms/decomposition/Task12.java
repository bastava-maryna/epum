package by.htp.algorithms.decomposition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task12 {
	//12. Даны натуральные числа К и N. 
	//Написать метод(методы) формирования массива А, элементами которого являются числа, 
	//сумма цифр которых равна К и которые не большее N.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int numberK=enterValue(sc,"Enter number K:");
		int numberN=enterValue(sc,"Enter number N:");
		
		//int numberK=11;
		//int numberN=599;
		
		System.out.println("You enter:\nnumber K=" + numberK + "\nnumber N=" + numberN );

		printArray(create(numberK, numberN ));
		printArray(create1(numberK, numberN ));
		
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
	
	
	public static boolean isFeasible(int sum, int limit) {
		int limit_size=findNumberDigitsInNumber(limit);
		int first=findFirstDigit(limit);
		int max_limit=maxLimit(first,limit_size);
	
		int max_sum=sumOfDigits(max_limit);
		System.out.println("Max sum of digits for that combination of number K and number N= "+max_sum);
		
		if(max_sum<sum) {
			System.out.println("There is no decision for that combination of number K and number N");	
			return false;
		}
		return true;
	}
	
	
	public static int[] create(int sum, int limit ){
		if(isFeasible(sum,limit)==false) {
			System.exit(0);
		}
		
		ArrayList<Integer>result=new ArrayList<Integer>();
		
		if(limit<10 ) {
			result.add(sum);
		}
		
		for(int i=1;i<limit;i++) {
				if(sumOfDigits(i)==sum) {
				result.add(i);
			}
		}
		//System.out.println("create list size="+result.size());
	
		return fromArrayListToArray(result);
	}
	
	
	public static int[] create1(int sum, int limit) {
		if(isFeasible(sum,limit)==false) {
			System.exit(0);
		}
		
		ArrayList<Integer>all_candidates=createAll(sum,limit);	
		
		int size=all_candidates.size();
		int end_index=0;
		
		for(int i=(size-1);i>=0;i--) {
			if(all_candidates.get(i)<limit) {		
				end_index=i;
				break;
			}
		}
		
		int[]result=new int[end_index+1];
		int i=0;
		
		for(Integer elem: all_candidates.subList(0, end_index+1)) {
			result[i++]=elem;
		}
		
		return result;
	}
	
	
	public static ArrayList<Integer> createAll(int sum, int limit ){
		int limit_size=findNumberDigitsInNumber(limit);
		ArrayList<Integer> from_one=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		ArrayList<Integer>result=new ArrayList<Integer>();
		
		helper(sum,limit_size,0,from_one,result);
		
		return result;	
			
		}
		
	
	public static void helper(int sum, int limit_size, int p, ArrayList<Integer>range,ArrayList<Integer>result){
		ArrayList<Integer> from_zero=new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
		//ArrayList<Integer> from_one=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
	
		if(limit_size==0) {
			if(sum==0) {
				result.add(p);
			}
		}
		else if(limit_size==1){
			if(from_zero.contains(sum)) {
				result.add(10*p+sum);
			}
		}
		else if(sum>=0 && sum<=9*limit_size) {				
			for (Integer elem:from_zero) {
				helper(sum-elem,limit_size-1,10*p+elem,from_zero,result);
			}		
		}
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
