package primer03OpcionaVrednost;


import java.util.Objects;

// Java 8 poseduje klasu Optional<T> koja funkcionise slicno
// poput nase klase.
// https://www.baeldung.com/java-optional
public class OpcionaVrednost<T>
{
    private T vrednost;

    // Koliko razlicitih praznih vrednosti postoji za konkretan tip T?
    // -> Tacno jedna, tako da mozemo da je instanciramo samo jednom skriveno
    //      od korisnika i izbegnemo suvisna instanciranja (sustinski istog objekta)
    //      tokom rada programa.
    // TEHNICKI DETALJ: Kako kompilator treba da nacini da vrednost EMPTY dele razne klase
    // u zavisnosti od tipa T, koristimo 'wildcard' ? koji oznacava da se dopusta bilo koji tip.
    private static OpcionaVrednost<?> EMPTY = new OpcionaVrednost<>();

    // Cesto je korisno imati staticke funkcije koje "ulepsavaju" interfejs
    // za koriscenje i daju citljiviji kod.
    // Ova funkcija se koristi da napravi opcionu vrednost, pri cemu direktno
    // poziva nas privatni konstruktor koji NAMECE uslov da referenca 'vrednost'
    // nije null, i ako jeste, rusi program. Ovako radi i java.util.Optional.
    public static <T> OpcionaVrednost<T> od(T vrednost)
    {
        return new OpcionaVrednost<>(vrednost);
    }

    // Funkcija koja vraca (gradi) praznu opcionu vrednost.
    public static <T> OpcionaVrednost<T> prazan()
    {
        OpcionaVrednost<T> tmp = (OpcionaVrednost<T>) EMPTY;
        return tmp;
    }

    // Funkcija koja se koristi da se napravi OpcionaVrednost za slucaj
    // da vrednost koju dajemo dozvoljavamo da bude null pri inicijalizaciji.
    public static <T> OpcionaVrednost<T> odMozdaNepostojece(T vrednost)
    {
        return vrednost == null ? prazan() : od(vrednost);
    }

    // Cesto ce konstruktori biti u stvari privatni, a statickim
    // prethodno navedenim metodama ce se konstrolisati kako se alocira objekat.
    // -> Tako radi java.util.Optional implementacija.
    private OpcionaVrednost(T vrednost)
    {
        Objects.requireNonNull(vrednost, "Vrednost ne sme da bude null!");
        this.vrednost = vrednost;
    }

    // Konstrukcija prazne opcione vrednosti.
    private OpcionaVrednost()
    {
    }

    public boolean postoji()
    {
        return vrednost != null;
    }

    public T getVrednost()
    {
        return vrednost;
    }

    @Override
    public String toString() {
        if (postoji())
            return vrednost.toString();
        else
            return "{}";
    }
}
