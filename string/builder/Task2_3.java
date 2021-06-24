package by.htp.string.builder;

public class Task2_3 {
	//3. Проверить, является ли заданное слово палиндромом.
	//Палиндро́м -число, буквосочетание, слово или текст, 
	//одинаково читающееся в обоих направлениях. Например, число 101; слова «топот»

	public static void main(String[] args) {
		//String testString1= "Лёша на полке клопа нашёл"; 
		String testString1= "Лёша на полке";  
		System.out.println(testString1);
		System.out.println("The sentence is "+(isPalindrome(testString1)?"":"not ")+ "a palindrome");
		
		String testString2= "676";   
		System.out.println(testString2);
		System.out.println("The sentence is "+(isPalindrome(testString2)?"":"not ")+ "a palindrome");
		
		String testString3= "Never odd or even";   
		System.out.println(testString3);
		System.out.println("The sentence is "+(isPalindrome(testString3)?"":"not ")+ "a palindrome");
		
		String testString4= "Never odk or even";   
		System.out.println(testString4);
		System.out.println("The sentence is "+(isPalindrome(testString4)?"":"not ")+ "a palindrome");
	}
	
	
	public static boolean isPalindrome(String example) {
		if(example.isEmpty()) {
			return false ;
		}
		String prepared=example.replaceAll(" ", "").toLowerCase();
		StringBuilder test=new StringBuilder(prepared);
		StringBuilder testReversed=new StringBuilder(prepared).reverse();
		
		for(int i=0;i<test.length();i++) {	
			if(test.charAt(i)!=testReversed.charAt(i) ) {
				return false;
			}	
		}
		
		return true;		
	}

}
