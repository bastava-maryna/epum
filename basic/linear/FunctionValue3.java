package by.htp.basic.linear;

public class FunctionValue3 {
	//3. Вычислить значение выражения по формуле (все переменные принимают действительные значения):
	//   (𝑠𝑖𝑛𝑥+𝑐𝑜𝑠𝑦)/(𝑐𝑜𝑠𝑥−𝑠𝑖𝑛𝑦)∗𝑡𝑔 𝑥𝑦

	public static void main(String[] args) {
		System.out.println("Case1:The value  should be = 2.47..");  
		System.out.println("   calculate(45,1)= "+calculate(45,1));  
		System.out.println("Case2:The value  should be = infinity" ); 
		System.out.println("   calculate(45,2)= "+calculate(45,2)); 
		System.out.println("Case3: The value  should be = infinity");  
		System.out.println("   calculate(45,45)= "+calculate(45,45));
	}
	
	
	public static double calculate(double xDegree,double yDegree) {
		double xRad=Math.toRadians(xDegree);
		double yRad=Math.toRadians(yDegree);
		double xyRad=Math.toRadians(xDegree*yDegree);
		
		double tangens=Math.tan(xyRad);
		double numerator=Math.sin(xRad)+Math.cos(yRad);
		double denominator=Math.cos(xRad)-Math.sin(yRad);
		
		//не уверена что эти проверки когда-нибудь сработают
		//не понимаю как получить табличные значения, установить точность и округлять?
		if(Math.cos(xyRad)==0.0) {
			System.out.println("Tangens undefined");
		}
		if(Double.compare(Math.cos(xRad),Math.sin(yRad))==0) {
			System.out.println("Zero division");
		}
		
		return numerator/denominator*tangens;
	}

}
