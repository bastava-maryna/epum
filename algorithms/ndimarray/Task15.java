package by.htp.algorithms.ndimarray;

import java.util.Random;
import java.util.Scanner;

public class Task15 {
	//15. Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int rowNumber=enterValue(sc, "Enter the number of rows in matrix: ");
		int colNumber=enterValue(sc, "Enter the number of columns in matrix: ");
		
		int [][] testMatrix=createMatrix(rowNumber,colNumber);
		
		System.out.println("Given matrix:");
		printMatrix(testMatrix);
			
		int maxElement=maxElement(testMatrix);
		System.out.println("Maximal element of the given matrix is: "+ maxElement);
		
		System.out.println("Result matrix: ");
		printMatrix(replace(testMatrix,maxElement));
		
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
			
			if(value<=0) {
				System.out.println("You enter negative number or 0. Try again:");
			}
		}
		while (value<=0);
		
		return value;	
	}
	
	
	public static int[][] createMatrix(int rowNumber, int colNumber) {
		Random rand=new Random ();
		int[][] matrix=new int[rowNumber][colNumber];
		
		for (int i=0;i<rowNumber;i++) {
			for (int j=0;j<colNumber;j++) {
				matrix[i][j]=rand.nextInt(50)-25;	
			}
		}
		
		return matrix;
	}
	
	
	public static int maxElement(int[][]matrix) {
		int max=matrix[0][0];
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]>max) {
					max=matrix[i][j];
				}
			}
		}
		
		return max;
	}
	
	
	//zero-based row and column numbers, original matrix is unchanged
	public static int[][] replace(int [][] matrix, int max) {
		int rows=matrix.length;
		int cols=matrix[0].length;
		int [][] result=new int[rows][cols];
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(matrix[i][j]%2==0 ) {
					result[i][j]=matrix[i][j];
				}
				else {
					result[i][j]=max;
				}
			}
		}
		
		return result;
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
