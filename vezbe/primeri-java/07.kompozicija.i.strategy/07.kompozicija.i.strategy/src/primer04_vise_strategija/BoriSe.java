package primer04_vise_strategija;

public class BoriSe implements PonasanjeReakcije {
    @Override
    public void reaguj(String ime) {
        System.out.println(ime + " bori se.");
    }
}
