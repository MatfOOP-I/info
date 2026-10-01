package primer07_ugnjezdene_klase;
public final class Klub {
    private final String naziv;
    public Klub(String naziv) { this.naziv = naziv; }

    // Static nested: nema implicitnu referencu na konkretan Klub.
    public static final class ClanskaKartica {
        private final int broj;
        public ClanskaKartica(int broj) { this.broj = broj; }
        public int getBroj() { return broj; }
    }

    // Inner: vezana za jedan spoljašnji objekat; vidi njegov privatni naziv.
    public final class Sluzba {
        public String pozdrav() { return "Dobrodošli u " + naziv; }
    }

    public String porukaZa(String ime) {
        // Lokalna klasa: vidljiva samo u ovoj metodi.
        // Koristi parametar koji se ne menja (effectively final).
        class Poruka {
            String tekst() { return ime + ", vaš klub je " + naziv; }
        }
        return new Poruka().tekst();
    }
}
