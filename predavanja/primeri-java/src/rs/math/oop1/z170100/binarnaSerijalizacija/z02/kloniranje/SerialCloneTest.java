package rs.math.oop1.z170100.binarnaSerijalizacija.z02.kloniranje;

import java.io.*;
import java.util.*;

public class SerialCloneTest {
    public static void main(String[] args) {
        Zaposleni harry = new Zaposleni("Marko Markovic", 35000, 1989, 10, 1);
        // clone harry
        Zaposleni harry2 = (Zaposleni) harry.clone();

        // mutate harry
        harry.povecajPlatu(10);

        // now harry and the clone are different
        System.out.println(harry);
        System.out.println(harry2);
    }
}

/**
 * A class whose clone method uses serialization.
 */
class SerialCloneable implements Cloneable, Serializable {
    public Object clone() {
        try {
            // save the object to a byte array
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bout);
            out.writeObject(this);
            out.close();

            // read a clone of the object from the byte array
            ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bin);
            Object ret = in.readObject();
            in.close();

            return ret;
        } catch (Exception e) {
            return null;
        }
    }
}

/**
 * The familiar Zaposleni class, redefined to extend the
 * SerialCloneable class.
 */
class Zaposleni extends SerialCloneable {
    public Zaposleni(String n, double s, int godina, int mesec, int dan) {
        ime = n;
        plata = s;
        GregorianCalendar calendar = new GregorianCalendar(godina, mesec - 1, dan);
        hireDay = calendar.getTime();
    }

    public String getIme() {
        return ime;
    }

    public double getPlata() {
        return plata;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void povecajPlatu(double zaProcenat) {
        double iznosPovisice = plata * zaProcenat / 100;
        plata += iznosPovisice;
    }

    public String toString() {
        return getClass().getName()
                + "[ime=" + ime
                + ",plata=" + plata
                + ",hireDay=" + hireDay
                + "]";
    }

    private String ime;
    private double plata;
    private Date hireDay;
}
 


