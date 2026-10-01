package primer04_vise_strategija;

public class Ignorisi implements PonasanjeReakcije {
    @Override
    public void reaguj(String ime) {
        System.out.println(ime + " ignoriše opasnost.");
    }
}
