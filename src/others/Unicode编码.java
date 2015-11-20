package others;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Unicode编码 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println((char) Integer.parseInt("A009", 16));//ꀉ
		
		
		String str = "\uA00C\uA003\uA006";
		System.out.println(unicodeToString(str));
	}
	
	
	
	public static String unicodeToString(String str){
		Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
		 Matcher matcher = pattern.matcher(str);
		 char ch; 
		 while (matcher.find()) {			 
			 ch = (char) Integer.parseInt(matcher.group(2), 16);			 
		     str = str.replace(matcher.group(1), ch + "");		     
		}		
         return str;		 
	}

}
