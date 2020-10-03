package v19.Sketcher.v06KontekstniMeni;
import java.util.Observable;
import java.util.LinkedList;
import java.util.Iterator;

class SketchModel extends Observable {
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
