package primer04_polimorfizam;

public class Main {
    public static void main(String[] args) {
        Prevoz[] opcije = {
                new Autobus(),
                new Voz(),
                new Taksi()
        };

        int udaljenost = 35;

        for (Prevoz prevoz : opcije) {
            // Promenljiva ima tip Prevoz, ali Java u trenutku izvršavanja
            // bira implementaciju prema stvarnom objektu na koji pokazuje.
            int cena = prevoz.izracunajCenu(udaljenost);
            System.out.println(prevoz.getNaziv() + ": " + cena + " din");
        }
    }
}
