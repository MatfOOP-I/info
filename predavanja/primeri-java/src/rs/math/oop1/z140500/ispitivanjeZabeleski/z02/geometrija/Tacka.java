package rs.math.oop1.z140500.ispitivanjeZabeleski.z02.geometrija;

import java.awt.Graphics;

public class Tacka extends GeometrijskiObjekat implements Prikaz
{
   private int x;
   private int y;
   
   public Tacka(int xKoord, int yKoord, String o)
   {
	   x = xKoord;
	   y = yKoord;
	   setOznaka(o);
   }
    
   public Tacka(final Tacka t)
   {
	   this( t.x, t.y, t.getOznaka());
   }
   
   public Tacka( String o )
   {
	   this(0,0,o);
   }

   public Tacka()
   {
	   this(0,0,"O");
   }

   public void setX( int xKoord)
   {
	   x = xKoord;
   }
   
   public int getX()
   {
	   return x;
   }
   

   public int getY()
   {
	   return y;
   }

   public void setY( int yKoord)
   {
	   y = yKoord;
   }

   public void prikaziSe()
   {
	   System.out.print( this ); 
   }
   
   @Override
   public String toString()
   {
  	 return getOznaka() + "(" + x + "," + y + ")";
   }
   
   public void prikaziSe(Graphics zaslon)
   {
	   zaslon.drawOval(x-2, y-2, 4, 4);
       zaslon.drawString(getOznaka(), x-15, y-15);
   }

   public double rastojanje( Tacka drugaTacka )
   {
	   return Math.sqrt(Math.pow(x-drugaTacka.x, 2)
			   +Math.pow(y-drugaTacka.y, 2));
   }
}
