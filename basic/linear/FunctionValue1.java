package by.htp.basic.linear;

public class FunctionValue1 {
	//1. Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.

	public static void main(String[] args) {
		System.out.println("(6-3)*7/2)+5  should be = 15.5, calculate(6,7,5)= "+calculate(6,7,5));  
		System.out.println("(5-3)*8/2)+1  should be = 9.0, calculate(8,8,1)= "+calculate(5,8,1));  
	}
	
	
	public static double calculate(double a,double b,double c) {
		return ((a-3)*b/2)+c;
	}

}
