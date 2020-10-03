package rs.math.oop1.z070601.inicijalizacioniBlokPrimerka.z01.tacke;

public class Tacka 
{
   int x = 1;
   int y = 1;
   String oznaka = "O";
   
  
   {
  	 x = (int)(Math.random()*100);
  	 y = (int)(Math.random()*100);
   }

   void setX( int xKoord)
   {
	   x = xKoord;
   }
   
   void setY( int yKoord)
   {
	   y = yKoord;
   }

   void prikaziSe()
   {
	   System.out.print(oznaka + ":(" + x + "," + y + ")" ); 
   }

 }
