package rs.math.oop1.z100104.izuzeciPreporuke.z01.trebaNeTreba;

public class ProsekClanovaNiza {

    public static void main(String[] args) {
        int a[] = {45, 12, 1, 2, 3, 123, 4, 224, 65};
        long pocetak = System.nanoTime();
        // OVAKO TREBA RADITI!
        double s = 0;
        for (int x : a)
            s += x;
        s /= a.length;
        long trajanje = System.nanoTime() - pocetak;
        System.out.println("Prosek je " + s
                + ", a trajanje: " + trajanje / 1000000.0 + "ms.");
        // OVAKO NE TREBA RADITI!
        pocetak = System.nanoTime();
        s = 0;
        int i = 0;
        try {
            for (; ; )
                s += a[i++];
        } catch (IndexOutOfBoundsException exp) {
            trajanje = System.nanoTime() - pocetak;
            System.out.println("Prosek je " + ((s / (i - 1))) +
                    ", a trajanje: " + trajanje / 1000000.0 + "ms.");
        }
    }

}
