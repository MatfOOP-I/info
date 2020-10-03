package rs.math.oop1.z110600.generickiMetod.z02.minMaxDouble;

public class ArrayAlg
{
	public static class Pair
	{
		private double first;
		private double second;
		
		public Pair( double f, double s )
		{
			first = f;
			second = s;
		}
		
		public double getFirst()
		{
			return first;
		}
		
		public double getSecond()
		{
			return second;
		}
		
	}
	
	public static Pair minmax( double[] values )
	{
		double min = values[0];
		double max = values[0];
		for (int i=1;i<values.length; i++)
		{
			double v = values[i];
			if (min > v)
				min = v;
			if (max < v)
				max = v;
		}
		return new Pair( min, max );
	}
}

