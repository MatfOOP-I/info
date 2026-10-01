package primer05_promena_ponasanja;

public class Bezi implements PonasanjeReakcije {
    @Override
    public void reaguj(String ime) {
        System.out.println(ime + " beži.");
    }
}
