package primer03_testiranje;

/**
 * Minimalna pomoćna klasa za demonstraciju ideje unit testa.
 *
 * Nije zamena za JUnit.
 *
 * Cilj je da testovi ostanu pokretljivi bez spoljne biblioteke.
 */
public class Provera {
    private static int brojProvera;
    private static int brojUspesnih;

    public static void jednako(
            Object ocekivano,
            Object stvarno,
            String opis
    ) {
        brojProvera++;

        boolean jednako =
                ocekivano == null
                        ? stvarno == null
                        : ocekivano.equals(stvarno);

        if (!jednako) {
            throw new AssertionError(
                    opis
                            + " | očekivano: "
                            + ocekivano
                            + ", stvarno: "
                            + stvarno
            );
        }

        brojUspesnih++;
    }

    public static void tacno(
            boolean uslov,
            String opis
    ) {
        brojProvera++;

        if (!uslov) {
            throw new AssertionError(opis);
        }

        brojUspesnih++;
    }

    public static void netacno(
            boolean uslov,
            String opis
    ) {
        tacno(!uslov, opis);
    }

    public static void izvestaj() {
        System.out.println(
                "Uspešno: "
                        + brojUspesnih
                        + "/"
                        + brojProvera
                        + " provera."
        );
    }
}
