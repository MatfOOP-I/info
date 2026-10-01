package primer02_refaktorisano_resenje.stanje;

import primer02_refaktorisano_resenje.model.Rezervacija;

public class ZavrsenoStanje implements StanjeRezervacije {
    private NedozvoljenaOperacijaException zavrsena() {
        return new NedozvoljenaOperacijaException(
                "Rezervacija je već završena."
        );
    }

    @Override
    public void preuzmi(Rezervacija rezervacija) {
        throw zavrsena();
    }

    @Override
    public void vrati(Rezervacija rezervacija) {
        throw zavrsena();
    }

    @Override
    public void otkazi(Rezervacija rezervacija) {
        throw zavrsena();
    }

    @Override
    public String naziv() {
        return "ZAVRSENA";
    }
}
