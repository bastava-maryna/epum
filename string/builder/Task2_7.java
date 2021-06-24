package by.htp.string.builder;

public class Task2_7 {
	//7. Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. 
	//Например, если было введено "abc cde def", то должно быть выведено "abcdef".


	public static void main(String[] args) {
		
		String testString1= "Neever odd or even!";  
		System.out.println(testString1);
		System.out.println("The result is:\n"+modify(testString1));
	
		String testString2= "  ";   
		System.out.println(testString2);
		System.out.println("Line length: "+testString2.length());
		System.out.println("The result is:\n"+ modify(testString2));
		System.out.println("Line length: "+modify(testString2).length());
	}
	
	
	public static String modify(String example) {
		if(example.isEmpty()) {
			return example ;
		}
		
		StringBuilder test=new StringBuilder(example);
		
		for(int i=0;i<test.length()-1;i++) {	
			for (int j=i+1;j<test.length();j++) {
				char curr=test.charAt(i);
				char next=test.charAt(j);
				if(curr==next){
					test.deleteCharAt(j);
				}
				if(Character.isWhitespace(curr)) {
					test.deleteCharAt(i);
					i--;
				}
			}
		}
		
		return test.toString();		
	}
}
