package skolstvo;

public class Ucenik2 {
    String ime = "U2";
    int razred = 1;

    boolean baviSeSportom(String sport) {
        if (sport == null)
            return false;
        return true;
    }

    void stampajIme() {
        System.out.println("Ime ucenika je: " + ime);
    }

    public static void main(String[] komandnaLinija) {

        Ucenik2 prvi = new Ucenik2();
        prvi.ime = "Petar Peric";
        prvi.stampajIme();
        System.out.println("Ucenik se bavi sportom:" + prvi.baviSeSportom("kosarka"));
    }

}