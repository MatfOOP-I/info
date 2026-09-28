package primer03_testiranje;

import primer02_refaktorisano_resenje.model.Automobil;
import primer02_refaktorisano_resenje.obracun.ClanskiObracun;
import primer02_refaktorisano_resenje.obracun.StandardniObracun;

/**
 * Primer malog unit testa:
 *
 * 1. priprema;
 * 2. akcija;
 * 3. provera.
 */
public class TestObracunaCene {

    public static void pokreni() {
        testStandardnogObracuna();
        testClanskogObracuna();
    }

    private static void testStandardnogObracuna() {
        // 1. Priprema
        Automobil automobil =
                new Automobil(
                        "TEST-1",
                        "Test automobil",
                        5000
                );

        StandardniObracun obracun =
                new StandardniObracun();

        // 2. Akcija
        int cena =
                obracun.izracunaj(automobil, 2);

        // 3. Provera
        Provera.jednako(
                10000,
                cena,
                "Standardna cena za dva dana"
        );
    }

    private static void testClanskogObracuna() {
        Automobil automobil =
                new Automobil(
                        "TEST-2",
                        "Test automobil",
                        5000
                );

        ClanskiObracun obracun =
                new ClanskiObracun();

        int cena =
                obracun.izracunaj(automobil, 2);

        Provera.jednako(
                9000,
                cena,
                "Članski popust treba da bude 10%"
        );
    }
}
