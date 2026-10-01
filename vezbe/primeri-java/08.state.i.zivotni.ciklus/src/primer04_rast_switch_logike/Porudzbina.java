package primer04_rast_switch_logike;

/**
 * I dalje koristimo enum, ali sada broj pravila raste.
 *
 * Primećujemo da svaka metoda mora da zna sve više detalja
 * o mogućim stanjima i tranzicijama.
 */
public class Porudzbina {
    private final int broj;
    private StatusPorudzbine status = StatusPorudzbine.NOVA;

    public Porudzbina(int broj) {
        this.broj = broj;
    }

    public void plati() {
        switch (status) {
            case NOVA -> {
                System.out.println("Naplata uspešna.");
                status = StatusPorudzbine.PLACENA;
            }
            case PLACENA -> System.out.println("Porudžbina je već plaćena.");
            case POSLATA -> System.out.println("Poslata porudžbina je već plaćena.");
            case OTKAZANA -> System.out.println("Otkazana porudžbina ne može da se plati.");
        }
    }

    public void posalji() {
        switch (status) {
            case NOVA -> System.out.println("Prvo je potrebno platiti porudžbinu.");
            case PLACENA -> {
                System.out.println("Porudžbina je poslata.");
                status = StatusPorudzbine.POSLATA;
            }
            case POSLATA -> System.out.println("Porudžbina je već poslata.");
            case OTKAZANA -> System.out.println("Otkazana porudžbina ne može da se pošalje.");
        }
    }

    public void otkazi() {
        switch (status) {
            case NOVA -> {
                System.out.println("Porudžbina je otkazana.");
                status = StatusPorudzbine.OTKAZANA;
            }
            case PLACENA -> {
                System.out.println("Vraćamo novac i otkazujemo porudžbinu.");
                status = StatusPorudzbine.OTKAZANA;
            }
            case POSLATA -> System.out.println("Poslata porudžbina više ne može da se otkaže.");
            case OTKAZANA -> System.out.println("Porudžbina je već otkazana.");
        }
    }

    public StatusPorudzbine getStatus() {
        return status;
    }
}
