package v20.Sketcher.v02CuvanjeSkice;
import java.util.Observable;
import java.util.LinkedList;
import java.util.Iterator;
import java.io.Serializable;

class SketchModel extends Observable implements Serializable {
  public boolean remove(Element element) {
    boolean removed = elementList.remove(element);
    if(removed) {
      setChanged();
      notifyObservers(element.getBounds());
    }

    return removed;
  }
  
  public void add(Element element) {
    elementList.add(element);
    setChanged();
    notifyObservers(element.getBounds());
  }

  public Iterator getIterator() {
    return elementList.listIterator();  
  }

  protected LinkedList elementList = new LinkedList();
}
