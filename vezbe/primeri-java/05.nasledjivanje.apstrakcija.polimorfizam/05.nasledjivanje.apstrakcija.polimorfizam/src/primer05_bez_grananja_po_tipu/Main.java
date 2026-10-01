package primer05_bez_grananja_po_tipu;

public class Main {
    public static void main(String[] args) {
        Prevoz prevoz = new Voz();
        Ponuda.ispisi(prevoz, 80);

        prevoz = new Taksi();
        Ponuda.ispisi(prevoz, 12);

        // Nije potrebno:
        // if (prevoz instanceof Voz) { ... }
        // else if (prevoz instanceof Taksi) { ... }
        //
        // Svaki konkretan prevoz sam zna kako računa svoju cenu.
    }
}
