package by.htp.basic.linear;

import java.util.Scanner;

public class ChangeDigits {
	//4. Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях). 
	//Поменять местами дробную и целую части числа и вывести полученное значение числа.

	public static void main(String[] args) {
		double number=0;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the numbers in the format xxx.xxx: ");
		
		while(sc.hasNext()) {
			if(sc.hasNextDouble()) {
				number=sc.nextDouble();
				
				if(checkNumber(number)) {
					System.out.println("You enter: "+number);
					System.out.println("A little magic..... TaDamm: "+changeDigits(number)+"\n");
				}else {
					System.out.println("You enter number in wrong format \n");					
				}
				System.out.println("Next one: ");
				
			}else {
				System.out.println("You enter not a number ");
				break;
			}
		}
		sc.close();	
		System.out.println("Finish!!! ");
	}
	
	
	public static double changeDigits(double number) {
		int temp1=(int)(number);
		double temp2=Math.round((number-temp1)*1000);
		
		double result=temp2+temp1/1000.0;
		
		return result;
	}
	
	public static boolean checkNumber(Double number) {
		String[] parts=number.toString().split("\\.");
		
		int intPart=parts[0].length();
		int decPart=parts[1].length();
		
		if(( intPart==3) && (decPart==3 )  ) {
			return true;
		}	
		
		return false;
	}
}
