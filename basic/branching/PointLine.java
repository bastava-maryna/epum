package by.htp.basic.branching;

import java.util.Scanner;

public class PointLine {
	//3. Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). 
	//Определить, будут ли они расположены на одной прямой.
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter coordinates (x,y) of 3 points");
		
		int x1=enterValue(sc,"Enter x1: ");
		int y1=enterValue(sc,"Enter y1: ");
		
		int x2=enterValue(sc,"Enter x2: ");
		int y2=enterValue(sc,"Enter y2: ");
		
		int x3=enterValue(sc,"Enter x3: ");
		int y3=enterValue(sc,"Enter y3: ");
		
		System.out.println("You entered: \n" + "point1 = (" + x1 + "," + y1 +")\npoint2 = (" + x2 + "," + y2 +")\npoint3 = (" + x3 + "," + y3 + ")");
		System.out.println("These points are "+ (isPointsOnOneLine(x1,y1,x2,y2,x3,y3)==true ? "on one line" : "not on one line"));
		
		sc.close();
	}
	
	public static boolean isPointsOnOneLine(int x1,int y1,int x2, int y2, int x3, int y3) {
		int temp= (x2-x1)*(y3-y1) - (x3-x1)*(y2-y1);
		
		return (temp==0) ? true : false;
	}
	
	public static int enterValue(Scanner sc,String message) {
		int value;
		System.out.println(message);
		
		while(!sc.hasNextInt()) {
			System.out.println("Your input not an integer");
			sc.next();
		}
		
		value=sc.nextInt();
		
		return value;
	}
}
