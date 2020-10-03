package rs.math.oop1.z080402.solid.z05.losOPovrsine;

import java.util.Scanner;

import static java.lang.Math.PI;
import static java.lang.System.in;
import static java.lang.System.out;

public class PokreniPovrsine {

   public static double povrsinaPravougaonika(Pravougaonik p){
      return p.getSirina() * p.getVisina();
   }

   public static double povrsinaKruga(Krug k) {
      return PI * k.getPoluprecnik() * k.getPoluprecnik();
   }

   public static void main(String[] argumenti){
      Scanner sc = new Scanner(in);
      out.printf("Unesite poluprecnik kruga: ");
      double r = sc.nextDouble();
      Krug k = new Krug(r);
      out.printf("Povrsina kruga je: %f\n", povrsinaKruga(k));
      out.printf("Unesite sirinu i visinu pravougaonika: ");
      double a = sc.nextDouble();
      double b = sc.nextDouble();
      Pravougaonik p = new Pravougaonik(a,b);
      out.printf("Povrsina pravougaonika je: %f\n", povrsinaPravougaonika(p));
      sc.close();
   }
}
