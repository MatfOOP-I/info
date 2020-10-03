package rs.math.oop1.z080402.solid.z08.dobarOZivotinje;

import static java.lang.System.out;

public class ZivotinjaPokreni {

   private static void oglasavanje(Zivotinja[] zivotinje) {
      for (Zivotinja z : zivotinje)
         out.println((z.zvuk()));
      out.println();
   }

   public static void main(String[] argumenti) {
      Zivotinja[] manjiSkup = {
            new Lav(),
            new Mis()};
      oglasavanje(manjiSkup);
      Zivotinja[] veciSkup = {
            new Lav(),
            new Zmija(),
            new Mis()};
      oglasavanje(veciSkup);
   }

}
