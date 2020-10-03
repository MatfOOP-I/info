// Пример илуструје неке употребе празне наредбе.

class PokretanjePraznaNaredba {

    public static void main(String[] args) {
        int x = 10;
        boolean uslov = false;

        for (; x < 100; x++) {
            //upotreba prazne naredbe kada nije potrebno npr. inicijalizovati vrednost u for petlji
            //slicno se mogu izostaviti i drugi delovi u zapisu for ciklusa

            if (x % 2 == 0)
                System.out.println(x);
            else
                ; //zbog preglednosti stavljamo praznu naredbu iako je cilj da se ispisu samo parni brojevi
        }

        //realizacija aktivnog cekanja na neki uslov potreban za nastavak programa
        while (!uslov)
            ;
        /* Nakon cekanja je moguce nastaviti neku drugu aktivnost.
        Ova tehnika se koristi u visenitnom programiranje, jer je potrebno neko drugi da postavi uslov,
        jer to ne moze da se uradi iz ove funkcije.
        To znaci da je u ovom programu postignut efekat beskonacne petlje pa je program potrebno ekspiclitno zaustaviti.
        */

    }
}
