package primer02_refaktorisano_resenje.stanje;

import primer02_refaktorisano_resenje.model.Rezervacija;

public interface StanjeRezervacije {
    void preuzmi(Rezervacija rezervacija);

    void vrati(Rezervacija rezervacija);

    void otkazi(Rezervacija rezervacija);

    String naziv();
}
