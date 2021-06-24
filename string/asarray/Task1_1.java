package by.htp.string.asarray;

import java.util.Arrays;

public class Task1_1 {
	//1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case
	
	public static void main(String[] args) {
		String[] testStringArray1= {"bookShelf","javaScript","helloWorld","bigInteger","dataStructure"};
		System.out.println(Arrays.toString(testStringArray1));
		String[] convertedStringArray1=fromCamelToSnakeCase(testStringArray1);
		System.out.println(Arrays.toString(convertedStringArray1));
		
		String[] testStringArray2= {"4","javaScript","    ","BigInteger","dataStructure",""};
		System.out.println(Arrays.toString(testStringArray2));
		String[] convertedStringArray2=fromCamelToSnakeCase(testStringArray2);
		System.out.println(Arrays.toString(convertedStringArray2));
		
		String[] testStringArray3= {};
		System.out.println(Arrays.toString(testStringArray3));
		String[] convertedStringArray3=fromCamelToSnakeCase(testStringArray3);
		System.out.println(Arrays.toString(convertedStringArray3));
		
	}
	
	
	public static String [] fromCamelToSnakeCase(String []camelArray) {
		String [] result=new String [camelArray.length];
		
		if(camelArray.length==0) {
			System.out.println("Test array is empty");
			return result;
		}
		
		for (int i=0;i<camelArray.length;i++) {
			String tempString=camelArray[i];
			
			if(tempString.length()==1 || tempString.isBlank() ) {
				result[i]=camelArray[i];
			}else {
				for(int j=0;j<tempString.length();j++) {
					char tempChar=tempString.charAt(j);
					
					if(Character.isUpperCase(tempChar)) {
						result[i]=tempString.substring(0, j)
							+"_"
							+Character.toLowerCase(tempChar)
							+tempString.substring(j+1, tempString.length());
					}
				}
			}
		}
				
		return result;
	}
}
