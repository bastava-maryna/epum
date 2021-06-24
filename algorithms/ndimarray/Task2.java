package by.htp.algorithms.ndimarray;

import java.util.ArrayList;
import java.util.Random;

public class Task2 {
	//2. Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.

	public static void main(String[] args) {
		int [][] testMatrix=createMatrix(5,5);
		
		System.out.println("Original matrix:");
		printMatrix(testMatrix);
		
		System.out.println("Elements from diagonal:");
		System.out.println(calculate(testMatrix));
		
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
	

	public static ArrayList<Integer> calculate(int[][] matrix){
		ArrayList <Integer> result=new ArrayList<Integer>();
		
		for (int i=0;i<matrix.length;i++) {
			result.add( matrix[i][i]);			
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
