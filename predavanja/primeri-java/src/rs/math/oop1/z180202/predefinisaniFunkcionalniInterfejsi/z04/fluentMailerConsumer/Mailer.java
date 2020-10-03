package rs.math.oop1.z180202.predefinisaniFunkcionalniInterfejsi.z04.fluentMailerConsumer;

public class Mailer
{
	public void from( final String address )
	{
		/* ... */ }
		
	public void to( final String address )
	{
		/* ... */ }
		
	public void subject( final String line )
	{
		/* ... */ }
		
	public void body( final String message )
	{
		/* ... */ }
		
	public void send()
	{
		System.out.println( "sending..." );
	}
	
	// ...
	public static void main( final String[] args )
	{
		Mailer mailer = new Mailer();
		mailer.from( "build@agiledeveloper.com" );
		mailer.to( "venkats@agiledeveloper.com" );
		mailer.subject( "build notification" );
		mailer.body( "...your code sucks..." );
		mailer.send();
	}
}
