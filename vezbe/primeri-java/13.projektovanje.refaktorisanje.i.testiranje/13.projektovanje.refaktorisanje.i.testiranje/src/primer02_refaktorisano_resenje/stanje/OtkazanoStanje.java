package primer02_refaktorisano_resenje.stanje;

import primer02_refaktorisano_resenje.model.Rezervacija;

public class OtkazanoStanje implements StanjeRezervacije {
    private NedozvoljenaOperacijaException otkazana() {
        return new NedozvoljenaOperacijaException(
                "Rezervacija je otkazana."
        );
    }

    @Override
    public void preuzmi(Rezervacija rezervacija) {
        throw otkazana();
    }

    @Override
    public void vrati(Rezervacija rezervacija) {
        throw otkazana();
    }

    @Override
    public void otkazi(Rezervacija rezervacija) {
        throw otkazana();
    }

    @Override
    public String naziv() {
        return "OTKAZANA";
    }
}
