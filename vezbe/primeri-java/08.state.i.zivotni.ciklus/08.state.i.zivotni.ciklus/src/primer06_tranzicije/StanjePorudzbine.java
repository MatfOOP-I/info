package primer06_tranzicije;

public interface StanjePorudzbine {
    void plati(Porudzbina porudzbina);

    void posalji(Porudzbina porudzbina);

    void isporuci(Porudzbina porudzbina);

    void otkazi(Porudzbina porudzbina);

    String naziv();
}
