/**
 * Програм (у виду конзолне апликације) за одређивање најмањег зајдничког
 * делиоца за три броја. Програм је реализован коришћењем објектно-орјентисане
 * парадигме. Програмски код је модуларно организован - реализовано je чување
 * Јава кода у различитим датотекама. Покретање програма је могуће само из
 * датотеке која у себи садржи методу main.
 */

class CeoBrojNas {
    // вредност датог целог броја
    int vrednost;

    // конструктор
    CeoBrojNas(int vrednostBroja) {

        vrednost = vrednostBroja;
    }

    // метод за приказ целог броја
    void prikaz() {
        System.out.print(vrednost);
        System.out.println();
    }

    // одређивање НЗД датог броја и другог целог броја
    CeoBrojNas NZD(CeoBrojNas drugi) {
        int prvaVrednost = vrednost;
        int drugaVrednost = drugi.vrednost;
        while (true)
            if (prvaVrednost > drugaVrednost)
                // први је већи
                if (prvaVrednost % drugaVrednost == 0)
                    return new CeoBrojNas(drugaVrednost);
                else
                    prvaVrednost %= drugaVrednost;
            else
            // први је мањи или једнак
            if (drugaVrednost % prvaVrednost == 0)
                return new CeoBrojNas(prvaVrednost);
            else
                drugaVrednost %= prvaVrednost;
    }

    // одређивање НЗД датог целог броја, другог броја и трећег броја
    CeoBrojNas NZD(CeoBrojNas drugi, CeoBrojNas treci) {
        return NZD(drugi).NZD(treci);
    }

    // одређивање НЗС датог броја и другог целог броја
    CeoBrojNas NZS(CeoBrojNas drugi) {
        CeoBrojNas nzd = NZD(drugi);
        int nzs = (vrednost * drugi.vrednost) / nzd.vrednost;
        return new CeoBrojNas(nzs);
    }

    // одређивање НЗС датог целог броја, другог броја и трећег броја
    CeoBrojNas NZS(CeoBrojNas drugi, CeoBrojNas treci) {
        return NZS(drugi).NZS(treci);
    }

}

class PokretanjeObjektnoNzdNzsCeoBrojNas {
     // улазна тачка програма
    public static void main(String[] args) {
        // бројеви чији се НЗД тражи
        CeoBrojNas prvi = new CeoBrojNas(48);
        CeoBrojNas drugi = new CeoBrojNas(120);
        CeoBrojNas treci = new CeoBrojNas(56);

        // приказ бројева чији се НЗД и НЗС тражи
        System.out.print("Први број је ");
        prvi.prikaz();
        System.out.print("Други број је ");
        drugi.prikaz();
        System.out.print("Трећи број је ");
        treci.prikaz();

        // одређивање НЗД за ова три броја
        CeoBrojNas nzd = prvi.NZD(drugi, treci);
        // одређивање НЗС за ова три броја
        // CeoBrojNas nzs = prvi.NZS(drugi, treci);

        // приказ резултата
        System.out.print("НЗД ова три броја је ");
        nzd.prikaz();
        // System.out.print("НЗС ова три броја је ");
        // nzs.prikaz();
    }

}
