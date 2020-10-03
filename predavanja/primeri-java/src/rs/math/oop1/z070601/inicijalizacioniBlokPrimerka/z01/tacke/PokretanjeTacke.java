package rs.math.oop1.z070601.inicijalizacioniBlokPrimerka.z01.tacke;

public class PokretanjeTacke {
    public static void main(String[] args) {
        Tacka tac = new Tacka();
        tac.x = 2;
        tac.y = 3;
        tac.oznaka = "S";
        Tacka[] niz = {tac, new Tacka(), new Tacka()};

        for (Tacka t : niz)
            t.prikaziSe();

    }

}
