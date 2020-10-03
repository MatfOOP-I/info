package rs.math.oop1.z130200.ispitivanjeTipa.z04.klasaPolje;

import java.lang.reflect.Method;

public class ReflectionTest2
{
	static void showMethods( Object o )
	{
		Class<?> c = o.getClass();
		System.out.println( "----------" + c.getName() + "----------" );
		Method[] metodi = c.getDeclaredMethods();
		//Method[] metodi = c.getMethods();
		for( int i = 0; i < metodi.length; i++ )
		{
			String imeMetoda = metodi[i].getName();
			System.out.println( "Name: " + imeMetoda );
			System.out.println( " Return Type: "
					+ metodi[i].getReturnType().getName() );
			Class<?>[] parametriMetoda = metodi[i].getParameterTypes();
			System.out.print( " Parameter Types:" );
			for( int k = 0; k < parametriMetoda.length; k++ )
			{
				System.out.print( " " + parametriMetoda[k].getName() );
			}
			System.out.println();
		}
	}
	
	public static void main( String[] argumenti )
	{
		showMethods( new Student( "Miloš", "Mitrović" ) );
		showMethods( "miki maus" );
		showMethods( 12 );
		showMethods( 12.45 );
	}
	
}
