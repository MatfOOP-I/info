package primer02_refaktorisano_resenje.stanje;

import primer02_refaktorisano_resenje.model.Rezervacija;

public class KreiranoStanje implements StanjeRezervacije {
    @Override
    public void preuzmi(Rezervacija rezervacija) {
        rezervacija.promeniStanje(new AktivnoStanje());
    }

    @Override
    public void vrati(Rezervacija rezervacija) {
        throw new NedozvoljenaOperacijaException(
                "Kreirana rezervacija još nije preuzeta."
        );
    }

    @Override
    public void otkazi(Rezervacija rezervacija) {
        rezervacija.getVozilo().oslobodi();
        rezervacija.promeniStanje(new OtkazanoStanje());
    }

    @Override
    public String naziv() {
        return "KREIRANA";
    }
}
