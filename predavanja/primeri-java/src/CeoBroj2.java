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

    void uvecajSeZa(int uvecanje) {
        vrednostBroja += uvecanje;
    }

    boolean jednakSa(CeoBroj2 drugi) {
        return vrednostBroja == drugi.vrednostBroja;
    }

}

class PokretanjeCeoBroj2 {
    // улазна тачка програма
    public static void main(String[] args) {

        int a = 1;
        int b = 43;
        while (a != b) {
            System.out.println(a);
            a++;
        }

        System.out.println("------");
        CeoBroj2 x = new CeoBroj2(1);
        CeoBroj2 kraj = new CeoBroj2(43);
        while (!x.jednakSa(kraj)) {
            x.prikaz();
            x.uvecajSeZa(1);
        }

    }

}
