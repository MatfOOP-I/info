package rs.math.oop1.z070403.metodiKlasni.z04.statickiUvozRastojanjeObim;

public class PokretanjeRastojanje1 {

   static double rastojanje(double x1, double y1, double x2, double y2) {
      return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
   }

   static double obimKruga(double poluprecnik) {
      return 2 * poluprecnik * Math.PI;
   }

   public static void main(String[] args) {
      java.util.Scanner ulaz = new java.util.Scanner(System.in);
      System.out.println("Koordinate prve tacke");
      double x1 = ulaz.nextDouble();
      double y1 = ulaz.nextDouble();
      System.out.println("Koordinate druge tacke");
      double x2 = ulaz.nextDouble();
      double y2 = ulaz.nextDouble();
      System.out.println(rastojanje(x1, y1, x2, y2));
      System.out.println(obimKruga(rastojanje(x1, y1, x2, y2) / 2));
      ulaz.close();

   }

}
