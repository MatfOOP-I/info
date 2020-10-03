package rs.math.oop1.z130500.poljePristup.z01.citanjePisanje;

import java.lang.reflect.Field;

public class FieldGetSetTest
{
	public static void main( String[] argumenti )
	{
		Zaposleni prvi = new Zaposleni( "Miki Maus", 15 );
		Zaposleni drugi = new Zaposleni( "Paja Patak", 16 );
		
		Class<?> klasa = prvi.getClass();
		Field prvoDeklarisanoPolje = klasa.getDeclaredFields()[0];
		System.out.println( prvoDeklarisanoPolje.getType() );
		prvoDeklarisanoPolje.setAccessible( true );
		try
		{
			System.out.println( prvi + ",\r\n" + drugi );
			System.out.println( prvoDeklarisanoPolje.get( prvi ) );
			System.out.println( prvoDeklarisanoPolje.get( drugi ) );
			prvoDeklarisanoPolje.set( prvi, "Mini Maus" );
			System.out.println( prvi + ",\r\n" + drugi );
		}
		catch (IllegalArgumentException | IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
