package rs.math.oop1.z070402.pozivMetoda.z06.stekOkviri;

import java.util.*;

/**
 * A program that displays a trace feature of a recursive method call.
 * 
 * @version 1.01 2004-05-10
 * @author Cay Horstmann
 */
public class PokretanjeStackTrace
{
	/**
	 * Computes the factorial of a number
	 * 
	 * @param n
	 *          a nonnegative integer
	 * @return n! = 1 * 2 * . . . * n
	 */
	public static int factorial( int n )
	{
		String s = uvuci( n );
		System.out.println( s + "factorial(" + n + "):" );
		Throwable t = new Throwable();
		StackTraceElement[] frames = t.getStackTrace();
		for (StackTraceElement f : frames)
			System.out.println( s + f );
		int r;
		if (n <= 1)
			r = 1;
		else
			r = n * factorial( n - 1 );
		System.out.println( s + "return " + r );
		return r;
	}

	private static String uvuci( int n )
	{
		String s = "";
		for (int i = 0; i < 10 - n; i++)
			s += "  ";
		return s;
	}
	
	public static void main( String[] args )
	{
		Scanner in = new Scanner( System.in );
		System.out.print( "Enter n: " );
		int n = in.nextInt();
		factorial( n );
	}
}
