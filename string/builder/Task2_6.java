package by.htp.string.builder;

public class Task2_6 {
	//6. Из заданной строки получить новую, повторив каждый символ дважды.

	public static void main(String[] args) {
		String testString1= "Never odd or even!";  
		System.out.println(testString1);
		System.out.println("The result is\n"+doubleLetter(testString1)+"\n");
		
		String testString2= "  ";   
		System.out.println(testString2);
		System.out.println("Line length: "+testString2.length());
		System.out.println("The result is\n"+doubleLetter(testString2)+"\n");
		System.out.println("Line length: "+doubleLetter(testString2).length());
	}
	
	
	public static String doubleLetter(String example) {
		if(example.isEmpty()) {
			return example ;
		}
		
		StringBuilder test=new StringBuilder(example);
		
		for(int i=0;i<test.length();i++) {	
			test.insert(i, test.charAt(i)) ;
				i++;
		}
		
		return test.toString();		
	}
}
