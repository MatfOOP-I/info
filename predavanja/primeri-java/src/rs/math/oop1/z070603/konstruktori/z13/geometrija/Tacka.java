package rs.math.oop1.z070603.konstruktori.z13.geometrija;

public class Tacka extends GeometrijskiObjekat
{
   private int x;
   private int y;
   
   public Tacka(int xKoord, int yKoord, String o)
   {
	   super(o);
	   x = xKoord;
	   y = yKoord;
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
   
   public void setY( int yKoord)
   {
	   y = yKoord;
   }
   
   @Override
   public String toString()
   {
  	 return getOznaka() + "(" + x + "," + y + ")";
   }

   public double rastojanje( Tacka drugaTacka )
   {
	   return Math.sqrt(Math.pow(x-drugaTacka.x, 2)
			   +Math.pow(y-drugaTacka.y, 2));
   }
}
