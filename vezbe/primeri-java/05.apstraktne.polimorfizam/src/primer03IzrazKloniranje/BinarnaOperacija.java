package primer03IzrazKloniranje;

public abstract class BinarnaOperacija extends Izraz {
    private Izraz levi, desni;

    public BinarnaOperacija(Izraz levi, Izraz desni) {
        // Umesto this.levi = levi
        // koristimo polimorfnu funkciju 'klon' koja pravi
        // kopiju prosledjenog objekta.
        this.levi = levi.klon();
        this.desni = desni.klon();
    }


    public Izraz getLevi() {
        return levi;
    }

    public Izraz getDesni() {
        return desni;
    }

    // Pošto se toString() metoda u izvedenim klasama razlikuje isključivo u jednom karakteru,
    // metod toString() možemo definisati u okviru apstraktne klase i tražiti od izvedene klase da implementira
    // apstraktni metod karakterOperacije().
    // Na ovaj način koristimo hijerarhijsko nasleđivanje da bismo izbegli nepotrebno kopiranje koda

    protected abstract char karakterOperacije();

    @Override
    public String toString() {
        return getLevi().toString() + " " + karakterOperacije() + " " + getDesni().toString();
    }
}
