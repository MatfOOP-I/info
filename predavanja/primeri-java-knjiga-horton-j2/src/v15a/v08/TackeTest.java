package v15a.v08;
import java.awt.*; 
import java.util.Hashtable; 
import java.util.Enumeration; 
import java.util.Random; 
 
public class TackeTest extends Frame 
{ 
    Hashtable tablica; 
    Random sluc; 

    public TackeTest() 
    { 
        Point p; 
        TackeInfo pi; 
        int x; 
        int y; 
        Color boja[] = { Color.green, Color.blue,
              Color.red, Color.black }; 
 
        tablica = new Hashtable( 23, 2.0f ); 
        sluc = new Random(); 
 
        for( int i = 0; i < 50; i++ ) 
        { 
            x = Math.abs( sluc.nextInt() % 200 ); 
            y = Math.abs( sluc.nextInt() % 200 ); 
            p = new Point( x, y ); 
            pi = new TackeInfo( boja[ i%4 ],
                 (sluc.nextInt() % 20) + 1 ); 
            tablica.put( p, pi ); 
        } 
 
        resize( 200, 200 ); 
    } 
 
    public void paint( Graphics g ) 
    { 
        Point p; 
        TackeInfo pi; 
        Enumeration e = tablica.keys(); 
 
        while( e.hasMoreElements() )
       { 
            p = (Point)e.nextElement(); 
            pi = (TackeInfo)tablica.get( p ); 
 
            g.setColor( pi.getColor() ); 
            g.drawOval( p.x, p.y, pi.getSize(), 
                        pi.getSize() ); 
        } 
    } 
 
    public static void main( String args[] ) 
    { 
        TackeTest p = new TackeTest(); 
        p.show(); 
    } 
} 
 
   class TackeInfo 
{ 
    Color boja; 
    int velicina; 

    public TackeInfo( Color boja, int velicina ) 
    { 
        this.boja = boja; 
        this.velicina = velicina; 
    } 
 
    public Color getColor() 
    { 
        return boja; 
    } 
 
    public int getSize() 
    { 
        return velicina; 
    } 
 
    public void setColor( Color boja ) 
    { 
        this.boja = boja; 
    } 
 
    public void setSize( int velicina ) 
    {  
 
     this.velicina = velicina; 
    } 
   
} 
 

