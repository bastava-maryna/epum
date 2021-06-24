package by.htp.basic.branching;

import java.util.Scanner;

public class TriangleResearch {
	//1. Даны два угла треугольника (в градусах). 
	//Определить, существует ли такой треугольник, и если да, то будет ли он прямоугольным.

	public static void main(String[] args) {
		int angle1;
		int angle2;
		Scanner sc=new Scanner(System.in);
		
		angle1=enterValue(sc,"Enter the first angle: ");
		angle2=enterValue(sc,"Enter the second angle: ");
		
		boolean exist=isTriangleExist(angle1,angle2);
		
		System.out.println("Such triangle "+(exist==true ? "exist" : "doesn`t exist"));
		if(exist==true) {
			System.out.println("And this triangle "+(isTriangleRight(angle1,angle2,(180-angle1-angle2))==true ? "is right-angled" : "is not right-angled"));
		}
		else {
			System.out.println("So there is no sence to check if it`s right-anled or not))) ");
		}
		
		sc.close();
	}
	
	public static boolean isTriangleExist(int angle1, int angle2) {
		if(angle1<=0 ||angle2<=0) {
			System.out.println("The angle values should be positive");
			return false;
		}
		return (180-angle1-angle2)>0;
	}
	
	public static boolean isTriangleRight(int angle1, int angle2, int angle3) {
		if(angle1<=0 ||angle2<=0 || angle3<=0) {
			System.out.println("The angle values should be positive");
			return false;
		}
		return (angle1==90 ||angle2==90 ||angle3==90 );
	}
	
	public static int enterValue(Scanner sc,String message) {
		int value;
		
		System.out.println(message);
		
		while(!sc.hasNextInt()) {	
			System.out.println("Your input not an integer. Try again: ");
			sc.next();
		}
		
		value=sc.nextInt();		
		
		return value;
	}
}
