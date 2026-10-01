package primer04_vise_strategija;

public class Bezi implements PonasanjeReakcije {
    @Override
    public void reaguj(String ime) {
        System.out.println(ime + " beži.");
    }
}
