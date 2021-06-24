package by.htp.string.asarray;

public class Task1_2 {
	// 2. Замените в строке все вхождения 'word' на 'letter'.

	public static void main(String[] args) {
		String str1="word";
		String str2="letter";
		
		String testString1= "Word is a language structure. word,word4 ,word.word! There are a lot of words in the world. Each word is important. ";
		System.out.println(testString1);
		String convertedString1=replaceWordByAnotherWord(testString1,str1,str2);
		System.out.println(convertedString1);
		
		String testString2= "";
		System.out.println(testString2);
		String convertedString2=replaceWordByAnotherWord(testString2,str1,str2);
		System.out.println(convertedString2);
		
		String testString3= "wordword  w bigword 4word, perfectWord wor.";
		System.out.println(testString3);
		String convertedString3=replaceWordByAnotherWord(testString3,str1,str2);
		System.out.println(convertedString3);
		
	}	
	
	
	public static String replaceWordByAnotherWord (String example,String oldString, String newString ) {
		int oldStringLength=oldString.length();
		
		if (example.length()<oldStringLength) {
			return example;
		}
		
		StringBuilder result=new StringBuilder();
		char []content=example.toCharArray();
		char [] oldStringContent=oldString.toCharArray();
		
		int exampleLength=example.length();
		int i=0;
		
		while(i<=exampleLength-oldStringLength) {
			for(int j=0;j<oldStringLength;j++) {
				if (content[i+j]!=oldStringContent[j]) {
					result.append(content[i]);
					i++;
					break;
				}
				
				if(j==oldStringLength-1) {		
					result.append(newString);
					i+=oldStringLength;	
				}
			}
		}	
		
		if (i<exampleLength) {
			result.append(example.substring(i,exampleLength));
		}	
		
		return result.toString();			
	}
}
