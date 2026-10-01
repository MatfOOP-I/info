package primer01_osnovno_nasledjivanje;

public class Main {
    public static void main(String[] args) {
        Autobus autobus = new Autobus("Medjugradski autobus", 70, 52);
        Voz voz = new Voz("InterCity", 110, 6);

        // Metode opis() i proceniTrajanje() nisu napisane u izvedenim
        // klasama, ali su nasleđene iz klase Prevoz.
        System.out.println(autobus.opis());
        System.out.println("120 km: " + autobus.proceniTrajanje(120) + " min");

        System.out.println();
        System.out.println(voz.opis());
        System.out.println("120 km: " + voz.proceniTrajanje(120) + " min");
    }
}
