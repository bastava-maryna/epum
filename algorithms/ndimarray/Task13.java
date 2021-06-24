package by.htp.algorithms.ndimarray;

import java.util.Random;
import java.util.Scanner;

public class Task13 {
	//13. Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int rowNumber=enterValue(sc, "Enter the number of rows in matrix: ");
		int colNumber=enterValue(sc, "Enter the number of columns in matrix: ");
		
		int [][] testMatrix=createMatrix(rowNumber,colNumber);
		
		System.out.println("Original matrix:");
		printMatrix(testMatrix);
			
		System.out.println("Result matrix with increase order of matrix columns:");
		printMatrix(increaseOrderMatrixCols(testMatrix));
		
		System.out.println("Result matrix with decrease order of matrix columns:");
		printMatrix(decreaseOrderMatrixCols(testMatrix));
		
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
		
	
	//zero-based row and column numbers, original matrix is unchanged
	public static int[][] increaseOrderMatrixCols(int [][] matrix) {
		int rows=matrix.length;
		int cols=matrix[0].length;
		int [][] result=copyMatrix(matrix);
		
		for(int j=0;j<cols;j++) {
			for(int i=0;i<rows;i++) {
			
				int cur=result[i][j];
				int minInd=i;
				
				for(int r=i+1;r<rows;r++) {
					if(result[r][j]<cur ) {
						cur=result[r][j];
						minInd=r;
					}
				}
				
				if(minInd!=i) {
					int temp=result[i][j];
					result[i][j]=result[minInd][j];
					result[minInd][j]=temp;
				}
			}
		}
		return result;
	}
	
	
	//zero-based row and column numbers, original matrix is unchanged
	public static int[][] decreaseOrderMatrixCols(int [][] matrix) {
		int rows=matrix.length;
		int cols=matrix[0].length;
		int [][] result=copyMatrix(matrix);
		
		for(int j=0;j<cols;j++) {
			for(int i=0;i<rows;i++) {
			
				int cur=result[i][j];
				int maxInd=i;
					
				for(int r=i+1;r<rows;r++) {
					if(result[r][j]>cur ) {
						cur=result[r][j];
						maxInd=r;
					}
				}
				
				if(maxInd!=i) {
					int temp=result[i][j];
					result[i][j]=result[maxInd][j];
					result[maxInd][j]=temp;
				}
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
