package by.htp.string.builder;

public class Task2_10 {
	//10. Строка X состоит из нескольких предложений, каждое из которых кончается точкой, 
	//восклицательным или вопросительным знаком. 
	//Определить количество предложений в строке X.

	public static void main(String[] args) {
		String testString1= "Hi, Richard! she said, and spit out a mouthful of "
				+ "toothpaste. Was she wearing cut-off jeans?  No.";
		System.out.println(testString1);
		System.out.println("The number of sentences in the given text: "+countSentences(testString1)+"\n");
		
		String testString2= "";   
		System.out.println(testString2);
		System.out.println("The number of sentences in the given text: "+countSentences(testString2)+"\n");
		
	}
	
	
	public static int countSentences(String example) {
		if(example.isEmpty()) {
			return 0;
		}
		
		char dot='.';
		char quest='?';
		char exlam='!';
		
		StringBuilder test=new StringBuilder(example);
		int count=0;
		
		for(int i=0;i<test.length();i++) {
			int curr=(int)(test.charAt(i));
			
			if(curr==dot || curr==quest || curr==exlam) {
				count++;
			}
		}
		
		return count;		
	}
}
