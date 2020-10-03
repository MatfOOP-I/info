package rs.math.oop1.z180300.tokoviObrade.z03.folksTransformacija;

import java.util.List;
import static rs.math.oop1.z180300.tokoviObrade.z03.folksTransformacija.Folks.friends;
import java.util.ArrayList;

public class Transform {
    public static void main(final String[] args) {
	{
	    final List<String> uppercaseNames = new ArrayList<String>();

	    for (String ime : friends) {
		uppercaseNames.add(ime.toUpperCase());
	    }

	    System.out.println(uppercaseNames);
	}
	{
	    final List<String> uppercaseNames = new ArrayList<String>();
	    friends.forEach(ime -> uppercaseNames.add(ime.toUpperCase()));
	    System.out.println(uppercaseNames);
	}

	/*
	 * friends.stream() .map(ime -> ime.toUpperCase());
	 */

	System.out.println("//" + "START:TRANSFORM_OUTPUT");

	friends.stream().map(ime -> ime.toUpperCase()).forEach(ime -> System.out.print(ime + " "));
	System.out.println();

	System.out.println("//" + "END:TRANSFORM_OUTPUT");

	System.out.println("//" + "START:NUMBER_OUTPUT");

	friends.stream().map(ime -> ime.length()).forEach(count -> System.out.print(count + " "));

	System.out.println();
	System.out.println("//" + "END:NUMBER_OUTPUT");

	/*
	 * friends.stream() .map(String::toUpperCase);
	 */

	friends.stream().map(String::toUpperCase).forEach(ime -> System.out.println(ime));
    }
}
