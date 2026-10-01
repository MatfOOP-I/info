package primer06_promena_nacina_placanja;

public class Main {
    public static void main(String[] args) {
        Kasa kasa = new Kasa(new PlacanjeGotovinom(500));

        // Gotovina nije dovoljna.
        kasa.naplati(1200);

        // Ne menjamo Kasa klasu niti pravimo novu kasu.
        // Menjamo objekat kome je delegirano ponašanje plaćanja.
        kasa.postaviNacinPlacanja(new DigitalniNovcanik(3000));
        kasa.naplati(1200);
    }
}
