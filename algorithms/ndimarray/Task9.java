package by.htp.algorithms.ndimarray;

import java.util.Random;
import java.util.Scanner;

public class Task9 {
	//9. Задана матрица неотрицательных чисел. 
	//Посчитать сумму элементов в каждом столбце. Определить, какой столбец содержит максимальную сумму.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int rowNumber=enterValue(sc, "Enter the number of rows in matrix: ");
		int colNumber=enterValue(sc, "Enter the number of columns in matrix: ");
		
		
		int [][] testMatrix=createNonNegativeMatrix(rowNumber,colNumber);
		System.out.println("Matrix is :");
		printMatrix(testMatrix);
		
		int[] testMatrixColumnSum=sumOfColumns(testMatrix);
		
		System.out.println("The sum of each column:");
		printArray(testMatrixColumnSum);
		
		System.out.println("The column with maximal sum is :");
		System.out.println(maxElementIndex(testMatrixColumnSum));
		
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
	
	
	public static int[][] createNonNegativeMatrix(int rowNumber, int colNumber) {
		Random rand=new Random ();
		int[][] matrix=new int[rowNumber][colNumber];
		
		for (int i=0;i<rowNumber;i++) {
			for (int j=0;j<colNumber;j++) {
				matrix[i][j]=rand.nextInt(50);	
			}
		}
		
		return matrix;
	}
	
	
	//zero-based row and column numbers
	public static int[] sumOfColumns(int [][] matrix) {
		int rows=matrix.length;
		int cols=matrix[0].length;
		
		if(rows==1 && cols==1) {
			return new int[]{matrix[0][0]};
		}
		
		int [] result=new int[cols];
		
		for(int j=0;j<cols;j++) {
			int sum=0;
			for(int i=0;i<rows;i++){
				sum+=matrix[i][j];
			}	
			result[j]=sum;
		}
		
		return result;
	}
	
	
	public static int maxElementIndex(int[]array) {
		if(array.length==1) {
			return 0;
		}
		
		int max=array[0];
		int index=0;
		for (int i=1;i<array.length;i++) {
			if(array[i]>max) {
				max=array[i];
				index=i;
			}
		}
		return index;
	}
	
	
	public static void printMatrix(int [][] matrix) {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				System.out.printf("%7d",matrix[i][j]);
			}
			System.out.println();	
		}
	}
	
	
	public static void printArray(int[]array) {
		for(int i=0;i<array.length;i++) {
			System.out.printf("%7d",array[i]);
		}
		System.out.println();
	}

}
