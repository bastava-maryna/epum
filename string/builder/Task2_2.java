package by.htp.string.builder;

public class Task2_2 {
	//2. В строке вставить после каждого символа 'a' символ 'b'.

	public static void main(String[] args) {
		char after='a';
		char what='b';
		String testString1= "Nam  4 aart 2a  nu4,k A Aa aA   ";   
		System.out.println(testString1);
		System.out.println("Corrected line:\n"+insertAfter(testString1,after,what));
		
		String testString2= " ";   
		System.out.println(testString2);
		System.out.println("Line length: "+testString2.length());
		System.out.println("Corrected line:\n"+insertAfter(testString2,after,what));

	}
	
	
	public static String insertAfter(String example,char after,char what) {
		if(example.isEmpty()) {
			return example;
		}
	
		StringBuilder result=new StringBuilder(example); 
		
		for(int i=0;i<result.length();i++) {	
			if(result.charAt(i)==after ) {
				result.insert(i+1,what);
				i++;
			}	
		}
		
		return result.toString();		
	}
}
