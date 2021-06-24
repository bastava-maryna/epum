package by.htp.string.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3_2 {
	/*
	 2. Дана строка, содержащая следующий текст (xml-документ):
		<notes>
 			<note id = "1">
 				<to>Вася</to>
 				<from>Света</from>
 				<heading>Напоминание</heading>
 				<body>Позвони мне завтра!</body>
 			</note>
 			<note id = "2">
 				<to>Петя</to>
 				<from>Маша</from>
 				<heading>Важное напоминание</heading>
 				<body/>
 			</note>
		</notes>
	Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип (открывающий
	тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи
	нельзя. 
	 */

	public static void main(String[] args) {
		String test_xml="<notes>\r\n" + 
				" 			<note id = \"1\">\r\n" + 
				" 				<to>Вася</to>\r\n" + 
				" 				<from>Света</from>\r\n" + 
				" 				<heading>Напоминание</heading>\r\n" + 
				" 				<body>Позвони мне завтра!</body>\r\n" + 
				" 			</note>\r\n" + 
				" 			<note id = \"2\">\r\n" + 
				" 				<to>Петя</to>\r\n" + 
				" 				<from>Маша</from>\r\n" + 
				" 				<heading>Важное напоминание</heading>\r\n" + 
				" 				<body/>\r\n" + 
				" 			</note>\r\n" + 
				"		</notes>";
		
		analyzeXML(test_xml);	
		String test="";
		analyzeXML(test);
	}

	
	public static void analyzeXML(String xml_text) {
		if(xml_text.isBlank()||xml_text.isEmpty()) {
			System.out.print("Empty example");
		}else {
			StringBuilder result=new StringBuilder();
			Pattern pt=Pattern.compile("(<[^>]*>*)(?:/?>|(.*)(<[^>]*>))*");
			Matcher mt=pt.matcher(xml_text);
		
			while(mt.find()) {
				if(mt.group(2)!=null) {
					result.append("open tag         - ").append(mt.group(1)).append("\n");
					result.append("tag content      - ").append(mt.group(2)).append("\n");
					result.append("close tag        - ").append(mt.group(3)).append("\n");
				}else {
					if(mt.group(1).charAt(mt.group(1).length()-2)=='/') {
						result.append("tag without body - ").append(mt.group(1)).append("\n");
					}else if(mt.group(1).charAt(1)=='/') {
						result.append("close tag        - ").append(mt.group(1)).append("\n");
					}
					else {
						result.append("open tag         - ").append(mt.group(1)).append("\n");
					}
				}	
			}
		System.out.print(result.toString());
		}
	}
}
