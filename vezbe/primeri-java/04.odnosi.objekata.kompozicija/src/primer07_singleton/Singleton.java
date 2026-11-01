package primer07_singleton;

public class Singleton {
    private static Singleton instanca = null;

    private Singleton() {}

    public static Singleton getInstanca() {
        if (instanca == null) {
            instanca = new Singleton();
        }

        return instanca;
    }

    public void ispis() {
        System.out.println("Singleton je obrazac projektovanja "
                + "koji omogućava postojanje samo jedne instance klase.");
    }
}