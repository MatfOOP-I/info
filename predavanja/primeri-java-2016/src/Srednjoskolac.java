class Srednjoskolac extends Ucenik {
    String vrstaSkole;
    int uzrast;

    String uzetiVrstuSkole() {
        return vrstaSkole;
    }

    void prepoznaje() {
        if (uzrast > 20)
            System.out.println("Ne zavrsava redovno skolu!");
        else
            System.out.println("redovan!");
    }

    public static void main(String args[]) {
        Srednjoskolac sred1 = new Srednjoskolac();
        sred1.ime = "Ana Markovic";
        sred1.vrstaSkole = "Gimnazija";
        sred1.uzrast = 16;
        sred1.stampajIme();
        System.out.println("Ime skole je: " + sred1.uzetiVrstuSkole());
        System.out.print("Ucenik je: ");
        sred1.prepoznaje();
        Srednjoskolac sred2 = new Srednjoskolac();
        sred2.ime = "Marko Rodic";
        sred2.uzrast = 22;
        sred2.stampajIme();
        sred2.prepoznaje();
    }
}