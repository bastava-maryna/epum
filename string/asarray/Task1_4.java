package by.htp.string.asarray;

public class Task1_4 {
	//4. В строке найти количество чисел.

	public static void main(String[] args) {
		String testString1= "Word 4 ord,word4 ,20  5nam 890 nu4,k 25.3  25,6 ";   //4 numbers
		System.out.println(testString1);
		System.out.println("Number of numbers in the given line: "+countNumbers(testString1)+"\n");
		
		String testString2= "";	//0 numbers
		System.out.println(testString2);
		System.out.println("Number of numbers in the given line: "+countNumbers(testString2)+"\n");
		
		String testString3= "22/55/6 25 36 /3 2//5 2/5 /5  6/ 22,.6 ";	//3 numbers
		System.out.println(testString3);
		System.out.println("Number of numbers in the given line: "+countNumbers(testString3)+"\n");
	}

	
	//i count as a number: any separate sequence of digits, digits divided by one , or . or /
	public static int countNumbers(String example) {
		int result=0;
		String [] parts=example.split(" ");
		
		char comma=',';
		char dot='.';
		char div='/';		
		
		for(int k=0;k<parts.length;k++) {
			char [] test=parts[k].toCharArray();
			int countDelim=0;
			int temp=0;		//allow to avoid parts which start with whitespace
		
			for(int i=0;i<test.length;i++) {
				if(Character.isDigit(test[i])) {
					temp++;
					if(temp==test.length) {
						result++;
						temp=0;
						break;
					}	
				}else if(test[i]==comma|| test[i]==dot || test[i]==div ) {
					if(countDelim==0 && temp>0 ) {
						countDelim++;
						temp++;
					}
				}
			}
		}
					
		return result;
	}
}
