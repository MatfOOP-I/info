/**
 * Програм (у виду конзолне апликације) за одређивање најмањег зајдничког
 * делиоца за три броја. Програм је реализован коришћењем објектно-орјентисане
 * парадигме. Програмски код је модуларно организован - реализовано je чување
 * Јава кода у различитим датотекама. Покретање програма је могуће само из
 * датотеке која у себи садржи методу main.
 */

class CeoBroj2 {
    // вредност датог целог броја
    int vrednost;

    // конструктор
    CeoBroj2(int vrednostBroja) {

        vrednost = vrednostBroja;
    }

    // метод за приказ целог броја
    void prikaz() {
        System.out.print(vrednost);
        System.out.println();
    }

    // одређивање НЗД датог броја и другог целог броја
    CeoBroj2 promeniZnak() {
        return new CeoBroj2(-vrednost);
    }

    void uvecajSeZa(int uvecanje) {
        vrednost += uvecanje;
    }

    boolean jednakSa(CeoBroj2 drugi) {
        return vrednost == drugi.vrednost;
    }

}

class PokretanjeCeoBroj2 {
    // улазна тачка програма
    public static void main(String[] args) {
        // бројеви чији се НЗД тражи
        CeoBroj2 x = new CeoBroj2(1);
        CeoBroj2 kraj = new CeoBroj2(43);
        while (!x.jednakSa(kraj)) {
            x.prikaz();
            x.uvecajSeZa(1);
        }

    }

}
