/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
***/
package rs.math.oop1.z180200.lambdaIzrazi.z05.osobeSortiranje;

public class Person
{
	private final String ime;
	private final int age;
	
	public Person( final String theName, final int theAge )
	{
		ime = theName;
		age = theAge;
	}
	
	public String getIme()
	{
		return ime;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public int ageDifference( final Person drugi )
	{
		return age - drugi.age;
	}
	
	public String toString()
	{
		return String.format( "%s - %d", ime, age );
	}
}
