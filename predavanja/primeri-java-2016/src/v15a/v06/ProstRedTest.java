package v15a.v06;
public class ProstRedTest
{ 
    public static void main( String args[] ) 
    { 
        ProstRed sq = new ProstRed(); 
        String s; 
   
        sq.put( "Ovo" ); 
        sq.put( "ide" ); 
        sq.put( "prvo" ); 
        sq.put( "i" ); 
        sq.put( "ovim" ); 
        sq.put( "redom" ); 
        sq.put( "se" ); 
        sq.put( "stampa" ); 
   
        while( (s = (String)sq.get()) != null ) 
            System.out.println( s ); 
    } 
} 