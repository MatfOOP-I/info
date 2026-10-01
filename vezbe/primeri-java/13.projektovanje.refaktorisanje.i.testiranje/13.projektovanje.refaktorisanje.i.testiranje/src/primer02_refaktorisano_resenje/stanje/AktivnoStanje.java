package primer02_refaktorisano_resenje.stanje;

import primer02_refaktorisano_resenje.model.Rezervacija;

public class AktivnoStanje implements StanjeRezervacije {
    @Override
    public void preuzmi(Rezervacija rezervacija) {
        throw new NedozvoljenaOperacijaException(
                "Vozilo je već preuzeto."
        );
    }

    @Override
    public void vrati(Rezervacija rezervacija) {
        rezervacija.getVozilo().oslobodi();
        rezervacija.promeniStanje(new ZavrsenoStanje());
    }

    @Override
    public void otkazi(Rezervacija rezervacija) {
        throw new NedozvoljenaOperacijaException(
                "Aktivna rezervacija ne može da se otkaže."
        );
    }

    @Override
    public String naziv() {
        return "AKTIVNA";
    }
}
