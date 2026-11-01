package primer07_singleton;

public class Main {

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstanca();
        s1.ispis();

        Singleton s2 = Singleton.getInstanca();
        if (s1 == s2) {
            System.out.println("Isti objekat je u pitanju!");
        }

        s2.ispis();
    }
}
