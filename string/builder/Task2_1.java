package by.htp.string.builder;

public class Task2_1 {
	//1. Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.

	public static void main(String[] args) {
		String testString1= "Word      4 ord,word4  ,20   5nam 890    nu4,k 25.3  25,6   ";   
		System.out.println(testString1);
		System.out.println("Max number of consequative whitespaces: "+maxConsequativeWhitespace(testString1)+"\n");
		
		String testString2= "   ";   
		System.out.println(testString2);
		System.out.println("Line length: "+testString2.length());
		System.out.println("Max number of consequative whitespaces: "+maxConsequativeWhitespace(testString2));
	}
	
	
	public static int maxConsequativeWhitespace(String example) {
		if(example.isEmpty()) {
			return 0;
		}
			
		int max=0;
		int i;
		
		for(i=0;i<example.length()-1;i++) {
			int j=i;
			char curr=example.charAt(i);
			
			if (curr==' ') {
				int count=1;
				
				while(j<example.length()-1 && curr==example.charAt(j+1)) {
					count++;
					j++;
				}
				
				if(count>max) {
					max=count;
				}
				
				i+=count;
			}
		}
		
		return max;		
	}
}
