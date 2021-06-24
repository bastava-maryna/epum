package by.htp.basic.loop;

public class AlphabetRepresentation {
	//6. Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.

	public static void main(String[] args) {
		System.out.println("Russsian alphabet unicode representation:\n");
		printAlphabetRepresentation();
	}
	
	public static void printAlphabetRepresentation() {
		System.out.printf("%6s %10s %15s %n","symbol","decimal","hexadecimal");
		for(char symbol='А';symbol<='я';symbol ++) {					
			//System.out.println(symbol +"   " + (int)symbol +"   " +String.format("\\u%04x", (int)symbol));
			System.out.printf("%4s %10d %15s %n",symbol, (int)symbol ,String.format("\\u%04x", (int)symbol));
		}
	}
}

//char - to represent single 16-bit unicode character, '\u0000' - '\uffff' 65535 characters
//(int)char - decimal representation
//String.format("\\u%04x", (int)char) - hexadecimal representation
//if String charAt(index) return unicode character at position index