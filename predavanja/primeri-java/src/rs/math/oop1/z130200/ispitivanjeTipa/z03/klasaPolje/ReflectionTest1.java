package rs.math.oop1.z130200.ispitivanjeTipa.z03.klasaPolje;

import java.util.Scanner;

public class ReflectionTest1 {

   public static void showType(String imeKlase) throws ClassNotFoundException {
      Class<?> klasa = Class.forName(imeKlase);
      String flavor = klasa.isInterface() ? "interface" : "class";
      System.out.println(flavor + " " + imeKlase);
      Class<?> nadklasa = klasa.getSuperclass();
      if (nadklasa != null) {
         System.out.println("extends " + nadklasa.getName());
      }
      Class<?>[] interfaces = klasa.getInterfaces();
      for (int i = 0; i < interfaces.length; ++i) {
         System.out.println("implements " + interfaces[i].getName());
      }
   }

   public static void main(String[] args) {
      Scanner ulaz = new Scanner(System.in);
      System.out.println("Unesite puno ime klase");
      String punoImeKlase = ulaz.next();
      try {
         showType(punoImeKlase);
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
      ulaz.close();
   }

}
