package by.htp.basic.linear;

import java.util.Scanner;

public class PointChecker {
	//6. Для данной области составить линейную программу, 
	//которая печатает true, если точка с координатами (х, у) принадлежит закрашенной области, 
	//и false — в противном случае:

	public static void main(String[] args) {
		System.out.println("Enter the coordinates (x,y) of the point");
		
		System.out.println("Enter coordX: ");
		int coordX=enterValue();
		
		System.out.println("Enter coordY: ");
		int coordY=enterValue();
		
		System.out.println("You choose the point ("+coordX+", "+coordY+")");
		
		System.out.println("This point"+ (isInDomain(coordX,coordY)==true ?" belongs" : " is not belong " )+ " to the indicated region");
		
	}
	
	
	public static boolean isInDomain(int coordX, int coordY) {
		if((coordX>=-4)&&(coordX<=4) && (coordY>=-3)&&(coordY<=0)
			|| (coordX>=-2)&&(coordX<=2) && (coordY>=0)&&(coordY<=4)) {
			return true;
		}
		
		return false;
	}
	
	public static int enterValue() {
		int value;
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		
		while(!sc.hasNextInt()) {	
			System.out.println("Your input not an integer. Try again: ");
			sc.next();
		}
		value=sc.nextInt();
		//sc.close();
		
		return value;
	}
	

}
