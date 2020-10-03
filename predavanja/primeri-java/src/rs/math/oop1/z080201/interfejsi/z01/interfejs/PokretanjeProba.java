package rs.math.oop1.z080201.interfejsi.z01.interfejs;


public class PokretanjeProba {

    public static void main(String[] arg)
    {
        Proba proba = new Proba();
        proba.prikaziPitanje();
        System.out.println(proba.pitanje());
        System.out.println(proba.pitanje2());
        System.out.println();

        Prvi p = new Proba();
        p.prikaziPitanje();
        System.out.println(p.pitanje());
//        System.out.println(p.pitanje2());
        System.out.println();
    }
}
