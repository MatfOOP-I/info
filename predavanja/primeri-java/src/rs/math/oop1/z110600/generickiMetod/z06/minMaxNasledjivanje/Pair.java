package rs.math.oop1.z110600.generickiMetod.z06.minMaxNasledjivanje;

public class Pair<T>
{
	private T first;
	private T second;

	public Pair()
	{
		first = null;
		second = null;
	}
	
	public Pair( T first, T second )
	{
		this.first = first;
		this.second = second;
	}
	
	public T getFirst()
	{
		return first;
	}
	
	public T getSecond()
	{
		return second;
	}
	
	public void setFirst( T newValue )
	{
		first = newValue;
	}
	
	public void setSecond( T newValue )
	{
		second = newValue;
	}
	
}
