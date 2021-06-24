package by.htp.string.asarray;

public class Task1_5 {
	//5. Удалить в строке все лишние пробелы, 
	//то есть серии подряд идущих пробелов заменить на одиночные пробелы.
	//Крайние пробелы в строке удалить.


	public static void main(String[] args) {
		String testString1= "Word      4 ord,word4  ,20   5nam 890    nu4,k 25.3  25,6   ";   
		System.out.println(testString1);
		System.out.println("Corrected line:\n"+deleteUnnesessaryWhitespace(testString1)+"\n");
		
		String testString2= "    ";   
		System.out.println(testString2);
		System.out.println("Line length: "+testString2.length());
		System.out.println("Corrected line:\n"+deleteUnnesessaryWhitespace(testString2));
		System.out.println("Line length: "+deleteUnnesessaryWhitespace(testString2).length());

	}
	
	
	public static String deleteUnnesessaryWhitespace(String example) {
		if(example.isEmpty()) {
			return example;
		}
	
		StringBuilder result=new StringBuilder(); 
		char [] test=example.toCharArray();
		boolean isPreviousWhitespace=false;
		//counter for whitespace, use to figure out last whitespaces
		//in case the use of .trim() is prohibited
		int count=0;		
		
		for(int i=0;i<test.length;i++) {
			if(!Character.isWhitespace(test[i]) ) {
				result.append(test[i]);
				isPreviousWhitespace=false;	
				count=0;
			}else {
				count++;
				if(!isPreviousWhitespace ) {
					result.append(test[i]);
					isPreviousWhitespace=true;
				}
			}	       
		}
		
		if(example.length()==count) {
			return " ";
		}
		else {
			//remove last whitespaces
			result.delete(result.length()-count, result.length());
		}
		
		return result.toString();		
	}
}
