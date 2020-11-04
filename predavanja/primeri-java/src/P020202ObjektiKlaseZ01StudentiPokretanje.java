/**
 * Програм (у виду конзолне апликације) за приказ податак о студентима. Програм
 * је реализован коришћењем објектно-орјентисане парадигме. Програмски код је
 * модуларно организован - реализовано je чување Јава кода у различитим
 * датотекама. Покретање програма је могуће само из датотеке која у себи садржи
 * методу main.
 **/

class Student {
    String ime;
    String prezime;
    int brojIndeksa;
    int godinaUpisa;
    boolean diplomirao;

    void stampajPodatke() {
        System.out.print("Ime studenta je: " + ime + " " + prezime + ". Broj indeksa je " + brojIndeksa + "/"
                + godinaUpisa + ".");
        System.out.println(diplomirao ? " Diplomirao!" : " Jos studira");
    }

    void setDiplomirao(boolean jeDiplomirao) {
        diplomirao = jeDiplomirao;
    }

}

class PokretanjeStudent {

    // улазна тачка програма
    public static void main(String[] args) {
        Student prvi = new Student();
        prvi.ime = "Petar";
        prvi.prezime = "Peric";
        prvi.brojIndeksa = 3;
        prvi.godinaUpisa = 2017;

        Student drugi;
        drugi = new Student();
        drugi.ime = "Milan";
        drugi.prezime = "Mikic";
        drugi.brojIndeksa = 23;
        drugi.godinaUpisa = 2018;

        prvi.stampajPodatke();
        drugi.setDiplomirao(true);
        drugi.stampajPodatke();

        if (prvi instanceof Student)
            System.out.println(prvi + " je Student");

    }
}
