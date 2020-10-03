package rs.math.oop1.z080402.solid.z019.dobarDKlijentServerPrekoSetera;

import static java.lang.System.out;

public class KlijentA implements Klijent {
   private Servis servis;

   public KlijentA( Servis servis) {
      this.servis = servis;
   }

   public void setServis(Servis servis) {
      this.servis = servis;
   }

   @Override
   public void uradiNesto() {
      String info = servis.getInfo();
      out.println("KlijentA - " + info);
   }
}
