package f_dodatno_stringovi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Program izlistava sve validne email adrese.
public class RegularniIzrazi02 {

	public static void main(String[] args) {
		String data = getData();
		showValidEmails(data);
	}

	static void showValidEmails(String data) {
		// [a-zA-Z]  				-> zahtevamo da pocinje malim ili velikim slovom
		// [a-zA-Z0-9]*  			-> potom sledi 0 ili vise alfanumerickih karaktera
		// @ 						-> potom sledi karakter @
		// [a-zA-Z]+[.] 			-> sabloni poput: "abc.cdf.", "aaa.bbb.ccc.ddd." itd (nekoliko slova pa tacka)
		// (...)+ 					-> ponavlja obrazac unutar zagrada 1 ili vise puta
		// ((edu)|(rs)|(com)|(org))	-> dozvoljena je ili rec edu ili rec rs ili rec com ili org
		Pattern pattern = Pattern.compile("[a-zA-Z][a-zA-Z0-9]*@([a-zA-Z]+[.])+((edu)|(rs)|(com)|(org))");
		Matcher matcher = pattern.matcher(data);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

	static String getData() {
		return    "programming@gmail.com "
				+ "pera@outlook.com "
				+ "zika@matf.bg.ac.rs "
				+ "java@oracle.com "
				+ "fun.programming@regex.edu";
	}

}
