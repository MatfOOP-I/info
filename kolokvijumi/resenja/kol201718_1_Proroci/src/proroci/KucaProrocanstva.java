package proroci;

import java.util.Scanner;

public class KucaProrocanstva {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TarotKarta t1 = new TarotKarta(0, "Visoka Svestenica", "Italija");
        TarotKarta t2 = new TarotKarta(1, "Lazov", "Otomansko Carstvo");
        TarotKarta t3 = new TarotKarta(-1, "Mag", "Nemacka");

        System.out.println("Unesite ime proroka (jedna rec):");
        String ime = sc.next();
        System.out.println("Unesite broj ostvarenih prorocanstava:");
        int ostvareno = sc.nextInt();
        System.out.println("Unesite ukupan broj prorocanstava:");
        int ukupno = sc.nextInt();
        TarotKarta[] karte = {t1, t2, t3};
        TarotProrok tarotProrok = new TarotProrok(ime, ostvareno, ukupno, karte);
        System.out.println();

        System.out.println("Unesite ime proroka (jedna rec):");
        ime = sc.next();
        System.out.println("Unesite broj ostvarenih prorocanstava:");
        ostvareno = sc.nextInt();
        System.out.println("Unesite ukupan broj prorocanstava:");
        ukupno = sc.nextInt();
        System.out.println("Unesite tip kristala (jedna rec)");
        String tipKristala = sc.next();
        KuglaProrok kuglaProrok =new KuglaProrok(ime, ostvareno, ukupno, tipKristala);
        System.out.println();

        System.out.println(tarotProrok);
        System.out.println("Procenat uspesnosti: " + tarotProrok.getProcenatUspesnosti());

        System.out.println(kuglaProrok);
        System.out.println("Procenat uspesnosti: " + kuglaProrok.getProcenatUspesnosti());
        System.out.println();

        System.out.println(tarotProrok.getIme() + " prorice: " + tarotProrok.proreci(t1));
        System.out.println(kuglaProrok.getIme() + " prorice: " + kuglaProrok.proreci());

        sc.close();
    }
}
