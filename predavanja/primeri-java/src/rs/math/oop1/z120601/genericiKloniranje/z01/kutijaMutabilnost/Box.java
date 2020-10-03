package rs.math.oop1.z120601.genericiKloniranje.z01.kutijaMutabilnost;

public class Box<T>
{
	private T uKutiji;
	
	public Box(T t)
	{
		uKutiji = t;
	}
	
	public void set( T t )
	{
		uKutiji = t;
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