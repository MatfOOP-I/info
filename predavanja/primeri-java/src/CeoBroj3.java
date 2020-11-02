
class CeoBroj3 {
    // вредност датог целог броја
    int vrednostBroja;

    // конструктор
    CeoBroj3(int vrednost) {

        vrednostBroja = vrednost;
    }

    // метод за приказ целог броја
    void prikaz() {
        System.out.print(vrednostBroja);
        System.out.println();
    }

    // одређивање НЗД датог броја и другог целог броја
    void promeniZnak() {
        vrednostBroja = -vrednostBroja;
    }

    void uvecajSeZa(CeoBroj3 sabirak) {
        vrednostBroja += sabirak.vrednostBroja;
    }

    void umanjiSeZa(CeoBroj3 umanjilac) {
        vrednostBroja -= umanjilac.vrednostBroja;
    }

    boolean manjiOd(CeoBroj3 drugi) {
        return vrednostBroja < drugi.vrednostBroja;
    }

    boolean jednakSa(CeoBroj3 drugi) {
        return vrednostBroja == drugi.vrednostBroja;
    }

    boolean manjiIliJednakOd(CeoBroj3 drugi) {
        return manjiOd(drugi) || jednakSa(drugi);
    }

}

class PokretanjeCeoBroj3 {
    // улазна тачка програма
    public static void main(String[] args) {

        CeoBroj3 jedan = new CeoBroj3(1);
        CeoBroj3 i = new CeoBroj3(1);
        CeoBroj3 n = new CeoBroj3(1000);
        CeoBroj3 suma = new CeoBroj3(0);
        while (i.manjiIliJednakOd(n)) {
            suma.uvecajSeZa(i);
            i.uvecajSeZa(jedan);
        }
        suma.prikaz();

    }

}
