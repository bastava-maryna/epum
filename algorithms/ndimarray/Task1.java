package by.htp.algorithms.ndimarray;

import java.util.ArrayList;
import java.util.Random;

public class Task1 {
	//1. Дана матрица. 
	//Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.

	public static void main(String[] args) {
		int [][] testMatrix=createMatrix(4,10);
		
		System.out.println("Original matrix:");
		printMatrix(testMatrix);
		
		System.out.println("Filtered matrix with metod1:");
		printMatrix(calculate1(testMatrix));
		
		System.out.println("Filtered matrix with method2:");
		printMatrix(calculate2(testMatrix));	
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
	

	//zero-based column number
	public static int[][] calculate1(int[][] matrix){
		int rowNumber=matrix.length;
		ArrayList <Integer> temp=new ArrayList<Integer>();
		
		for (int j=1;j<matrix[0].length;j+=2) {
			if(matrix[0][j]>matrix[matrix.length-1][j]) {
				for(int i=0;i<matrix.length;i++) {
					temp.add( matrix[i][j]);
				}	
			}
		}
		
		int newColNumber=	temp.size()/rowNumber;
		int [][] result=new int[rowNumber][newColNumber];
		
		for(int i=0;i<rowNumber;i++) {
			for(int j=0;j<newColNumber;j++) {
				result[i][j]=temp.get((i+4*j));
			}
		}
		
		return result;
	}
	
	
	public static int[][] calculate2(int[][] matrix){
		int rowNumber=matrix.length;	
		ArrayList <Integer> filteredColNumber=new ArrayList<Integer>();
			
		for (int j=1;j<matrix[0].length;j+=2) {
			if(matrix[0][j]>matrix[rowNumber-1][j]) {
					filteredColNumber.add(j);
			}
		}
		
		int newColNumber=	filteredColNumber.size();
		int [][] result=new int[rowNumber][newColNumber];
		
		for(int j=0;j<filteredColNumber.size();j++) {
			int col=filteredColNumber.get(j);
			for(int i=0;i<rowNumber;i++) {		
				result[i][j]=matrix[i][col];
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
