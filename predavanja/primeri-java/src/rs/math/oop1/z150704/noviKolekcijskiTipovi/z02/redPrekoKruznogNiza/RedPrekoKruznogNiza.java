package rs.math.oop1.z150704.noviKolekcijskiTipovi.z02.redPrekoKruznogNiza;

import java.util.*;

/**
 * A first-in, first-out bounded collection.
 */
public class RedPrekoKruznogNiza<E> extends AbstractQueue<E>
{
	private E[] elements;
	private int head;
	private int tail;
	private int count;
	private int indikatorPromeneStrukture;
	

	private class QueueIterator implements Iterator<E>
	{
		private int offset;
		private int indikatorPromene;

		public QueueIterator()
		{
			indikatorPromene = indikatorPromeneStrukture;
		}
		
		public E next()
		{
			if (!hasNext())
				throw new NoSuchElementException();
			E r = (E) elements[(head + offset) % elements.length];
			offset++;
			return r;
		}
		
		public boolean hasNext()
		{
			if (indikatorPromeneStrukture != indikatorPromene)
				throw new ConcurrentModificationException();
			return offset < count;
		}
		
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
		
	}
	
	@SuppressWarnings( "unchecked" )
	public RedPrekoKruznogNiza( int capacity )
	{
		elements = (E[]) new Object[capacity];
		count = 0;
		head = 0;
		tail = 0;
	}
	
	public boolean offer( E newElement )
	{
		assert newElement != null;
		if (count < elements.length)
		{
			elements[tail] = newElement;
			tail = (tail + 1) % elements.length;
			count++;
			indikatorPromeneStrukture++;
			return true;
		}
		else
			return false;
	}
	
	public E poll()
	{
		if (count == 0)
			return null;
		E r = peek();
		head = (head + 1) % elements.length;
		count--;
		indikatorPromeneStrukture++;
		return r;
	}
	
	public E peek()
	{
		if (count == 0)
			return null;
		return (E) elements[head];
	}
	
	public int size()
	{
		return count;
	}
	
	public Iterator<E> iterator()
	{
		return new QueueIterator();
	}
	
}

