package videoteka;

public class VipClan extends Clan {

    private int popust;
    private static int brojVipClanova = 0;

    public VipClan(String ime, String omiljeniZanr) {
        super(ime, omiljeniZanr);
        brojVipClanova++;

        if(brojVipClanova%3 == 1) {
            popust = 10;
        }
        else {
            popust = 0;
        }
    }

    public int getPopust() {
        return popust;
    }

    public int getBrojVipClanova() {
        return brojVipClanova;
    }

    public void iznajmiVip(Film f) {
        if(!f.isIznajmljen()) {
            f.setIznajmljen(true);
            System.out.println(getIme() + " iznajmljuje " + f.getNaziv() + ".");
        }
        else {
            System.out.println(getIme() + ", film " + f.getNaziv() + " je trenutno iznajmljen.");
        }
    }

    public void vratiVip(Film f) {
        f.setIznajmljen(false);
        System.out.println(getIme() + " vraca " + f.getNaziv() + ".");
    }

    public String preporuka(Film[] filmovi, String zanr, double ocena) {
        int max = -1;
        for (int i=0; i<filmovi.length; i++) {
            String[] zanrovi = filmovi[i].getZanr();
            for (int j=0; j<zanrovi.length; j++) {
                if(zanrovi[j].equals(zanr) &&
                    ((max == -1 && ocena <= filmovi[i].getOcena()) ||
                            (max != -1 && filmovi[max].getOcena() <= filmovi[i].getOcena()))) {
                    max = i;
                }
            }
        }

        if(max >= 0) {
            return filmovi[max].getNaziv();
        }
        else {
            return "Nijedan film ne zadovoljava zadate kriterijume!";
        }
    }

    @Override
    public String toString() {
        return super.toString() + "; Clanarina: " + 2000.0*(1-popust/100.0);
    }
}
