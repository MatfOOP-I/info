package rs.math.oop1.z080301.uredjenje.z01.zaposleni;

class Zaposleni implements Comparable
{
   private String imePrezime;
   private double plata;

   public Zaposleni( String n, double s )
   {
      imePrezime = n;
      plata = s;
   }

   public String getImePrezime()
   {
      return imePrezime;
   }

   public double getPlata()
   {
      return plata;
   }

   public void povecajPlatu( double zaProcenat )
   {
      double iznosPovisice = plata * zaProcenat / 100;
      plata += iznosPovisice;
   }

   @Override
   public String toString() {
      return "Zaposleni: ime i prezime: " + imePrezime + ", plata: " + plata +".";
   }

   @Override
   public boolean equals(Object o)
   {
      if( o == null )
         return false;
      if( getClass() != o.getClass())
         return false;
      Zaposleni e = (Zaposleni) o;
      return imePrezime.equals(e.imePrezime) && plata==e.plata;
   }

   @Override
   public int hashCode()
   {
      return 3 * imePrezime.hashCode() + 7 * new Double(plata).hashCode();
   }

   @Override
   public int compareTo( Object o )
   {
      if (!(o instanceof Zaposleni))
         return -1;
      Zaposleni drugi = (Zaposleni) o;
      if (plata > drugi.plata)
         return -1;
      if (plata < drugi.plata)
         return 1;
      return imePrezime.compareTo( drugi.imePrezime);
   }
}