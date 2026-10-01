package zadatak_pocetni;

/** Namerno proceduralan početni kod za zadatak; nije preporučeni model. */
public class Dostava {
    public String id;
    public String posiljalac;
    public String primalac;
    public int masaGrami;
    public String tipPaketa;
    public String vrstaDostave;
    public String status = "KREIRANA";

    public Dostava(String id, String posiljalac, String primalac, int masaGrami,
                   String tipPaketa, String vrstaDostave) {
        if (masaGrami <= 0 || masaGrami > 50_000) {
            throw new IllegalArgumentException("Masa mora biti 1–50000 grama.");
        }
        this.id = id;
        this.posiljalac = posiljalac;
        this.primalac = primalac;
        this.masaGrami = masaGrami;
        this.tipPaketa = tipPaketa;
        this.vrstaDostave = vrstaDostave;
    }

    public int cena() {
        int standardna = 200 + 50 * ((masaGrami + 999) / 1000);
        if (vrstaDostave.equals("STANDARDNA")) return standardna;
        if (vrstaDostave.equals("EKSPRESNA")) return standardna * 2;
        throw new IllegalArgumentException("Nepoznata dostava.");
    }

    public void preuzmi() {
        if (!status.equals("KREIRANA")) throw new IllegalStateException("Nedozvoljeno preuzimanje.");
        status = "PREUZETA";
    }

    public void isporuci() {
        if (!status.equals("PREUZETA")) throw new IllegalStateException("Nedozvoljena isporuka.");
        status = "ISPORUCENA";
    }

    public void otkazi() {
        if (!status.equals("KREIRANA")) throw new IllegalStateException("Nedozvoljeno otkazivanje.");
        status = "OTKAZANA";
    }

    public static void main(String[] args) {
        Dostava p = new Dostava("P-1", "Ana", "Marko", 1500, "LOMLJIV", "STANDARDNA");
        System.out.println(p.cena()); // 300
        p.preuzmi();
        p.isporuci();
        System.out.println(p.status); // ISPORUCENA
    }
}
