package primer05_promena_ponasanja;

public class BoriSe implements PonasanjeReakcije {
    @Override
    public void reaguj(String ime) {
        System.out.println(ime + " bori se.");
    }
}
