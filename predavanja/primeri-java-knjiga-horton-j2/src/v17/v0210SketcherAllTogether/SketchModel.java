package v17.v0210SketcherAllTogether;
import java.util.Observable;
import java.util.LinkedList;
import java.util.Iterator;
import java.io.Serializable;
import java.awt.Rectangle;

class SketchModel extends Observable implements Serializable
{
	protected LinkedList elementList = new LinkedList();

	// Get the rectangle enclosing an entire sketch
	Rectangle getModelExtent()
	{
		Iterator elements = getIterator();
		Rectangle rect = new Rectangle(); // An empty rectangle
		Element element; // Stores an element
		while (elements.hasNext())
		{ // Go through the list
			element = (Element) elements.next(); // Get the next element
			rect.add(element.getBounds()); // Expand union
		}
		if (rect.width == 0) // Make sure width
			rect.width = 1; // is non-zero
		if (rect.height == 0) // and the height
			rect.height = 1;
		return rect;
	}

	public boolean remove(Element element)
	{
		boolean removed = elementList.remove(element);
		if (removed)
		{
			setChanged();
			notifyObservers(element.getBounds());
		}

		return removed;
	}

	public void add(Element element)
	{
		elementList.add(element);
		setChanged();
		notifyObservers(element.getBounds());
	}

	public Iterator getIterator()
	{
		return elementList.listIterator();
	}

}
