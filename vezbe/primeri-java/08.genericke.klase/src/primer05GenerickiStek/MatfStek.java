package primer05GenerickiStek;

// -----------
// DOMACI
// -----------
// Kako bi izbegli rad sa izuzecima u ovoj situaciji, pokusajte da iskoristite java.util.Optional
// za ovu klasu i eliminisete upotrebu PotkoracenjeStekaIzuzetak izuzetka.
public class MatfStek<T> implements GenerickiStek<T>
{
    // -----------------------------------------------------------------------------------------------------------------
    // Klasu koja predstavlja cvor liste cemo implementirati unutar
    // ove klase jer sustinski ne zelimo da je izlazemo spoljnom svetu.
    // Cesta je praksa da se klase koje se koriste u implementaciji drugih
    // klasa i nisu korisne drugima izuzev nama kriju na ovaj nacin.
    // Posto je klasa privatna, mozemo direktno citati vrednosti (ne trebaju nam geteri).
    // -----------------------------------------------------------------------------------------------------------------
    private class Cvor<G>
    {
        G vrednost;
        Cvor<G> sledeci;

        Cvor(G vrednost)
        {
            this.vrednost = vrednost;
        }

        @Override
        public String toString()
        {
            return vrednost.toString();
        }
    }

    private Cvor<T> koren;

    public MatfStek()
    {
        // koren se podrazumevano inicijalizuje na null.
    }

    @Override
    public T peek()
    {
        if (koren == null) {
            // Stek je prazan, desava se potkoracenje steka!
            throw new PotkoracenjeStekaIzuzetak();
        }

        // Izvlacimo vrh steka.
        Cvor<T> c = koren;

        // Vracamo vrednost.
        return c.vrednost;
    }

    @Override
    public T pop()
    {
        if (koren == null) {
            // Stek je prazan, desava se potkoracenje steka!
            throw new PotkoracenjeStekaIzuzetak();
        }

        // Izvlacimo vrh steka.
        Cvor<T> c = koren;

        // Azuriramo koren.
        koren = koren.sledeci;

        // Vracamo vrednost.
        return c.vrednost;
    }

    @Override
    public void push(T v)
    {
        Cvor c = new Cvor<>(v);
        c.sledeci = koren;
        koren = c;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Cvor<T> iterator = koren;
        while (iterator != null) {
            sb.append(iterator.vrednost).append(" ");
            iterator = iterator.sledeci;
        }

        sb.append("]");
        return sb.toString();
    }
}
