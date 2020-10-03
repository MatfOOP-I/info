/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
***/
package rs.math.oop1.z180201.funkcionalniInterfejsi.z01.koriscenje;

public class FunkcionalniInterfejs2
{
	public interface Sample1
	{
		boolean test(int input);
	}

	@FunctionalInterface
	public interface Sample2
	{
		boolean test(int input);
	}
	
	public static void main( final String[] args )
	{
		Sample1 sample1 = input -> {int x = input*input; return x % 2 == 0;};
		Sample2 sample2 = input -> {int y = input*input; return y % 2 == 1;};
		
		System.out.println( sample1.test( 4 ) );
		System.out.println( sample2.test( 4 ) );
		System.out.println( sample1.test( 5 ) );
		System.out.println( sample2.test( 5 ) );
	}
}
