package v15a.v06;
import java.util.Vector; 
 
public class VRed 
    extends Vector 
{ 
    public void put( Object o ) 
    { 
        insertElementAt(o,0); 
    } 
 
    public Object get() 
    { 
        int n = size()-1; 
        Object o = elementAt(n); 
        removeElementAt(n); 
        return o; 
    } 
} 