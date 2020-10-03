package rs.math.oop1.z090301.lokalneUnutrasnje.z01.koriscenje;

public class Spoljasnja
{
	private int j = 42;
	
	@Override
	public String toString()
	{
		final class LokalnaUnutrasnja
		{
			private int i = 12;
			
			@Override
			public String toString()
			{
				return "(unutra) i = " + i + ", j=" + j;
			}
		}
		LokalnaUnutrasnja unutra = new LokalnaUnutrasnja();
		return "Prikaz j(spolja) = " + j
				+ " (unutra)"	+ unutra;
	}
	
	public static void main( String[] args )
	{
		Spoljasnja sp = new Spoljasnja();
		System.out.println( sp );
	}
	
}
