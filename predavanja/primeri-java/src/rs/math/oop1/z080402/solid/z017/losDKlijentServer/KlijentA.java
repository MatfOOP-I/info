package rs.math.oop1.z080402.solid.z017.losDKlijentServer;

import static java.lang.System.out;

public class KlijentA {
   ServisB servis = new ServisB();

   public void uradiNesto() {
      String info = servis.getInfo();
      out.println("KlijentA - " + info);
   }
}
