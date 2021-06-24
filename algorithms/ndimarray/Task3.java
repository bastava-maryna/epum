package by.htp.algorithms.ndimarray;

import java.util.Random;
import java.util.Scanner;

public class Task3 {
	//3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int rowNumber=enterValue(sc, "Enter the number of rows in matrix: ");
		int colNumber=enterValue(sc, "Enter the number of columns in matrix: ");
		
		int [][] testMatrix=createMatrix(rowNumber,colNumber);
		
		int chosenRow=enterLimitedValue(sc,"Choose which row to print - nonnegative number less than "+ rowNumber+" :",rowNumber);
		int chosenCol=enterLimitedValue(sc,"Choose which col to print - nonnegative number less than "+ colNumber+" :",colNumber);
		
		
		System.out.println("Original matrix:");
		printMatrix(testMatrix);
		
		System.out.println("The row "+chosenRow+ " from given matrix:");
		printMatrixRow(testMatrix,chosenRow);
		
		System.out.println("The column "+chosenCol+ " from given matrix:");
		printMatrixCol(testMatrix,chosenCol);
		
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
	
	
	public static int enterLimitedValue(Scanner sc, String message, int limit) {
		int value=0;
		System.out.println(message);
		
		do {
			while(!sc.hasNextInt()) {
				System.out.println("Your input is not a integer number. Try again:");
				sc.next();
			}
			value=sc.nextInt();
			
			if(value>=limit || value<0) {
				System.out.println("Your number is out of bound. Try again:");
			}
		}
		while (value>=limit || value<0);
		
		return value;	
	}
	
	
	public static int[][] createMatrix(int rowNumber, int colNumber) {
		Random rand=new Random ();
		int[][] matrix=new int[rowNumber][colNumber];
		
		for (int i=0;i<rowNumber;i++) {
			for (int j=0;j<colNumber;j++) {
				matrix[i][j]=rand.nextInt(50)-50;	
			}
		}
		
		return matrix;
	}
	
	
	//zero-based row and column numbers
	public static void printMatrixRow(int [][] matrix,int row) {
		for(int j=0;j<matrix[0].length;j++) {
			System.out.printf("%7d",matrix[row][j]);	
		}
		System.out.println();
	}
	
	
	public static void printMatrixCol(int [][] matrix,int col) {
		for(int i=0;i<matrix.length;i++) {
			System.out.printf("%7d",matrix[i][col]);
			System.out.println();	
		}
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
