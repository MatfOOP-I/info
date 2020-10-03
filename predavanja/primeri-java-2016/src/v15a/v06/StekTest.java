package v15a.v06;
public class StekTest 
{ 
    public static void main( String args[] ) 
    { 
        Stek ss = new Stek(); 
        String s; 
 
        ss.push( "Ovo" ); 
        ss.push( "ulazi" ); 
        ss.push( "u" ); 
        ss.push( "stek i" ); 
        ss.push( "vraca se" ); 
        ss.push( "obrnutim redom" ); 
 
        while( (s = (String)ss.pop()) != null ) 
            System.out.println( s ); 
    } 
}