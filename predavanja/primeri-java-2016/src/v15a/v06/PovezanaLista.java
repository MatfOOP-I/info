package v15a.v06;
 
import java.util.Vector;
import java.util.Enumeration; 
 
public class PovezanaLista 
{ 
     public PovezanaLista () 
     {
          tekuci = 0;
          dataSet = new Vector ();
     }
 
     public void dodaj( Object o )
     {
          dataSet.addElement(o);
          tekuci = dataSet.size() - 1;
     }
 
     public void ubaci( Object o )
     {
          dataSet.insertElementAt( o, tekuci );
     }
 
     public void izbrisi()
     {
          dataSet.removeElementAt(tekuci);
          if( tekuci >= dataSet.size () )
               tekuci--;
     } 
 
     public void postaviTekuci( Object o )
     {
          dataSet.setElementAt(o,tekuci);
     }
 
     public Object uzmiTekuci()
     {
          return dataSet.elementAt(tekuci);
     }
 
     public void pocetak()
     {
          tekuci = 0;
     }
 
     public boolean sledeci()
     {
          if( ++tekuci < dataSet.size() )
          {
               return true; 
       }
          else 
               return false; 
    } 
 
    public Enumeration elements() 
    { 
          return dataSet.elements(); 
    } 
 
    protected Vector dataSet; 
    protected int tekuci; 
} 