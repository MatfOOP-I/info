package rs.math.oop1.z070602.klasniInicijalizacioniBlok.z01.tacke;

public class PokretanjeTacke {

    public static void main(String[] args) {

        Tacka tac1 = new Tacka();
        tac1.x = 2;
        tac1.y = 3;
        tac1.oznaka = "S";
        Tacka[] niz = {tac1, new Tacka(), new Tacka()};
        System.out.println();
        for (Tacka t : niz)
            t.prikaziSe();

        Tacka a = new Tacka();
        a.x = 45;
        a.y = 7;
        a.oznaka = "A";
        niz[0] = a;
        System.out.println();
       for (Tacka t : niz)
            t.prikaziSe();
   
        System.out.println();
        System.out.printf("Broj kreiranih tacaka: %d", Tacka.brojKreiranih);
    }

}
