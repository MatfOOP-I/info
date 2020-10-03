package d_stringovi;

import java.util.Scanner;

/**
 * Program prikazuje kako mozemo vrsiti modifikaciju Stringa.
 */
public class Primer03Imutabilnost {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite liniju teksta:");
        String t = sc.nextLine();

        String ms = uMalaSlova(t);
        // U klasi String postoji metod toLowerCase() koji za dati string
        // vraca novi u kome su velika slova prevedena u mala,
        // a ostali karakteri su nepromenjeni.
        // U ovom primeru nije koriscen radi ilustracije iteriranja kroz string.
        System.out.println("Mala slova: " + ms);

        // Metod toUpperCase() radi suprotno, prevodi mala u velika slova.
        String vs = t.toUpperCase();
        // Metodom replace() zamenjujemo svaku pojavu podstringa datim stringom
        // (moze i svaku pojavu jednog karaktera da zameni drugim karakterom)
        String vsBezBelina = vs.replace(" ", "");
        System.out.println("Velika slova bez belina: " + vsBezBelina);

        // Uneta linija teksta je ostala nepromenjena
        System.out.println("Uneta linija: " + t);
        sc.close();
    }

    static String uMalaSlova(String t) {
        // Stringovi su imutabilni (nepromenljivi)
        // tako da cemo transformaciju izvrsiti
        // nad nizom karaktera koji cemo posle
        // vratiti kao String
        char[] tmp = t.toCharArray();
        for (int i = 0; i < tmp.length; i++)
            if (Character.isUpperCase(tmp[i]))
                tmp[i] = Character.toLowerCase(tmp[i]);

        // ------------
        // Prvi nacin
        // ------------
        // Metod valueOf() od promenljive koju prima kao argument
        // vraca njenu stringovnu reprezentaciju.
        // Radi za vecinu primitivnih tipova podataka, nizove karaktera i objekte.
        // String.valueOf(true) se izracunava u "true"
        // String.valueOf(5.5) se izracunava u "5.5"
        return String.valueOf(tmp);

        // ------------
        // Drugi nacin
        // ------------
        // Pravim objekat (string) od niza karaktera.
        // return new String(tmp);
    }
}