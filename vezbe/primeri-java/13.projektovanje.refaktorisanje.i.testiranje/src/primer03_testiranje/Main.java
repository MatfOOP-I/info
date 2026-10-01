package primer03_testiranje;

public class Main {
    public static void main(String[] args) {
        TestObracunaCene.pokreni();
        TestZivotnogCiklusa.pokreni();
        TestSistema.pokreni();

        Provera.izvestaj();

        System.out.println(
                "Svi testovi su uspešno završeni."
        );
    }
}
