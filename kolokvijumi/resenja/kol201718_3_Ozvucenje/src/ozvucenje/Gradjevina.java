package ozvucenje;

import java.util.Scanner;

public class Gradjevina {
    public static void main(String[] args) {
        Zvucnik[] z = {new Zvucnik("Yamaha", "HS8", 75), new Zvucnik("Yamaha", "HS7", 60),
                 new Zvucnik("Logitec", "Z313", 25)};
        Scanner sc = new Scanner(System.in);
        Skladiste s;
        String naziv;
        double duzina, sirina, dimenzijaPalete;

        System.out.println("Unesite naziv skladista:");
        naziv = sc.next();
        System.out.println("Unesite duzinu skladista:");
        duzina = sc.nextDouble();
        System.out.println("Unesite sirinu skladista:");
        sirina = sc.nextDouble();
        System.out.println("Unesite stranicu palete:");
        dimenzijaPalete = sc.nextDouble();

        s = new Skladiste(naziv, duzina, sirina, dimenzijaPalete);

        System.out.println(s);

        s.dodajPalete(8);
        s.dodajPalete(4);
        s.dodajPalete(2);

        MuzickaSala ms;
        int brMesta;

        System.out.println("Unesite naziv muzicke sale:");
        naziv = sc.next();
        System.out.println("Unesite duzinu muzicke sale:");
        duzina = sc.nextDouble();
        System.out.println("Unesite sirinu muzicke sale:");
        sirina = sc.nextDouble();
        System.out.println("Unesite broj mesta:");
        brMesta = sc.nextInt();

        ms = new MuzickaSala(naziv, duzina, sirina, brMesta, z);

        System.out.println(ms);

        ms.getOzvucenje()[0].switchOnOff();
        ms.getOzvucenje()[1].switchOnOff();
        ms.getOzvucenje()[2].switchOnOff();

        if (ms.proveriOzvucenje()) {
            System.out.println("Dobro ozvuceno!");
        } else {
            System.out.println("Lose ozvuceno!");
        }

        for (int i = 0; i < 10; i++) {
            ms.zauzmiMesto(i);
        }

        if (ms.proveriOzvucenje()) {
            System.out.println("Dobro ozvuceno!");
        } else {
            System.out.println("Lose ozvuceno!");
        }

    }


}
