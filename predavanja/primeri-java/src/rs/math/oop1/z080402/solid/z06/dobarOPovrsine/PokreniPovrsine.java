package rs.math.oop1.z080402.solid.z06.dobarOPovrsine;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class PokreniPovrsine {

   public static void main(String[] argumenti){
      Scanner sc = new Scanner(in);
      out.printf("Unesite poluprecnik kruga: ");
      double r = sc.nextDouble();
      Krug k = new Krug(r);
      out.printf("Povrsina kruga je: %f\n", k.povrsina());
      out.printf("Unesite sirinu i visinu pravougaonika: ");
      double a = sc.nextDouble();
      double b = sc.nextDouble();
      Pravougaonik p = new Pravougaonik(a,b);
      out.printf("Povrsina pravougaonika je: %f\n\n", p.povrsina());
      sc.close();

      Oblik[] oblici = {k,p};
      for(Oblik o: oblici){
         out.printf("Povrsina oblika je: %f\n", o.povrsina());
      }
   }
}
