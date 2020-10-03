package rs.math.oop1.z080402.solid.z011.losLZivotinje;

import static java.lang.System.out;

public class ZivotinjaPokreni {

   private static int brojNoguLav() {
      return 4;
   }

   private static int brojNoguZmija() {
      return 0;
   }

   private static int brojNoguMis() {
      return 4;
   }

   private static void brojNogu(Zivotinja[] zivotinje) {
      for (Zivotinja z : zivotinje) {
         out.print(z.getIme() + ": ");
         if (z instanceof Lav)
            out.print(brojNoguLav());
         else if (z instanceof Mis)
            out.print(brojNoguMis());
         else if (z instanceof Zmija)
            out.print(brojNoguZmija());
         out.println();
      }
      out.println();
   }

   public static void main(String[] argumenti) {
      Zivotinja[] manjiSkup = {
            new Lav(),
            new Mis(),
            new Zmija()};
      out.println("Број ногу:");
      brojNogu(manjiSkup);
      Zivotinja[] veciSkup = {
            new Lav(),
            new Mis(),
            new Vrabac(), // ???
            new Zmija(),
            new Zivotinja("јазавац")}; // ???
      out.println("Број ногу:");
      brojNogu(veciSkup);
   }

}
