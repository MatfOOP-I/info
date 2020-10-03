package rs.math.oop1.z190801.smrtonosniZagrljaj.z01.primer;

public class SmrtonosniZagrljaj
{
	static class Japanac
	{
		private final String ime;
		
		public Japanac( String ime )
		{
			this.ime = ime;
		}
		
		public String getIme()
		{
			return this.ime;
		}
		
		public synchronized void nakloniSe( Japanac kolega )
		{
			System.out.format( "%s: %s" + "  se naklonio!%n",
					this.ime,
					kolega.getIme() );
			kolega.uzvratiNaklon( this );
		}
		
		public synchronized void uzvratiNaklon( Japanac kolega )
		{
			System.out.format( "%s: %s" + " je uzvratio naklon!%n",
					this.ime,
					kolega.getIme() );
		}
	}
	
	public static void main( String[] args )
	{
		final Japanac katsuki = new Japanac( "Tacuaki Katsuki" );
		final Japanac honda = new Japanac( "Keisuke Honda" );
		new Thread( new Runnable()
		{
			public void run()
			{
				katsuki.nakloniSe( honda );
			}
		} ).start();
		new Thread( new Runnable()
		{
			public void run()
			{
				honda.nakloniSe( katsuki );
			}
		} ).start();
	}
}