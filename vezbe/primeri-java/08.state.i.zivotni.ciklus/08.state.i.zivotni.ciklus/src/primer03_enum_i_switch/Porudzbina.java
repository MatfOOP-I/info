package primer03_enum_i_switch;

/**
 * Jednostavno rešenje sa enum-om.
 *
 * Za mali broj pravila ovo može biti sasvim dobro i čitljivo rešenje.
 */
public class Porudzbina {
    private final int broj;
    private StatusPorudzbine status = StatusPorudzbine.NOVA;

    public Porudzbina(int broj) {
        this.broj = broj;
    }

    public void plati() {
        if (status != StatusPorudzbine.NOVA) {
            System.out.println("Plaćanje nije dozvoljeno.");
            return;
        }

        status = StatusPorudzbine.PLACENA;
        System.out.println("Porudžbina je plaćena.");
    }

    public void posalji() {
        if (status != StatusPorudzbine.PLACENA) {
            System.out.println("Slanje nije dozvoljeno.");
            return;
        }

        status = StatusPorudzbine.POSLATA;
        System.out.println("Porudžbina je poslata.");
    }

    public void otkazi() {
        if (status == StatusPorudzbine.NOVA
                || status == StatusPorudzbine.PLACENA) {
            status = StatusPorudzbine.OTKAZANA;
            System.out.println("Porudžbina je otkazana.");
            return;
        }

        System.out.println("Otkazivanje nije dozvoljeno.");
    }

    public StatusPorudzbine getStatus() {
        return status;
    }
}
