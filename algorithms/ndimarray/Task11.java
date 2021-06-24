package by.htp.algorithms.ndimarray;

import java.util.ArrayList;
import java.util.Random;

public class Task11 {
	//11. Матрицу 10x20 заполнить случайными числами от 0 до 15. 
	//Вывести на экран саму матрицу и номера строк, в которых число 5 встречается три и более раз.

	public static void main(String[] args) {
	
		int [][] testMatrix=createMatrix(10,20);
		
		System.out.println("Given matrix:");
		printMatrix(testMatrix);
		
		System.out.println("Number of rows where number 5 appears 3 and more times :");
		System.out.println(calculate(testMatrix));
	}
	
	
	public static int[][] createMatrix(int rowNumber, int colNumber) {
		Random rand=new Random ();
		int[][] matrix=new int[rowNumber][colNumber];
		
		for (int i=0;i<rowNumber;i++) {
			for (int j=0;j<colNumber;j++) {
				matrix[i][j]=rand.nextInt(15);	
			}
		}
		
		return matrix;
	}
	
	
	//zero-based row and column numbers, replacement in place
	public static ArrayList<Integer> calculate(int [][] matrix) {
		ArrayList<Integer> result=new ArrayList<Integer>();
		
		for(int i=0;i<matrix.length;i++) {
			int count=0;
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]==5) {
					count++;
				}
			}
			if(count>=3) {
				result.add(i);
			}
		}
		
		return result;
	}
		
	
	public static void printMatrix(int [][] matrix) {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				System.out.printf("%5d",matrix[i][j]);
			}
			System.out.println();	
		}
	}
}
