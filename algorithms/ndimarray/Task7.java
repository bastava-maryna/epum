package by.htp.algorithms.ndimarray;

import java.util.Scanner;

public class Task7 {
	//7. Сформировать квадратную матрицу порядка N по правилу:see task list
	//и подсчитать количество положительных элементов в ней.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int matrixSize=enterValue(sc, "Enter the size of a  matrix - positive even number: ");
		double[][] testMatrix=createSpecialSquareMatrix(matrixSize);
		
		System.out.println("Result matrix:");
		printMatrix(testMatrix);
		
		System.out.println("Number of positive matrix elements: "+countPositiveElements(testMatrix));
		
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
	
	
	public static double[][] createSpecialSquareMatrix(int size) {
		double[][] matrix=new double[size][size];
		
		for (int j=0;j<size;j++) {
			for (int i=0;i<size-j;i++) {
				matrix[i][j]=Math.sin((i*i-j*j)/(double)size);	
			}
		}
			
		return matrix;
	}

	
	//positive here - number bigger than 0
	public static int countPositiveElements(double[][]matrix){
		int count=0;
		for (int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]>0) {
					count++;
				}
			}
		}
		return count;
	}
	
	
	public static void printMatrix(double [][] matrix) {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				System.out.printf("%7.2f",matrix[i][j]);
			}
			System.out.println();	
		}
	}

}
