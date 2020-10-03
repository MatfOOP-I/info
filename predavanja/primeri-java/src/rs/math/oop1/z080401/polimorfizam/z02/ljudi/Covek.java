package rs.math.oop1.z080401.polimorfizam.z02.ljudi;

class Covek
{
   String ime;
   String prezime;
   
   void predstaviSe()
   {
     System.out.println("Covek: " + ime + " " + prezime + "."
    		 + jeDobar() );
   }
   
   boolean jeDobar()
   {
  	 return true;
   }
}