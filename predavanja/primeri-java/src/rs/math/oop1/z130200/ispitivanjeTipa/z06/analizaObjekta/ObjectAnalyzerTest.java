package rs.math.oop1.z130200.ispitivanjeTipa.z06.analizaObjekta;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


class ObjectAnalyzer {
   private PovezanaLista<Object> obuhvaceni = new PovezanaLista<Object>();

   public String prikaz(Object obj) {
      if (obj == null)
         return "null";
      if (obuhvaceni.contains(obj))
         return "...";
      obuhvaceni.addItem(obj);
      Class<?> cl = obj.getClass();
      if (cl == String.class)
         return (String) obj;
      if (cl.isArray()) {
         String r = cl.getComponentType() + "[]{";
         for (int i = 0; i < Array.getLength(obj); i++) {
            if (i > 0)
               r += ",";
            Object val = Array.get(obj, i);
            if (cl.getComponentType().isPrimitive())
               r += val;
            else
               r += prikaz(val);
         }
         return r + "}";
      }
      String r = cl.getName();
      // inspect the fields of this class and all superclasses
      do {
         r += "[";
         Field[] fields = cl.getDeclaredFields();
         AccessibleObject.setAccessible(fields, true);
         // get the names and values of all fields
         for (Field f : fields) {
            if (!Modifier.isStatic(f.getModifiers())) {
               if (!r.endsWith("["))
                  r += ",";
               r += f.getName() + "=";
               try {
                  Class<?> t = f.getType();
                  Object val = f.get(obj);
                  if (t.isPrimitive())
                     r += val;
                  else
                     r += prikaz(val);
               } catch (Exception e) {
                  e.printStackTrace();
               }
            }
         }
         r += "]";
         cl = cl.getSuperclass();
      } while (cl != null);

      return r;
   }
}

public class ObjectAnalyzerTest {
   public static void main(String[] args) {
      int x = 5;
      System.out.println(new ObjectAnalyzer().prikaz(x));

      double x1 = 5.6;
      System.out.println(new ObjectAnalyzer().prikaz(x1));

      String s = "Marko Markovic";
      System.out.println(new ObjectAnalyzer().prikaz(s));

      Zaposleni pera = new Zaposleni("Janko Jankovic", 8000);
      System.out.println(new ObjectAnalyzer().prikaz(pera));

      Manager mika = new Manager("Mika Petrovic", 8000, 4000);
      System.out.println(new ObjectAnalyzer().prikaz(mika));

      Pair<String> mz = new Pair<>("mika", "zika");
      System.out.println(new ObjectAnalyzer().prikaz(mz));

      Pair<Zaposleni> pm = new Pair<>(pera, mika);
      System.out.println(new ObjectAnalyzer().prikaz(pm));

      int[] niz = {1, 2, 3, 4, 5};
      System.out.println(new ObjectAnalyzer().prikaz(niz));

      Manager m = new Manager("Petar Petrоvic", 10_100, 0);
      m.setBonus(300);
      System.out.println(new ObjectAnalyzer().prikaz(m));
      m.setBonus(700);
      System.out.println(new ObjectAnalyzer().prikaz(m));

      Zaposleni[] osobe = {
            new Zaposleni("Zarko Zarkovic", 20_100),
            m,
            pera,
            m
      };
      System.out.println(new ObjectAnalyzer().prikaz(osobe));

      PovezanaLista<String> ll1 = new PovezanaLista<String>("baba");
      ll1.addItem("zaba");
      ll1.addItem("mika");
      ll1.addItem("zika");
      System.out.println(new ObjectAnalyzer().prikaz(ll1));

   }
}
