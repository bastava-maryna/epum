package by.htp.algorithms.decomposition;

import java.util.Scanner;

public class Task9 {
	//9. Даны числа X, Y, Z, Т — длины сторон четырехугольника. 
	//Написать метод(методы) вычисления его площади, если угол между сторонами длиной X и Y— прямой

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		double sideX=enterValue(sc,"Enter side X:");
		double sideY=enterValue(sc,"Enter side Y:");
		double sideT;
		double sideZ;
		double check;
		do {
			sideT=enterValue(sc,"Enter side T:");
			sideZ=enterValue(sc,"Enter side Z:");
			check=findHypothenuse(sideX,sideY);
			
			if(check>=(sideT+sideZ)) {
				System.out.println("Such tetragon doesn`t exist.\nThe sum of side T and side Z should be bigger than " + check+".\nEnter another value for these sides:");
			}
			
		}while (check>=(sideT+sideZ));
		
		System.out.println("You enter:\nside X=" + sideX + "\nside Y=" + sideY + "\nside T=" + sideT + "\nside Z=" + sideZ + "\n");
		System.out.println("The tetragon square with right angle between side X and side Y is"); 
		System.out.println( findTetragonSquare(sideX,sideY,sideT,sideZ ));
		
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

	
	//the angle between side1 and side2 is right
	//square tetragon consists of one right triangle and one reqular triangle
	public static double findTetragonSquare(double side1, double side2, double side3, double side4) {
		double right_triangle_square=findRightTriangleSquare(side1,side2);
		double right_triangle_hypothenuse=findHypothenuse(side1,side2);
		double regular_triangle_square=findTriangleSquareBySides(side3,side4,right_triangle_hypothenuse);
		//System.out.println(right_triangle_square +" , "+right_triangle_hypothenuse+" , " +regular_triangle_square);
	
		return right_triangle_square+regular_triangle_square;
	}
	
	
	//the angle between side1 and side2 is right
	public static double findRightTriangleSquare(double side1, double side2) {
		return side1*side2/2.0;
	}
	
	
	public static double findTriangleSquareBySides(double side1, double side2,double side3) {
		double half_per=findTriangleHalfPerimeter(side1,side2,side3);
		
		return Math.sqrt(half_per*(half_per-side1)*(half_per-side2)*(half_per-side3));
	}
	
	
	public static double findTriangleHalfPerimeter(double side1,double side2, double side3) {
		return (side1+side2+side3)/2.0;
		
	}
	
	
	public static double findHypothenuse(double side1,double side2) {
		return Math.sqrt(side1*side1 + side2*side2);
	}
	
}
