package rs.math.oop1.z080201.interfejsi.z06.radoznalost;

public class Naucnik implements Radoznao {
   private String ime;

   public Naucnik(String ime) {
      this.ime = ime;
   }

   public String getIme() {
      return ime;
   }

   @Override
   public void pita() {
      System.out.println("'" + ime +"' se bavi pitanjima koja se odnose na...");
   }

   @Override
   public void interesujeSe() {
      System.out.println("'" + ime +"' se interesuje za...");
   }
}
