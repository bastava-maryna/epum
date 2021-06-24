package by.htp.basic.branching;

import java.util.Scanner;

public class BrickControl {
	//4. Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. 
	//Определить, пройдет ли кирпич через отверстие.

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		
		System.out.println("Enter the brick`s sides sizes: ");
		int brickSide1=enterValue(sc, "Enter size of first side: ");
		int brickSide2=enterValue(sc, "Enter size of second side: ");
		int brickSide3=enterValue(sc, "Enter size of third side: ");
		
		System.out.println("Enter the hole`s sides sizes: ");
		int holeSide1=enterValue(sc, "Enter size of first side: ");
		int holeSide2=enterValue(sc, "Enter size of second side: ");
		
		if (isBrickFit(brickSide1, brickSide2, brickSide3, holeSide1, holeSide2)==true) {
			System.out.println("The brick goes through the hole ");
		}else {
			System.out.println("The brick doesn`t go through the hole ");
		}
		sc.close();
	}

	
	public static boolean isBrickFit(int brickSide1, int brickSide2, int brickSide3, int holeSide1, int holeSide2) {
		if   ((holeSide1>brickSide1 && holeSide2>brickSide2 ) || (holeSide2>brickSide1 && holeSide1>brickSide2 )
		   || (holeSide1>brickSide2 && holeSide2>brickSide3 ) || (holeSide2>brickSide2 && holeSide2>brickSide3 )
		   || (holeSide1>brickSide3 && holeSide2>brickSide1 ) || (holeSide2>brickSide3 && holeSide1>brickSide1 )){
			return true;
		}	
		return false;
	}
	
	
	public static int enterValue(Scanner sc, String message){
		int value;
		
		System.out.println(message);
		
		do {
			while(!sc.hasNextInt()) {
				System.out.println("Your input is not an integer. Try again: ");
				sc.next();
			}
			value=sc.nextInt();
			
			if(value<=0) {
				System.out.println("You eneter wrong value. Try again: ");
			}
		} while(value<=0);
		
		return value;
	}
}
