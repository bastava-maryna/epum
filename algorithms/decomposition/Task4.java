package by.htp.algorithms.decomposition;

import java.util.Random;
import java.util.Scanner;

public class Task4 {
	//4. На плоскости заданы своими координатами n точек. 
	//Написать метод(методы), определяющие, между какими из пар точек самое большое расстояние. 
	//Указание. Координаты точек занести в массив.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int number=enterValue(sc,"Enter number of points:");  
		//int numberK=10010;
		
		int[][]points=definePoints(number);
		printPoints(points);
		
		
		System.out.println("You enter:\nnumber of points=" + number);
		int[] result=calculate(points);
		System.out.println("The maximal distance is between point "+result[0]+ " and point "+result[1]);
		
		sc.close();
	}
	
	
	public static int enterValue(Scanner sc, String message) {
		int value=0;
		System.out.println(message);
		
		do {
			while(!sc.hasNextInt()) {
				System.out.println("Your input is not an integer number. Try again:");
				sc.next();
			}
			
			value=sc.nextInt();
			
			if(value<=1) {
				System.out.println("You enter number less than 1. Try again: ");
			}
		}
		while(value<=1);
		
		return value;
	}
	
	
	public static int[][] definePoints(int number){
		int [][] points=new int [number][2];
		
		Random rand=new Random();
		for(int i=0;i<number;i++) {
			points[i][0]=rand.nextInt(30)-15;
			points[i][1]=rand.nextInt(30)-15;
		}
		
		return points;		
	}
	
	
	public static double distance(int[]point1,int[]point2) {
		int tempx=(point2[0]-point1[0])*(point2[0]-point1[0]);	//(x2-x1)^2
		int tempy=(point2[1]-point1[1])*(point2[1]-point1[1]);  //(y2-y1)^2
		
		return Math.sqrt(tempx +tempy);
	}
	
	
	//return first from the equal, to obtain all- may use arraylist to store the points
	public static int[]calculate(int[][] points){
		int [] result=new int[2];
		
		if(points.length==2) {
			result[0]=0;
			result[1]=1;
			return result;
		}
		
		int point1=0;
		int point2=0;
		double max_dist=0;
		double cur_dist=0;
		for(int i=0;i<points.length-1;i++) {
			for(int j=i+1;j<points.length;j++) {
				cur_dist=distance(points[i],points[j]);
				if(cur_dist>max_dist) {
					max_dist=cur_dist;
					point1=i;
					point2=j;
				}
			}
		}
		
		result[0]=point1;
		result[1]=point2;
		
		return result;
	}
	

	public static int[]calculate1(int[][] points){
		int [] result=new int[2];
			
		if(points.length==2) {
			result[0]=0;
			result[1]=1;
			return result;
		}
			
		int point1=0;
		int point2=0;
		double max_dist=0;
		double cur_dist=0;
		for(int i=0;i<points.length-1;i++) {
			for(int j=i+1;j<points.length;j++) {
				cur_dist=distance(points[i],points[j]);
				if(cur_dist>max_dist) {
					max_dist=cur_dist;
					point1=i;
					point2=j;
				}
			}
		}
			
		result[0]=point1;
		result[1]=point2;
			
		return result;
	}
	
	
	public static void printPoints(int[][]points) {
		for (int i=0;i<points.length;i++) {
			System.out.println("Point "+i+" :("+points[i][0]+","+points[i][1]+")");
		}
	}

}
