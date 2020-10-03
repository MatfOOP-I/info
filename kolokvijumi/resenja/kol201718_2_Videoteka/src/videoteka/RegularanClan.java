package videoteka;

public class RegularanClan extends Clan {

    private Film iznajmljenFilm;

    public RegularanClan(String ime, String omiljeniZanr) {
        super(ime, omiljeniZanr);
        this.iznajmljenFilm = null;
    }

    public Film getIznajmljenFilm() {
        return iznajmljenFilm;
    }

    public void iznajmiReg(Film f) {

        if(!f.isIznajmljen() && iznajmljenFilm == null) {
            f.setIznajmljen(true);
            iznajmljenFilm = f;
            System.out.println(getIme() + " iznajmljuje " + f.getNaziv() + ".");
        }

        else if(f.isIznajmljen()) {
            System.out.println(getIme() + ", film " + f.getNaziv() + " je trenutno iznajmljen.");
        }

        else {
            System.out.println(getIme() + ", ne mozete iznajmiti vise filmova istovremeno! Trenutno iznajmljeni film: " + iznajmljenFilm.getNaziv() + ".");
        }
    }

    public void vratiReg() {
        iznajmljenFilm.setIznajmljen(false);
        System.out.println(getIme() + " vraca " + iznajmljenFilm.getNaziv() + ".");
        iznajmljenFilm = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("; ");

        if(iznajmljenFilm != null) {
            sb.append("Trenutno iznajmljeno: ").append(iznajmljenFilm.getNaziv()).append("; ");
        }

        sb.append("Clanarina: 1000.0");

        return sb.toString();
    }
}
