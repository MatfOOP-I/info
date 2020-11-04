/**
 * Програм (у виду конзолне апликације) за одређивање најмањег зајдничког
 * делиоца за три броја. Програм је реализован коришћењем објектно-орјентисане
 * парадигме. Програмски код је модуларно организован - реализовано je чување
 * Јава кода у различитим датотекама. Покретање програма је могуће само из
 * датотеке која у себи садржи методу main.
 */

class CeoBroj2 {
    // вредност датог целог броја
    int vrednostBroja;

    // конструктор
    CeoBroj2(int vrednost) {

        vrednostBroja = vrednost;
    }

    // метод за приказ целог броја
    void prikaz() {
        System.out.print(vrednostBroja);
        System.out.println();
    }

    // одређивање НЗД датог броја и другог целог броја
    CeoBroj2 promeniZnak() {
        return new CeoBroj2(-vrednostBroja);
    }

    CeoBroj2 saberi(CeoBroj2 sabirak) {
        return new CeoBroj2(vrednostBroja + sabirak.vrednostBroja);
    }

    CeoBroj2 oduzmi(CeoBroj2 umanjilac) {
        return new CeoBroj2(vrednostBroja - umanjilac.vrednostBroja);
    }

    boolean jednak(CeoBroj2 drugi) {
        return vrednostBroja == drugi.vrednostBroja;
    }

    boolean manji(CeoBroj2 drugi) {
        return vrednostBroja < drugi.vrednostBroja;
    }

    boolean manjiIliJednak(CeoBroj2 drugi) {
        return manji(drugi) || jednak(drugi);
    }

    boolean veci(CeoBroj2 drugi) {
        return !manjiIliJednak(drugi);
    }

}

class PokretanjeCeoBroj2 {
    // улазна тачка програма
    public static void main(String[] args) {

        System.out.println("---");
        int a = 1;
        int b = 4_200_000;
        int s = 0;
        while (a <= b) {
            s += a;
            a++;
        }
        System.out.println(s);

        System.out.println("---");

        CeoBroj2 broj1 = new CeoBroj2(1);
        CeoBroj2 aa = new CeoBroj2(1);
        CeoBroj2 bb = new CeoBroj2(b);
        CeoBroj2 ss = new CeoBroj2(0);
        while (aa.manjiIliJednak(bb)) {
            ss = ss.saberi(aa);
            aa = aa.saberi(broj1);
        }
        ss.prikaz();

    }

}
