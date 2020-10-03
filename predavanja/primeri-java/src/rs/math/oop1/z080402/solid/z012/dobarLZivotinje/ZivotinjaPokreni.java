package rs.math.oop1.z080402.solid.z012.dobarLZivotinje;

import static java.lang.System.out;

public class ZivotinjaPokreni {

   private static void brojNogu(Zivotinja[] zivotinje) {
      for (Zivotinja z : zivotinje) {
         out.print(z.getIme() + ": ");
         out.print(z.brojNogu());
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
            new Vrabac(),
            //new Zivotinja("јазавац"),
            new Zmija()};
      out.println("Број ногу:");
      brojNogu(veciSkup);
   }

}
