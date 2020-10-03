/*

Класа за реализацију стека који садржи ниске.

Стек се реализује преко низа. 

Стек може да расте по потреби.
 
 */

package rs.math.oop1.z070702.modifikatoriPristupa.z05.stekPrekoJednostrukoPovezaneListe;

public class StekNiski {

    private JednostukoPovezanaLista sadrzaj = new JednostukoPovezanaLista();

    public void push(String elem) {
        sadrzaj.dodajElemenatNaPocetak(elem);
        ;
    }

    public String pop() {
        return sadrzaj.ukloniElemenatSaPocetka();
    }

    public int brojElemenata() {
        return sadrzaj.duzina();
    }
}
