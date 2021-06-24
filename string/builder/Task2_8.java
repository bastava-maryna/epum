package by.htp.string.builder;

public class Task2_8 {
	//8. Вводится строка слов, разделенных пробелами. 
	//Найти самое длинное слово и вывести его на экран. 
	//Случай, когда самых длинных слов может быть несколько, не обрабатывать.

	public static void main(String[] args) {
		String testString1= "Neever odd or even!";  
		System.out.println(testString1);
		System.out.println("The result is:\n"+longestWord1(testString1));
		
		String testString2= "Neever oddorodd even!";  
		System.out.println(testString2);
		System.out.println("The result is:\n"+longestWord1(testString2));
		
		String testString3= "Neever odd or oddeven!";  
		System.out.println(testString3);
		System.out.println("The result is:\n"+longestWord1(testString3));
	
		String testString4= "  ";   
		System.out.println(testString4);
		System.out.println("Line length: "+testString4.length());
		System.out.println("The result is:\n"+ longestWord1(testString4));
		
	}

	
	public static String longestWord1(String example) {
		String [] test=example.split("\\s");
		int ind=0;
		int max=0;
		
		if(test.length==0) {
			return "" ;
		}
	
		for(int i=0;i<test.length;i++) {	
			int temp=test[i].length();
		
			if(temp>max) {
				max=temp;
				ind=i;
			}
		}	
	
		return test[ind];		
	}
	
	
	public static String longestWord(String example) {
		if(example.isEmpty()) {
			return example ;
		}
		
		StringBuilder test=new StringBuilder(example);
		int count=0;
		int max=0;
		
		for(int i=0;i<test.length();i++) {	
			if(!Character.isWhitespace(test.charAt(i))) {
				count++;
			}
			else {
				if(count>max) {
					max=count;
					if(max<i) {
						test.delete(0, i-max);
						i=max;
					}
				}else {
					test.delete(max, i);
					i=max;
				}
				count=0;
			}				
		}
		
		if(count>max) {
			test.delete(0, test.length()-count);
		}
		else {
			test.delete(max, test.length());
		}
		
		return test.toString();		
	}
}
