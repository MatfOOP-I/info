package rs.math.oop1.z130200.ispitivanjeTipa.z01.klasaPolje;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

interface Interfejs1
{
	int m1();
}

class Klasa1 implements Interfejs1
{
	public int i = 6;
	private int j = 7;
	
	@Override
	public int m1()
	{
		return i;
	}
}

class Klasa2 extends Klasa1 implements Cloneable
{
	private int nestoPametno = 7;
	public int nestoGlupo = 6;
		
	public String proba(int i)
	{
		return "Miki_" + i;
	}

	private String proba2()
	{
		return "Miki";
	}
}

public class Test2
{
	
	public static void main( String[] args )
	{
		Klasa1 p1 = new Klasa2();
		Class<?> k1 = null;
		k1 = p1.getClass();
		//k1 = Klasa1.class;
		try
		{
			k1 = Class.forName("rs.math.oop1.z130200.ispitivanjeTipa.z01.klasaPolje.Klasa2");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		System.out.println( k1.getName() );
		Class<?>[] implementira1 = k1.getInterfaces();
		for( Class<?> i: implementira1)
			System.out.print( i.getName() + " " );
		System.out.println();
	
		Field[] polja1 =  k1.getFields();
		for( Field f: polja1)
			System.out.print( f.getName() + " " );
		System.out.println();
		Method[] metodi1 =  k1.getMethods();
		for( Method m: metodi1)
			System.out.print( m.getName() + " " );
		System.out.println();
		
		System.out.println();
		Class k0 = k1.getSuperclass();
		System.out.println( k0.getName() );
		Class[] implementira0 = k0.getInterfaces();
		for( Class i: implementira0)
			System.out.print( i.getName() + " " );
		Field[] polja0 =  k0.getDeclaredFields();
		System.out.println();
		for( Field f: polja0)
			System.out.print( f.getName() + " " );
		System.out.println();
		Method[] metodi0 =  k0.getDeclaredMethods();
		for( Method m: metodi0)
			System.out.print( m.getName() + " " );
		System.out.println();
		
	}
}