package rs.math.oop1.z070502.prevazilazenje.z04.stek;

public class Stek {

   public Stek() {
      // ovo nikad ne treba da bude direktno izvrseno
   }

   public void push(String elem) {
      System.out.println(
               "Ovako se ne moze raditi sa stekom!!!");
   }

   public String pop() {
      System.out.println(
               "Ovako se ne moze raditi sa stekom!!!");
      return null;
   }

   public int brojElemenata() {
      System.out.println(
               "Ovako se ne moze raditi sa stekom!!!");
      return -1;
   }

}
