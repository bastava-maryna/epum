package by.htp.basic.linear;

import java.util.Scanner;

public class TimeConverter {
	//5. Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах. 
	//Вывести данное значение длительности в часах, минутах и секундах в следующей форме:
	//                       ННч ММмин SSc.

	public static void main(String[] args) {
		int t;
		
		System.out.println("Enter the time in seconds: ");
		t=enterInt();
		System.out.println(timeConverter(t));
		System.out.println("Good job, you deserve a rest!!! ");
	}
	
	
	public static String timeConverter(int tInSec) {
		if(tInSec<=0) {
			return "T should be natural number";
		}
		
		int ss=0;
		int mm=0;
		int hh=0;
		
		mm=tInSec/60;
		ss=tInSec-mm*60;
		if(mm>=60) {
			hh= mm/60;
			mm=mm-hh*60;
		}	
		return (tInSec+" с = "+hh+"ч "+mm+"мин "+ss+"c");
	}
	
	public static int enterInt() {
		int value=0;
		
		Scanner sc=new Scanner(System.in);
		
		do {	
			while(!sc.hasNextInt()) {	
				System.out.println("Your input is not an integer. Try again: ");
				sc.next();
			}
			
			value=sc.nextInt();
			if(value<=0) {
				System.out.println("You eneter wrong value. Try again: ");
			}
		}
		while(value<=0);
		
		sc.close();
		return value;
	}
}
