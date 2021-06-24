package by.htp.string.regular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Task3_1 {
	//1. Cоздать приложение, разбирающее текст (текст хранится в строке) и 
	//позволяющее выполнять с текстом три различных операции: 
	//отсортировать абзацы по количеству предложений; 
	//в каждом предложении отсортировать слова по длине;
	//отсортировать лексемы в предложении по убыванию количества вхождений заданного символа,
	//а в случае равенства – поалфавиту.

	public static void main(String[] args) {
		//6 paragraphs:
		//1-4-(14,18,12,17)
		//2-1-(24)
		//3-6-(22,27,17,22,18,20)
		//4-3-(27,20,29)
		//5-7-(13,34,20,37,29,24,20)
		//6-4-(26,12,20,28)
		String text="After years of relentless work, he had gotten almost everything he had ever wanted. However, if someone had asked whether he was a happy man, Simon would have snorted at the question. Happiness, that elusive result of success, was a sure sign of complacency. By his very nature, Simon would never be complacent, or satisfied; nor did he want to be.\r\n" + 
				"All the same in the deepest, most private corner of his neglected heart, there was one wish that Simon could not seem to extinguish.\r\n" + 
				"He shot a covert glance across the ballroom, experiencing as always the peculiar sharp pang that the sight of Annabelle Peyton produced. With all the women that were available to him-and there were more than a few—no one had ever seized his attention with such all-encompassing thoroughness. Annabelle’s appeal went beyond mere physical beauty, though God knew she’d been blessed with an inequitable surplus. Were there an ounce of poetry in Simon’s soul, he might have thought of dozens of rapturous phrases to describe her charms. But he was plebeian to the core, and he could not find words accurately to describe his attraction. All he knew was that sight of Annabelle in the glittering light of the chandeliers was very nearly knee-weakening.\r\n" + 
				"Simon had never forgotten the first moment that he had seen her standing outside the panorama, digging through her purse with a little pucker on her forehead. The sun had picked out streaks of gold and champagne in her light brown hair and made her skin glow. There had been some thing so delicious so touchable  about her, the velvety skin and shining blue eyes, and the slight frown that he had longed to soothe away.\r\n" + 
				"He had been altogether certain that Annabelle would have been married by now. The evidence that the Peytons had fallen on hard times had not signified to Simon, who had assumed that any peer with his brains intact would see her worth and claim her at once. But as two years had passed, and Annabelle had remained unwed, a fragile tendril of hope had awakened inside Simon. He saw a touching valiance in her determined search for a husband, the self-possession with which she wore her increasingly threadbare gowns the clear value that she placed on herself, despite her lack of a dowry. The artful way she approached the process of husband-hunting brought to mind nothing so much as a seasoned gambler playing his last few cards in a losing game. Annabelle was smart, careful, uncompromising, and still beautiful, although lately the threat of poverty had lent a certain hardness to her eyes and mouth. Selfishly, Simon was not sorry for her financial hardship-it created an opportunity that he never would have had otherwise.\r\n" + 
				"The problem was that Simon had not yet figured out how to make Annabelle want him, when she was so obviously repulsed by everything he was. Simon was well aware that there were few graces to his character. Moreover, he had no ambition to become a gentleman any more than a tiger aspired to become a house cat. He was merely a man with a great deal of money and all the accompanying frustration of realizing that it could not buy the thing he most wanted.\r\n" ;
        
		//String text=" ";
		
		Scanner sc=new Scanner(System.in);
		
		start(sc,text);
		sc.close();
	}
	
	public static void displayMenu() {
		System.out.println("Please, enter code of operation to do\n"
				+ "1 - Sort paragraphs in text by number of sentences in paragraph\n"
				+ "2 - Sort sentences in text by word length\n"
				+ "3 - Sort sentences in text by number of repeatition of given symbol in descending order\n"
				+ "4 - Dispaly the text structure\n"
				+ "5 - Exit");
	}
	
	
	public static String[] sortTextByParagraphLength(String text) {
		if(text.isBlank() || text.isBlank()) {
			return null;
		}
		
		String[] pars=cutIntoParagraphs(text);
		
		Arrays.sort(pars, new Comparator<String>(){
			@Override
			public int compare(String o1,String o2) {
				return  cutIntoSentences(o1).length-cutIntoSentences(o2).length;
			}
		});
	
		return pars;
	}
	
	
	public static String[] sortEachSentencesByWordLength(String text) {
		if(text.isBlank() || text.isBlank()) {
			return null;
		}
		String[] pars=cutIntoParagraphs(text);
		
		for(int i=0;i<pars.length;i++) {
			StringBuilder resultPar= new StringBuilder();
			String[] sens=cutIntoSentences(pars[i]);
			
			for(int j=0;j<sens.length;j++) {
				resultPar.append(sortOneSentenceByWordLength(sens[j])).append('.').append(' ');
			}
        	pars[i] = resultPar.toString();
        }
	
		return pars;
	}
	
	
	public static String sortOneSentenceByWordLength(String sent) {
		String[] words=cutIntoWords(sent);
		Arrays.sort(words, new Comparator<String>(){					
						@Override
						public int compare(String o1,String o2) {
							return  o1.length()-o2.length();
						}
		});
	
		return String.join(" ", words);
	}
	
	
	public static String[] cutIntoParagraphs(String text){
		if(text.isBlank() || text.isBlank()) {
			return null;
		}
		
		String[] pars=text.split("\r\n");
		return pars;
	}
	
	
	public static String[] cutIntoSentences(String paragr){
		String [] sentences=paragr.split("[.!?]");
		return sentences;
	}
	
	
	public static String[] cutIntoWords(String sentence){
		String [] words=sentence.strip().split("\\s+|-|,\\s");
		return words;
	}
	
	
	public static int countRepeat(String word,char ch){
		int count=0;
		for(int i=0;i<word.length();i++) {
			if(word.charAt(i)==ch) {
				count++;
			}
		}
		return count;
	}
	
	
	public static String[] sortEachSentencesByRepeatedSymbol(String text,char ch) {
		if(text.isBlank() || text.isBlank()) {
			return null;
		}
		
		String[] pars=cutIntoParagraphs(text);
		
		for(int i=0;i<pars.length;i++) {
			StringBuilder resultPar= new StringBuilder();
			String[] sens=cutIntoSentences(pars[i]);
			
			for(int j=0;j<sens.length;j++) {		
				resultPar.append(sortByRepeatedSymbol(sens[j],ch)).append('.').append(' ');
			}
        	pars[i] = resultPar.toString();
        }
	
		return pars;
	}
	
	
	public static String sortByRepeatedSymbol(String sentence,char ch) {
		String[] words=cutIntoWords(sentence);
		HashMap<Integer, ArrayList<String>> sorted = new HashMap<Integer, ArrayList<String>>();
		
		for(int i=0;i<words.length;i++) {
			int size=countRepeat(words[i],ch);
			
			if (sorted.containsKey(size)){
				   sorted.get(size).add(words[i]);
			}else {
				  ArrayList<String> values=new ArrayList<String>();
				  values.add(words[i]);
				  sorted.put(size,values);
			}
		}
		
		List<Integer> keys = new ArrayList<>(sorted.keySet());
		Collections.sort(keys);
		
		StringBuilder res=new StringBuilder();
		
		for(int i=keys.size()-1;i>=0;i--){	
			ArrayList<String>temp=new ArrayList<String>(sorted.get(keys.get(i)));
			
			if(temp.size()>1) {
				Collections.sort(temp);
				res.append(String.join(" ", temp)).append(" ");
			}	else if(temp.size()==1) {
				res.append(temp.get(0)).append(" ");
			}	
		}
	
		return res.toString(); 
	}
	
	
	public static void printTextStructure(String text) {
		if(text.isBlank() || text.isEmpty()) {
			System.out.println("Empty text. No structure");
		}else {
			System.out.println("The text structure:");
			String []pars=cutIntoParagraphs(text);
			StringBuilder struct=new StringBuilder(); 
			int par=1;
		
			for (String p : pars) {
				String []s=cutIntoSentences(p);
			
				struct.append(par++).append("-").append(cutIntoSentences(p).length).append("-").append("(");
				
				for(String ss : s) {
					struct.append(cutIntoWords(ss).length).append(" ");
				}
				struct.append(")").append("\n");		
			}
			System.out.println(struct.toString());
		}	
	}
	
	
	public static void display(String [] arr) {
		if(arr==null) {
			System.out.println("Empty text");
		}else {
			for(String s:arr) {
				System.out.println(s);
				System.out.println("---------------------------");	
			}
		}
	}
	
	
	public static int enterOption(Scanner sc){
		int value;
		System.out.println("Enter your choice:");
		
		while(!sc.hasNextInt()) {
			System.out.println("Your input is not an integer. Try again: ");
			sc.next();
		}
		value=sc.nextInt();
		
		return value;
	}
	
	
	public static int enterChar(Scanner sc){
		char value;
		System.out.println("Enter one character to use:");
		value=sc.next().charAt(0);
		return value;
	}
	
	
	public static void start(Scanner sc, String text) {
		while(true){		
			displayMenu();
			int choice =enterOption(sc);

			switch(choice){
				case 1: 
					String[] sortedPars=sortTextByParagraphLength(text);
					display(sortedPars);
					break;
				case 2: 
					String[] sortedWordsLength=sortEachSentencesByWordLength(text);
					display(sortedWordsLength);
					break;
				case 3: 
					enterChar(sc);
					String[] sortedWordsByRepeatSymbol=sortEachSentencesByRepeatedSymbol(text,'a');
					display(sortedWordsByRepeatSymbol);
					break;	
				case 4: 
					printTextStructure(text);
					break;		
				case 5:
					System.out.println("Exit the application");
					System.exit(0);
				default: System.out.println("Incorrect input!!! Please make your choice again");
			}
		
		}
	}
}
