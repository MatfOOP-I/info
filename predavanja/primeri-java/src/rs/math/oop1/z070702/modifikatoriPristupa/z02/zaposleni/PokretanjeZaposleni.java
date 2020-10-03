package rs.math.oop1.z070702.modifikatoriPristupa.z02.zaposleni;

import java.util.Date;
import java.util.GregorianCalendar;

class Zaposleni {
   private String ime;
   private double plata;
   private Date hireDay;

   public Zaposleni(String n, double s, int godina, int mesec, int dan) {
      ime = n;
      plata = s;
      GregorianCalendar calendar = new GregorianCalendar(godina, mesec - 1, dan);
      // GregorianCalendar uses 0 for January
      hireDay = calendar.getTime();
   }

   public String getIme() {

      return ime;
   }

   public double getPlata() {
      return plata;
   }

   public Date getHireDay() {
      return hireDay;
   }

   public void povecajPlatu(double zaProcenat) {
      double iznosPovisice = plata * zaProcenat / 100;
      plata += iznosPovisice;
   }
}

public class PokretanjeZaposleni {
   public static void main(String[] args) {
      // fill the osoblje array with three Zaposleni objects
      Zaposleni[] osoblje = new Zaposleni[3];

      osoblje[0] = new Zaposleni("Janko Jankovic", 75000, 2007, 12, 15);
      osoblje[1] = new Zaposleni("Marko Markovic", 50000, 2009, 10, 1);
      osoblje[2] = new Zaposleni("Tony Tester", 40000, 2010, 3, 15);

      System.out.println("Before plata iznosPovisice");
      for (Zaposleni e : osoblje) {
         System.out.println("ime=" + e.getIme() + ",plata=" + e.getPlata()
               + ",hireDay=" + e.getHireDay());
      }

      for (Zaposleni e : osoblje)
         e.povecajPlatu(5);

      System.out.println("After plata iznosPovisice");
      for (Zaposleni e : osoblje) {
         System.out.println("ime=" + e.getIme() + ",plata=" + e.getPlata()
               + ",hireDay=" + e.getHireDay());
      }
   }
}
