package rs.math.oop1.z100104.izuzeciPreporuke.z03.trebaNeTreba;

// OVAKO NE TREBA RADITI!
public class ProsekClanovaNiza {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 123, 4, 224, 65};
        try {
            sracunajProsek(a);
        } catch (ProtrcaoKrozCeoNizException e) {
            double s = e.suma;
            int i = e.indeks;
            System.out.println("Prosek je " + (s / i));
        }
    }

    private static void sracunajProsek(int[] a)
            throws ProtrcaoKrozCeoNizException {
        int i = 0;
        double s = 0;
        for (; ; ) {
            s += a[i++];
            if (a.length == i)
                throw new ProtrcaoKrozCeoNizException(s, i);
        }
    }

}
