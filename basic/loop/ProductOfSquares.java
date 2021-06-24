package by.htp.basic.loop;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ProductOfSquares {
	//4. Составить программу нахождения произведения квадратов первых двухсот чисел.

	public static void main(String[] args) {
		System.out.println("The product of squares of the first 200 numbers using calculate1() is " + calculate1());
		System.out.println("The product of squares of the first 200 numbers using calculate2() is " + calculate2());
		System.out.println("Mamma mia!!!  How many numbers!!!\n");
		
		NumberFormat convert=new DecimalFormat("0.###E0");					//# zero shows as absent
		System.out.println("The product of squares of the first 200 numbers using calculate2() is " + convert.format(calculate2()));
		System.out.println("Much better now))");
		
	}
	
	public static BigInteger calculate1() {
		BigInteger result=BigInteger.valueOf(1);
		
		for (int i=2;i<=200;i++ ) {
			result=result.multiply(BigInteger.valueOf(i*i));
		}
		
		return result;
	}
	
	
	public static BigInteger calculate2() {
		BigInteger result=BigInteger.valueOf(1);
		
		for (int i=2;i<=200;i++ ) {
			result=result.multiply(BigInteger.valueOf(i));
		}
		
		return result.multiply(result);
	}
	

}
