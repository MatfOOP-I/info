package rs.math.oop1.z120500.generickiInterfejs.z01.kljucVrednost;

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
	
	@Override
	public String toString()
	{
		return "[" + uKutiji + "]";
	}
	
}