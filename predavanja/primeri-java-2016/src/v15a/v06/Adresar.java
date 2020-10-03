package v15a.v06;
import java.util.Enumeration; 
 
public class Adresar
    extends PovezanaLista 
{ 
    public static void main( String args[] ) 
        throws java.io.IOException 
    { 
        Adresar imenik = new Adresar(); 

        imenik.dodaj( "Janko Zutic" ); 
        imenik.dodaj( "Vidan Hajdukovic" ); 
        imenik.dodaj( "Mira Vesic" ); 
        imenik.dodaj( "Jovan Bozic" ); 
        imenik.dodaj( "Ana Peric" ); 
 
        imenik.print(); 
 
        imenik.pocetak(); 
        while( !( ((String)imenik.uzmiTekuci()).equals
                 ( "Jovan Bozic" ) ) ) 
        { 
            imenik.sledeci(); 
        } 
        imenik.ubaci("Mirko Saric");
 
        System.out.println(); 
        System.out.println("Imenik nakon ubacivanja Mirka Sarica"); 
        imenik.print(); 
 
        imenik.pocetak(); 
        while( !(((String)imenik.uzmiTekuci()).equals( 
                 "Vidan Hajdukovic" )) ) 
        { 
            imenik.sledeci(); 
        } 
        imenik.izbrisi();
 
        System.out.println(); 
        System.out.println("Imenik Nakon brisanja Vidana Hajdukovica"); 
        imenik.print(); 
        System.in.read(); 
    } 
 
    public void print() 
    { 
        pocetak(); 
        do 
        { 
               System.out.println( uzmiTekuci() ); 
        } while( sledeci() ); 
    } 
} 
 
