package by.htp.algorithms.ndimarray;

import java.util.Scanner;

public class Task6 {
	//6. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):see task list

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int matrixSize=enterValue(sc, "Enter the size of a  matrix - positive even number: ");
		
		System.out.println("Result matrix:");
		printMatrix(createSpecialSquareMatrix(matrixSize));
		
		sc.close();
	}

	
	public static int enterValue(Scanner sc, String message) {
		int value=0;
		System.out.println(message);
		
		do {
			while(!sc.hasNextInt()) {
				System.out.println("Your input is not a integer number. Try again:");
				sc.next();
			}
			value=sc.nextInt();
			
			if(value<=0 || value%2!=0) {
				System.out.println("You enter negative number or 0 or odd number. Try again:");
			}
		}
		while (value<=0 || value%2!=0);
		
		return value;	
	}
	
	
	public static int[][] createSpecialSquareMatrix(int size) {
		int[][] matrix=new int[size][size];
	
		for (int i=0;i<size/2;i++) {
			for (int j=0+i;j<size-i;j++) {
				matrix[i][j]=1;
				matrix[size-1-i][j]=1;
			}
		}
			
		return matrix;
	}

	
	public static void printMatrix(int [][] matrix) {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				System.out.printf("%7d",matrix[i][j]);
			}
			System.out.println();	
		}
	}

}
