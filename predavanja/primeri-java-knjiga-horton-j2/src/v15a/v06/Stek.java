package v15a.v06;
public class Stek
{ 
    public void push( Object o ) 
    { 
        SimpleStackNode tmp = new SimpleStackNode(); 
        tmp.data = o; 
        tmp.next = top; 
        top = tmp; 
    } 
 
    public Object pop() 
    { 
        if( top == null ) 
            return null; 
 
        SimpleStackNode tmp = top; 
 
        top = top.next; 
        return tmp.data; 
    } 
    SimpleStackNode top; 
} 
 
class SimpleStackNode 
{ 
    Object data; 
    SimpleStackNode next; 
} 