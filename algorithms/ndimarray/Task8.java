package by.htp.algorithms.ndimarray;

import java.util.Random;
import java.util.Scanner;

public class Task8 {
	//8. В числовой матрице поменять местами два столбца любых столбца, 
	//т. е. все элементы одного столбца поставить на соответствующие им позиции другого, 
	//а его элементы второго переместить в первый. 
	//Номера столбцов вводит пользователь с клавиатуры.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int rowNumber=enterValue(sc, "Enter the number of rows in matrix: ");
		int colNumber=enterValue(sc, "Enter the number of columns in matrix: ");
		
		int [][] testMatrix=createMatrix(rowNumber,colNumber);
		
		System.out.println("Choose number of two columns to be replaced with each other:");
		int chosenFirstCol=enterLimitedValue(sc,"Choose first column - nonnegative number less than "+ colNumber+" :",colNumber);
		int chosenSecondCol=enterLimitedValue(sc,"Choose second column - nonnegative number less than "+ colNumber+" :",colNumber);
		
		System.out.println("Original matrix:");
		printMatrix(testMatrix);
		
		System.out.println("Return new changed matrix :");
		System.out.println("Result matrix:");
		printMatrix(changeMatrixColumns1(testMatrix,chosenFirstCol,chosenSecondCol));
		
		System.out.println("Original matrix after:");
		printMatrix(testMatrix);
			
		System.out.println("Change in place:");
		System.out.println("Result matrix:");
		changeMatrixColumns(testMatrix,chosenFirstCol,chosenSecondCol);
		printMatrix(testMatrix);
		
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
				matrix[i][j]=rand.nextInt(50)-25;	
			}
		}
		
		return matrix;
	}
	
	
	//zero-based row and column numbers, replacement in place
	public static void changeMatrixColumns(int [][] matrix,int firstCol,int secondCol) {
		int temp=0;
		for(int i=0;i<matrix.length;i++) {
			temp=matrix[i][firstCol];
			matrix[i][firstCol]=matrix[i][secondCol];
			matrix[i][secondCol]=temp;
		}
	}
		
	
	//zero-based row and column numbers, original matrix is unchanged
	public static int[][] changeMatrixColumns1(int [][] matrix,int firstCol,int secondCol) {
		int [][] result=copyMatrix(matrix);
		int temp=0;
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				temp=matrix[i][firstCol];
				result[i][firstCol]=matrix[i][secondCol];
				result[i][secondCol]=temp;
			}
		}
		return result;
	}
	
	
	public static int[][] copyMatrix(int[][]matrix){
		int[][] copy=new int[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				copy[i][j]=matrix[i][j];
			}
		}
		
		return copy;
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
