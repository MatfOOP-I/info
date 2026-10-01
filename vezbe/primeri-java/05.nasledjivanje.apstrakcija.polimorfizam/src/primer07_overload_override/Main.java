package primer07_overload_override;
import primer07_overload_override.model.Prevoz;
import primer07_overload_override.vozila.Voz;
public class Main {
    public static String izaberi(Prevoz p) { return "overload za Prevoz"; }
    public static String izaberi(Voz v) { return "overload za Voz"; }
    public static void main(String[] args) {
        Voz voz = new Voz();
        Prevoz prevoz = voz;
        System.out.println(izaberi(voz));    // overload za Voz
        System.out.println(izaberi(prevoz)); // overload za Prevoz
        System.out.println(prevoz.opis());  // Šinski prevoz: Voz
        System.out.println(prevoz);         // toString delegira opis()
        // Overload: izbor potpisa prema tipovima izraza pri kompajliranju.
        // Override: implementacija instance prema objektu pri izvršavanju.
        // prevoz.oznaka(); // nije dozvoljeno ovom nepovezanom klijentu.
    }
}
