package primer04_kontroler.model;

public class Zadatak {
    private final String opis;
    private final Prioritet prioritet;
    private boolean zavrsen;

    public Zadatak(String opis, Prioritet prioritet) {
        if (opis == null || opis.trim().length() < 3) {
            throw new IllegalArgumentException(
                    "Opis mora imati bar 3 znaka."
            );
        }

        if (prioritet == null) {
            throw new IllegalArgumentException(
                    "Prioritet je obavezan."
            );
        }

        this.opis = opis.trim();
        this.prioritet = prioritet;
    }

    public void zavrsi() {
        zavrsen = true;
    }

    public String getOpis() {
        return opis;
    }

    public Prioritet getPrioritet() {
        return prioritet;
    }

    public boolean isZavrsen() {
        return zavrsen;
    }
}
