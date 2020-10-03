package rs.math.oop1.z080402.solid.z07.losOZivotinje;

import static java.lang.System.out;

public class ZivotinjaPokreni {

   private static void oglasavanje(Zivotinja[] zivotinje) {
      for(Zivotinja z: zivotinje) {
         if(z.getIme().equals("lav"))
            out.println("ROARR!");
         if(z.getIme().equals("mis"))
            out.println(("ciju"));
      }
      out.println();
   }

   public static void main(String[] argumenti) {
      Zivotinja[] manjiSkup = {
            new Zivotinja("lav"),
            new Zivotinja("mis")};
      oglasavanje(manjiSkup);
      Zivotinja[] veciSkup = {
            new Zivotinja("lav"),
            new Zivotinja("zmija"),  // ???
            new Zivotinja("mis")};
      oglasavanje(veciSkup);
   }

}
