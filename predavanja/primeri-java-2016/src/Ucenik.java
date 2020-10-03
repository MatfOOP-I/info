class Ucenik {
    String ime;
    int razred;

    boolean baviSeSportom(String sport) {
        if (sport == null)
            return false;
        return true;
    }

    void stampajIme() {
        System.out.println("Ime ucenika je: " + ime);
    }

    public static void main(String[] komandnaLinija) {

        Ucenik prvi = new Ucenik();
        prvi.ime = "Petar Peric";
        prvi.stampajIme();
        System.out.println("Ucenik se bavi sportom:" + prvi.baviSeSportom("kosarka"));
    }

}