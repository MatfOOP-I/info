package primer03OpcionaVrednost;

import java.util.Random;

// Klasu koristimo samo radi ilustracije da neki pozivi funkcije
// se zavrsavaju uspesno a neki ne.
public class Poruka
{
    private static Random random = new Random();

    public static OpcionaVrednost<String> procitajPoverljivuPoruku()
    {
        double d = random.nextDouble();
        String sadrzaj;
        if (d < 0.5) {
            sadrzaj = "U dobru je lako dobar biti,\n" +
                    "na muci se poznaju junaci!";
        } else {
            sadrzaj = null;
        }

        // Naredba return OpcionaVrednost.od(sadrzaj);
        // rusi program sa NullPointerException za slucaj kada je sadrzaj=null.
        // To i zelimo, jer ako pozivamo metod 'od' treba da smo SIGURNI da vrednost ZAISTA postoji.
        // Kada to nismo sigurni, mozemo da koristimo alternativnu funkciju:
        return OpcionaVrednost.odMozdaNepostojece(sadrzaj);
    }
}
