package rs.math.oop1.z080402.solid.z08.dobarOZivotinje;

public abstract class Zivotinja {
   private String ime;

   public Zivotinja(String ime) {
      this.ime = ime;
   }

   public String getIme() {
      return ime;
   }

   public abstract String zvuk();
}
