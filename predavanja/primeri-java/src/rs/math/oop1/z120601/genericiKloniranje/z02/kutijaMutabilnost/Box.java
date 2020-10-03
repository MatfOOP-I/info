package rs.math.oop1.z120601.genericiKloniranje.z02.kutijaMutabilnost;

public class Box<T extends KloniraSe<T>>
{
	private T uKutiji;
	
	public Box( T t )
	{
		try
		{
			uKutiji = t.clone();
		}
		catch (CloneNotSupportedException e)
		{
			System.out.println( e );
		}
	}
	
	public void set( T t )
	{
		try
		{
			uKutiji = t.clone();
		}
		catch (CloneNotSupportedException e)
		{
			System.out.println( e );
		}
	}
	
	public T get()
	{
		return uKutiji;
	}
	
	public String toString()
	{
		return "[" + uKutiji + "]";
	}
	
}