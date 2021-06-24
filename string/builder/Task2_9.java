package by.htp.string.builder;

public class Task2_9 {
	//9. Посчитать количество строчных (маленьких) и прописных (больших) букв 
	//в введенной строке. Учитывать только английские буквы.

	public static void main(String[] args) {
		String testString1= "The Menu is uSed creaTe variouS types"; 
				
		System.out.println(testString1);
		System.out.println(countLowerUpperEnglish(testString1)+"\n");
		
		String testString2= " ";   
		System.out.println(testString2);
		System.out.println(countLowerUpperEnglish(testString2)+"\n");
		
		String testString3= "Tяe Menu, Уidget иs uSed .cДea varioуS";   
		System.out.println(testString3);
		System.out.println(countLowerUpperEnglish(testString3)+"\n");
		
	}
	
	
	public static String countLowerUpperEnglish(String example) {
		if(example.isEmpty()) {
			return "Number of lowerCase letters is 0, number of upperCase letters is 0" ;
		}
		
		StringBuilder test=new StringBuilder(example);
		int countLower=0;
		int countUpper=0;
	
		for(int i=0;i<test.length();i++) {
			int curr=(int)(test.charAt(i));
			
			if(curr>=97 && curr<=122) {
				countLower++;
			}
			
			if(curr>=65 && curr<=90) {
				countUpper++;
			}
		}
		
		StringBuilder result=new StringBuilder();
		result.append("Number of lowerCase letters is ").append(countLower).
			append(", number of upperCase letters is ").append(countUpper);
		
		return result.toString();		
	}
}
