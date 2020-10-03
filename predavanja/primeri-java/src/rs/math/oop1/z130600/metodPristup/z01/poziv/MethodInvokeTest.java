package rs.math.oop1.z130600.metodPristup.z01.poziv;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInvokeTest {

    public static void main(String[] args) {
        Zaposleni zap1 = new Zaposleni("Mika", 1000);

        Class<?> emp = zap1.getClass();
        try {
            Method[] metodi = emp.getDeclaredMethods();
            Method povisica = null;
            for (Method m : metodi)
                if (m.getName().equals("povecajPlatu"))
                    povisica = m;
            Zaposleni zap2 = new Zaposleni("Pera", 500);
            System.out.println(zap1 + ",\r\n" + zap2);
            Object[] argumentiPoziva = {200.0};
            povisica.invoke(zap2, argumentiPoziva);
            System.out.println(zap1 + ",\r\n" + zap2);
        } catch (IllegalAccessException | SecurityException
                | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
