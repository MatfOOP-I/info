package rs.math.oop1.z080402.solid.z012.dobarLZivotinje;

public abstract class Zivotinja {
   private String ime;

   public Zivotinja(String ime) {
      this.ime = ime;
   }

   public String getIme() {
      return ime;
   }

   public abstract int brojNogu();

}
