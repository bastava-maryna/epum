package by.htp.algorithms.decomposition;

import java.util.Scanner;

public class Task3 {
	//3. Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади треугольника.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		double side_size=enterValue(sc, "Enter the hexagon side size:");
		System.out.println("You enter the hexagon side size: " + side_size);
		
		System.out.println("The hexagon square is: ");
		System.out.printf("%.2f", calculateHexagonSquare(side_size));	
		
		sc.close();

	}
	
	
	public static double enterValue(Scanner sc, String message) {
		double value=0;
		System.out.println(message);
		
		do {
			while(!sc.hasNextDouble()) {
				System.out.println("Your input is not an double number. Try again:");
				sc.next();
			}
			
			value=sc.nextDouble();
			
			if(value<=0) {
				System.out.println("You enter not a positive number. Try again: ");
			}
		}
		while(value<=0);
		
		return value;
	}
	
	
	//right hexagon consist of 6 equilateral triangles
	public static double calculateHexagonSquare(double side_size) {
		return 6*calculateEquilateralTriangleSquare(side_size);
	}
	
	
	public static double calculateEquilateralTriangleSquare(double side_size) {
		return Math.sqrt(3)*side_size*side_size/4;
	}

}
