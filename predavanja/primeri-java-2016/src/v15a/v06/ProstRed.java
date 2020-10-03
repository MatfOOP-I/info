package v15a.v06;
public class ProstRed 
{ 
    public ProstRed() 
    { 
        head = tail = null; 
    } 
 
    public void put( Object o ) 
    { 
        SimpleQNode tmp = new SimpleQNode(); 
        tmp.data = o; 
        if( head == null ) 
            head = tmp; 
        else 
            tail.next = tmp; 
 
        tail = tmp; 
    } 
 
    public Object get() 
    { 
        if( head == null ) 
            return null; 
 
        Object o = head.data; 
 
        if( head == tail ) 
            head = tail = null; 
        else 
            head = head.next; 
 
        return o; 
    } 
 
    SimpleQNode head; 
    SimpleQNode tail; 
} 
 
class SimpleQNode 
{ 
    Object data; 
    SimpleQNode next; 
} 