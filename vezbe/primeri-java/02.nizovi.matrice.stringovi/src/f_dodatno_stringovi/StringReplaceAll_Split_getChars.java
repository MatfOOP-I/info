package f_dodatno_stringovi;

import java.util.Arrays;

public class StringReplaceAll_Split_getChars {
    public static void main(String[] args) {

        // Metod replaceAll() radi isto sto i metod replace(), samo sto podstring koji se
        // zamenjuje moze biti zadat koristeci naprednije tehnike (tj. regularne izraze)
        String zameni = "u\tsvetu   postoji\n\tjedno    carstvo!!";
        System.out.println("\n" + zameni + "\n");
        // visestruke pojave belina (razmaka, tabulatora, novih redova)
        // zamenjuje praznim stringom
        System.out.println("visestruke beline -> prazan string:");
        System.out.println(zameni.replaceAll("\\s+", ""));

        // brojanje samoglasnika:
        // sve sto nije samoglasnik (ukljucujuci i karaktere koji nisu slova)
        // zamenjuje se praznim stringom, tj. brise
        // tako dobijeni string sasdrzi jedino samoglasnike pa je njegova duzina
        // trazeni broj samoglasnika
        String samoglasnici = zameni.replaceAll("[^aeiou]", "");
        System.out.println("\nsamoglasnika ima " + samoglasnici.length());

        // brojanje suglasnika:
        // sve sto nije suglasnik (ukljucujuci i karaktere koji nisu slova)
        // zamenjuje se praznim stringom
        String suglasnici = zameni.replaceAll("[^a-z]|[aeiou]", "");
        System.out.println("suglasnika ima " + suglasnici.length());
        System.out.println();

        // Metod split():
        String recenica = "Ucimo da    programiramo\nnaprednije    tehnike\tu Javi";
        System.out.println(recenica);
        // razdvajamo visestrukim belinama (bilo kojim)
        String[] reci = recenica.split("\\s+");
        System.out.println("izdvojene reci: " + Arrays.toString(reci));
        System.out.println();

        recenica = "Ucimo regularne izraze, metod split() i zadajemo razne parametre.";
        System.out.println(recenica);
        // za razdvajanje koristimo tacku, razmak ili zapetu
        // kako ima dva delimitera jedan do drugog: zapeta i razmak posle "izraze"
        // izmedju njih ce se, kao izdvojeni podstring, naci prazan string
        reci = recenica.split("[. ,]"); // delimiter je tacka, razmak ili zapeta
        System.out.println("izdvojene reci: " + Arrays.toString(reci));
        // popravljeno, da ne izdvaja prazne stringove
        reci = recenica.split(",? |\\."); // opciona zapeta za kojom sledi razmak ili tacka
        System.out.println("izdvojene reci: " + Arrays.toString(reci));
        System.out.println();


        // Metod getChars():
        // Pravljenje niza karaktera od dela Stringa
        String brzalica = "na vrh brda vrba mrda";
        System.out.println("brzalica: " + brzalica);
        char slova[] = new char[8];
        /* Metodom getChars() kopira se sekvenca karatkera iz stringa u zadati karakterski niz.
         * Iz stringa brzalica izdvajamo karaktere pocev od pozicije 3 (prvi argument),
         * a zavrsno sa pozicijom 10 (drugi argument-1),
         * i smestamo ih u niz slova (treci argument),
         * koji je prethodno definisan tako da bude dovoljne duzine
         * Karakteri se upisuju u niz pocev od pozicije 0 (cetvrti argument).
         */
        brzalica.getChars(3, 11, slova, 0);
        System.out.println("neka slova iz brzalice: " + Arrays.toString(slova));

        // Mozemo praviti String i od dela niza karaktera
        String rec = new String(slova, 4, 4);
        System.out.println("rec iz brzalice: " + rec);
    }
}
