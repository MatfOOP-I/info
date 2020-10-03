package rs.math.oop1.z070903.prevazilazenje.z03.jednakostZaposleni;

public class PokretanjeZaposleni {
    public static void main(String[] args) {

        Zaposleni e1 = new Zaposleni("Janko Jankovic", 1, 75000);
        Zaposleni e2 = new Zaposleni("Marko Markovic", 2, 50000);
        Zaposleni e3 = new Zaposleni("Marko Markovic", 3, 40000);
        Zaposleni e4 = new Zaposleni("Janko Jankovic", 1, 75000);
        Zaposleni[] osoblje = { e1, e2, e3, e4, e1 };
        System.out.println("Elementi niza zaposlenih");
        for (Zaposleni e : osoblje)
            System.out.println(e);
        System.out.println("==");
        for (int i = 0; i < osoblje.length; i++)
            for (int j = i + 1; j < osoblje.length; j++)
                System.out.printf("Poredimo sa == %d-ti i %d-ti: %s\n", i, j, osoblje[i] == osoblje[j]);
        System.out.println(".equals()");
        for (int i = 0; i < osoblje.length; i++)
            for (int j = i + 1; j < osoblje.length; j++)
                System.out.printf("Poredimo sa equals %d-ti i %d-ti: %s\n", i, j, osoblje[i].equals(osoblje[j]));
        System.out.println("HesKodovi niza zaposlenih");
        for (Zaposleni e : osoblje)
            System.out.println(e.hashCode());

    }
}
