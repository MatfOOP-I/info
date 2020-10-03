package rs.math.oop1.z110600.generickiMetod.z02.minMaxDouble;


public class StaticInnerClassTest
{
	public static void main( String[] args )
	{
		double[] d = new double[6];
		for (int i = 0; i < d.length; i++)
			d[i] = 100 * Math.random();
		for (double br : d)
			System.out.print( br + " " );
		System.out.println();
		ArrayAlg.Pair p = ArrayAlg.minmax( d );
		System.out.println( "min = " + p.getFirst() );
		System.out.println( "max = " + p.getSecond() );
	}
}

