package by.htp.string.asarray;

public class Task1_3 {
	//3. В строке найти количество цифр.
	
	public static void main(String[] args) {
		String testString1= "Word 4 ord,word4 ,20  5nam 890 nu4,k ";   //9 digits
		System.out.println(testString1);
		System.out.println("Number of digits in the given line: "+countDigits(testString1)+"\n");
		
		String testString2= "";
		System.out.println(testString2);
		System.out.println("Number of digits in the given line: "+countDigits(testString2)+"\n");
		
		String testString3= "25 36.";
		System.out.println(testString3);
		System.out.println("Number of digits in the given line: "+countDigits(testString3)+"\n");
	}
	
	
	public static int countDigits(String example) {
		int result=0;
		char [] test=example.toCharArray();
		
		for (int i=0;i<example.length();i++) {
			if (Character.isDigit(test[i])) {
				result++;
			}
		}
	
		return result;
	}
}
