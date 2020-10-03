package rs.math.oop1.z120500.generickiInterfejs.z01.kljucVrednost;

public class OrderedPair<K, V> implements Pair<K, V>
{
	private K key;
	private V value;
	
	public OrderedPair( K key, V value )
	{
		this.key = key;
		this.value = value;
	}
	
	@Override
	public K getKey()
	{
		return key;
	}
	
	@Override
	public V getValue()
	{
		return value;
	}
	
	@Override
	public String toString()
	{
		return "(" + getKey() + "," + getValue() + ")";
	}
}