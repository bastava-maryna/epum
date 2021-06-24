package by.htp.algorithms.decomposition;

public class Task7 {
	//7. Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.

	public static void main(String[] args) {
		int number1=1;
		int number2=9;
		
		System.out.println("The sum of factorials of add numbers from " + number1 + " to "+ number2 + " is");
		System.out.println(sumOfOddPrimeFactorial(number1,number2));
	}
	
	
	public static boolean isOdd(int number) {
		if(number%2==0) {
			return false;
		}
		return true;
	}
	
	
	public static int factorial(int number) {
		int result=1;
		
		if(number==1) {
			return number;
		}
		
		for(int i=2;i<=number;i++) {
			result=result*i;
		}
		
		return result;
	}
	
	
	public static int sumOfOddPrimeFactorial(int number1,int number2) {
		int result=0;
		
		for(int i=number1; i<=number2;i++) {
			if(isOdd(i)) {
				//System.out.println("i="+i+ "factorial="+factorial(i));
				result+=factorial(i);
			}
		}
		
		return result;
	}
}
