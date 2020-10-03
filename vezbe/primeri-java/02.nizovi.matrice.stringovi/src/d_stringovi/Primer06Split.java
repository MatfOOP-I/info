package d_stringovi;

import java.util.Arrays;

/**
 * Primer ilustruje jednostavnu primenu metoda split()
 * koji razbija String na niz podstringova
 * a za razdvajanje koristi zadati string.
 */
public class Primer06Split {
    public static void main(String[] args) {
        String recenica = "petar petrovic 123/17";
        System.out.println(recenica);
        // razdvajanje vrsimo jednim razmakom
        String[] reci = recenica.split(" ");
        System.out.println(Arrays.toString(reci));
        System.out.println();

        recenica = "marko, markovic, 101/17, 2mnva";
        System.out.println(recenica);
        // razdvajanje vrsimo niskom ", " (zapeta za kojom sledi razmak)
        reci = recenica.split(", ");
        System.out.println(Arrays.toString(reci));
        System.out.println();

        recenica = "oop;programiranje 1;programiranje 2";
        System.out.println(recenica);
        // razdvajanje vrsimo karakterom ';'
        reci = recenica.split(";");
        System.out.println(Arrays.toString(reci));
    }
}
