package primer06_rezervacija_prevoza;

public class Main {
    public static void main(String[] args) {
        Putnik putnik = new Putnik("Luka", "Jovanovic");
        Relacija relacija = new Relacija("Beograd", "Novi Sad", 95);

        Prevoz izabraniPrevoz = new Voz();

        RezervacijaPrevoza rezervacija =
                new RezervacijaPrevoza(putnik, relacija, izabraniPrevoz);

        System.out.println(rezervacija.opis());

        // Voz IS-A Prevoz.
        // RezervacijaPrevoza HAS-A Prevoz.
        //
        // Ova dva odnosa imaju različitu ulogu i sasvim prirodno
        // postoje u istom modelu.
    }
}
