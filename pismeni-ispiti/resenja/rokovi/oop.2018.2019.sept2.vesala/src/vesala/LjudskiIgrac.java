package vesala;

public class LjudskiIgrac extends Igrac{
    private char izabranoSlovo;

    public LjudskiIgrac(String ime, int nivo, int brOdigranihPartija, int brPobedjenihPartija) {
        super(ime, nivo, brOdigranihPartija, brPobedjenihPartija);
    }

    @Override
    public char odaberiSlovo(Rec trazenaRec) {
        return izabranoSlovo;
    }

    public void setIzabranoSlovo(char izabranoSlovo) {
        if (Character.isAlphabetic(izabranoSlovo))
            this.izabranoSlovo = izabranoSlovo;
    }
}
