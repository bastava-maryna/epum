package by.htp.string.builder;

public class Task2_5 {
	//5. Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.

	public static void main(String[] args) {
		char letter= 'a'; 
		String testString1= "Лёша на полке";  //number will be 0 because of letter is English a
		System.out.println(testString1);
		System.out.println("The number of "+letter+" in the given line: "+countLetter(testString1,letter)+"\n");
		
		String testString2= "";   
		System.out.println(testString2);
		System.out.println("The number of "+letter+" in the given line: "+countLetter(testString2,letter)+"\n");
		
		String testString3= "odd aaa ora aeavaen";   
		System.out.println(testString3);
		System.out.println("The number of "+letter+" in the given line: "+countLetter(testString3,letter)+"\n");
		
		String testString4= "Never odd or even";   
		System.out.println(testString4);
		System.out.println("The number of "+letter+" in the given line: "+countLetter(testString4,letter)+"\n");	
	}
	
	
	public static int countLetter(String example,char letter) {
		if(example.isEmpty()) {
			return 0 ;
		}
		
		StringBuilder test=new StringBuilder(example);
		int count=0;
		
		for(int i=0;i<test.length();i++) {	
			if(test.charAt(i)==letter) {
				count++;
			}	
		}
		
		return count;		
	}
}
