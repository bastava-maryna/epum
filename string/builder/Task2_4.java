package by.htp.string.builder;

public class Task2_4 {
	//4. С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.

	public static void main(String[] args) {
		String word="торт";
		String testString1= "информатика";  
		
		System.out.println(testString1);
		System.out.println("The result is\n"+createWord(testString1,word)+"\n");
		
		String testString2= "инфрматика";
		System.out.println(testString2);
		System.out.println("The result is\n"+createWord(testString2,word));
		
		String testString3= "";
		System.out.println(testString3);
		System.out.println("The result is\n"+createWord(testString3,word));	
	}
	
	
	public static String createWord(String example,String word ) {
		if(example.isEmpty()) {
			return "Impossible create a word from nothing" ;
		}
		
		String result="";
		
		for(int i=0;i<word.length();i++) {	
			char temp=word.charAt(i);
			int ind=example.indexOf(temp);
			
			if (ind<0) {
				return "There is not enough letters to create the word" ;
			}else {
				result=result.concat(example.substring(ind, ind+1));
			}
		}
		
		return result;		
	}
}
