package rs.math.oop1.z110600.generickiMetod.z00.par;

public class Pair<K, V>
{
	private K key;
	private V value;
	
	// Generic constructor
	public Pair( K key, V value )
	{
		this.key = key;
		this.value = value;
	}
	
	// Generic methods
	public void setKey( K key )
	{
		this.key = key;
	}
	
	public void setValue( V value )
	{
		this.value = value;
	}
	
	public K getKey()
	{
		return key;
	}
	
	public V getValue()
	{
		return value;
	}
	
	@Override
	public String toString()
	{
		return "[key:" + key + ", value:" + value + "]";
	}
}
