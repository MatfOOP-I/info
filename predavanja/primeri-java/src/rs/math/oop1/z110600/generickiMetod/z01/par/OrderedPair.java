package rs.math.oop1.z110600.generickiMetod.z01.par;

public class OrderedPair<K extends Comparable<K>, V> implements Pair<K, V>, Comparable<Pair<K,V>>
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
		return "(" + getKey() + "," + getValue()  +")";
	}

	@Override
	public int compareTo(Pair<K, V> o) {
		return getKey().compareTo(o.getKey());
	}
}