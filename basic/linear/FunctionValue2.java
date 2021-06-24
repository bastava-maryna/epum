package by.htp.basic.linear;

public class FunctionValue2 {
	/*
	 2. Вычислить значение выражения по формуле (все переменные принимают действительные значения): 
	 (𝑏+√𝑏2+4𝑎𝑐)/2𝑎−(𝑎^3)𝑐+𝑏^(−2)
	 */

	public static void main(String[] args) {
		System.out.println("Case1:The value  should be = -1078.3..");  
		System.out.println("   calculate(6,7,5)= "+calculate(6,7,5));  
		System.out.println("Case2:The value  should be = infinity" ); 
		System.out.println("   calculate(0,8,1)= "+calculate(0,8,1)); 
		System.out.println("Case3: The value  should be = infinity");  
		System.out.println("   calculate(5,0,1)= "+calculate(5,0,1));
	}
	
	
	public static double calculate(double a,double b,double c) {
		double underRoot=0;
		double bSquared=0;
		double result=0;
		
		bSquared= b*b;
		underRoot=bSquared+4*a*c;
		result=(b+Math.sqrt(underRoot))/(2*a)-Math.pow(a,3)*c+1/bSquared;
		
		if(a==0 || b==0) {
			System.out.println("Parameter a or b equal zero - zero division");
		}
		if(underRoot<0) {
			System.out.println("Square root from negative value");
		}
		
		return result;
	}
}
