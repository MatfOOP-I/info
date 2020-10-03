/**
 * Програм (у виду конзолне апликације) за приказ податак о студентима.
 * Програм је реализован коришћењем објектно-орјентисане парадигме.
 * Програмски код је модуларно организован - реализовано je чување Јава кода у различитим датотекама.
 * Покретање програма је могуће само из датотеке која у себи садржи методу main.
 **/

class Student {
    String ime;
    int brojIndeksa;
    int godinaUpisa;

    void stampajPodatke() {
        System.out.println("Ime studenta je: " + ime
                + ". Broj indeksa je " + brojIndeksa + "/" + godinaUpisa + ".");
    }
}

class PokretanjeStudent {

    // улазна тачка програма
    public static void main(String[] args) {
        Student prvi = new Student();
        prvi.ime = "Petar Peric";
        prvi.brojIndeksa = 3;
        prvi.godinaUpisa = 2017;

        Student drugi;
        drugi = new Student();
        drugi.ime = "Milan Mikic";
        drugi.brojIndeksa = 23;
        drugi.godinaUpisa = 2018;

        prvi.stampajPodatke();
        drugi.stampajPodatke();
    }
}
