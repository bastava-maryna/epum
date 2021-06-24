package by.htp.basic.loop;


public class SumOfSquares {
	//3. Найти сумму квадратов первых ста чисел.

	public static void main(String[] args) {
		System.out.println("The sum of squares of the first hundred numbers is " + calculate());
		System.out.println("The sum of squares of the first hundred numbers is " + calculate1());
	}
	
	
	public static int calculate() {
		int result=0;
		
		for(int i=1; i<=100;i++) {
			result+=i*i;
		}
		
		return result;
	}
	
	
	public static int calculate1() {   //using formula n(n+1)(2n+1)/6
		int result=100*(100+1)*(2*100+1)/6;
		
		return result;
	}
}
