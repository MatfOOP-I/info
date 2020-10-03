package tig;

public enum TipRegularneIzmene {
    NovaFunkcionalnost, IspravljenBag, BaterijaTestova;

    public static TipRegularneIzmene izBroja(int broj) {
        if (broj == 1) return NovaFunkcionalnost;
        else if (broj == 2) return IspravljenBag;
        else if (broj == 3) return BaterijaTestova;
        else {
            System.out.println("Neprepoznat broj, vraca se podrazumevnai tip NovaFunkcionalnost");
            return NovaFunkcionalnost;
        }
    }

    public int uBroj()
    {
        switch (this) {
            case NovaFunkcionalnost: return 1;
            case IspravljenBag: return 2;
            case BaterijaTestova: return 3;
            default: return 1;
        }
    }
}
