package primer02_redefinisanje_metoda;

public class Main {
    public static void main(String[] args) {
        int udaljenost = 20;

        Autobus autobus = new Autobus("Autobus");
        Voz voz = new Voz("Voz");
        Taksi taksi = new Taksi("Taksi");

        System.out.println(autobus.getNaziv() + ": "
                + autobus.izracunajCenu(udaljenost) + " din");
        System.out.println(voz.getNaziv() + ": "
                + voz.izracunajCenu(udaljenost) + " din");
        System.out.println(taksi.getNaziv() + ": "
                + taksi.izracunajCenu(udaljenost) + " din");
    }
}
