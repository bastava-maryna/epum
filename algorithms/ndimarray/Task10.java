package by.htp.algorithms.ndimarray;

import java.util.Random;
import java.util.Scanner;

public class Task10 {
	//10. Найти положительные элементы главной диагонали квадратной матрицы.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int matrixSize=enterValue(sc, "Enter the size of a  matrix - positive even number: ");
		
		System.out.println("Given matrix:");
		int [][] testMatrix=createSquareMatrix(matrixSize);
		printMatrix(testMatrix);
		

		System.out.println("Sum of positive elements of main diagonal is:");
		System.out.println(calculate(testMatrix));
		
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
	
	
	public static int[][] createSquareMatrix(int size) {
		Random rand=new Random ();
		int[][] matrix=new int[size][size];
		
		for (int i=0;i<size;i++) {
			for (int j=0;j<size;j++) {
				matrix[i][j]=rand.nextInt(50)-25;	
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

	
	public static int calculate(int[][] matrix){
		int sum=0;
		
		for (int i=0;i<matrix.length;i++) {
			if( matrix[i][i]>0) {
				sum+=matrix[i][i];
			}
		}
	
		return sum;
	}
}
