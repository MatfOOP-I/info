package f_dodatno_stringovi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// NAPOMENA:
// Regularni izrazi (na dalje regexi) su izuzetno zabavan alat koji je u stanju  da
// prepozna razne sablone u tekstu.
// Na primer, pronaci sve email adrese u tekstu, pronaci sve reci
// koje pocinju sa veliki E i sadrze barem jednu cifru.
// 
// Na studijama na Matfu se regexi izucavaju na kursevi Leksicka analiza (R smer)
// i Prevodjenje programskih jezika (I smer) gde se prikazuje i teorijska osnova
// na koju se regexi oslanjaju.
// 
// Primer koji sledi ilustruje koriscenje regularnih izraza koristeci
// javine klase Matcher, Pattern itd.
// 
// Studenti se pre svega ohrabruju da pogledaju sledece linkove:
// * tutorial:
// 		https://regexone.com/
// * mini tutorial za Javu:
//  	https://www.youtube.com/watch?v=qKOdmGxOWqQ
// * online regex tester (fantastican Veb sajt)
// 		http://regexr.com/
// * Google :D
public class RegularniIzrazi01 {

	// Pretpostavimo da zelimo da pronadjemo pojavljivanja svih brojeva u tekstu.
	public static void main(String[] args) {
		String data = getData();
		showOnlyNumbers(data);
	}

	static void showOnlyNumbers(String data) {
		// [0-9]+ 	-> 1 ili vise cifri
		// (...)?   -> 0 ili 1 pojavljivanja sablona unutar zagrade
		// [.] 		-> pojavljivanja karaktera .
		// [0-9]* 	-> 0 ili vise cifri
		Pattern pattern = Pattern.compile("[0-9]+([.][0-9]*)?");
		Matcher matcher = pattern.matcher(data);
		while (matcher.find())
			System.out.println(matcher.group());
	}

	static String getData() {
		return " Lorem ipsum 1 dolor sit amet, consectetur 2 adipiscing elit. "
				+ "Nunc malesuada turpis tellus, vitae 3.14159265359 maximus purus auctor eu. "
				+ "Sed tempor dolor orci, et hendrerit 4.14 eros porttitor vel. "
				+ "Proin viverra turpis vitae 5.111235123eros vehicula imperdiet sit amet id erat. "
				+ "Fusce sed rutrum elit. Cras 6.11 dui ligula, dictum ac commodo eget, "
				+ "scelerisque et lectus. Vestibulum 7.1 porta molestie fermentum. "
				+ "Class aptent taciti sociosqu ad litora torquent per conubia nostra, "
				+ "per inceptos himenaeos. Praesent et enim sem. Proin condimentum viverra "
				+ "ligula eget interdum. Donec eget 8 tortor porta, eleifend mauris nec, laoreet erat. "
				+ "Nunc ultrices tortor vitae malesuada 9 iaculis. ";
	}

}
