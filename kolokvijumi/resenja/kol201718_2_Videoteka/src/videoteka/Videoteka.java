package videoteka;

import java.util.Scanner;

public class Videoteka {

    public static void main(String[] args) {
        String[] z1 = {"adventure", "comedy", "sci-fi"};
        String[] z2 = {"adventure", "family", "fantasy"};
        String[] z3 = {"drama", "romance"};
        String[] z4 = {"adventure", "drama", "fantasy"};

        Film[] filmovi = {new Film("Povratak u buducnost", z1, 8.5),
                          new Film("Hari Poter i zatvorenik iz Askabana", z2, 8.0),
                          new Film("Titanik", z3, 7.8),
                          new Film("Gospodar prstenova: Dve kule", z4, 9.3)};

        for (Film f: filmovi) {
            System.out.println(f);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite ime:");
        String ime = sc.next();
        System.out.println("Unesite omiljeni zanr:");
        String zanr = sc.next();
        RegularanClan rc = new RegularanClan(ime, zanr);
        System.out.println("Unesite ime:");
        ime = sc.next();
        System.out.println("Unesite omiljeni zanr:");
        zanr = sc.next();
        VipClan vc1 = new VipClan(ime, zanr);
        System.out.println("Unesite ime:");
        ime = sc.next();
        System.out.println("Unesite omiljeni zanr:");
        zanr = sc.next();
        VipClan vc2 = new VipClan(ime, zanr);

        System.out.println("\n" + rc + "\n" + vc1 + "\n" + vc2 + "\n");

        rc.iznajmiReg(filmovi[2]);
        System.out.println(rc);
        vc1.iznajmiVip(filmovi[0]);

        System.out.println();

        vc2.iznajmiVip(filmovi[2]);

        System.out.println("Unesite minimalnu ocenu filma za zanr " + vc2.getOmiljeniZanr() + " kako bismo Vam preporucili film:");
        double ocena = sc.nextDouble();
        String film = vc2.preporuka(filmovi, vc2.getOmiljeniZanr(), ocena);
        System.out.println("Preporuka: " + film);

        for (int i=0; i<filmovi.length; i++) {
            if(filmovi[i].getNaziv().equals(film)) {
                vc2.iznajmiVip(filmovi[i]);
                break;
            }
        }

        System.out.println();
        rc.iznajmiReg(filmovi[1]);
        rc.vratiReg();
        rc.iznajmiReg(filmovi[1]);

        vc1.iznajmiVip(filmovi[2]);
        vc1.iznajmiVip(filmovi[3]);

        sc.close();
    }
}
