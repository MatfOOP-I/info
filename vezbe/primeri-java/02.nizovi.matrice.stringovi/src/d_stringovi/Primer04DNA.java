package d_stringovi;

/// Program prikazuje kako mozemo prebrojati broj pojavljivanja
/// datog podstringa u stringu.

/*
 * Chuck Norris je konacno pristao da dozvoli naucnicima da mu urade DNK analizu.
 * Naucnici su zeleli da ispitaju sta je to sto Chuck-a cini toliko posebnim,
 * i nakon puno rada, ustanovili su da njegov DNK sadrzi veliki broj
 * pojavljivanja sledece sekvence: ATGC.
 *
 * Njihov sledeci zadatak je da razviju program koji ce za datu dnk sekvencu neke
 * osobe vratiti broj pojavljivanja sekvence ATGC kako bi mogli da
 * nakon vise ispitanih osoba procene u kojoj meri ljudi poseduju sekvencu ATGC
 * koju su pronasli kod Chuck-a.
 */
public class Primer04DNA {

    public static void main(String[] args) {
        String sequencedDna = "ggcgatatgcagtagcgcttctatgccataccgtatgctacacaacgtgatgcggccacttaggggcttctgtaagcgagt";
        String chuckieDna = "atgc";

        int count = countChuckie(sequencedDna, chuckieDna);
        System.out.println(count);
    }

    static int countChuckie(String sequencedDna, String chuckieDna) {
        int counter = 0;
        // Trazimo indeks prvog pojavljivanja podstringa koji trazimo.
        int i = sequencedDna.indexOf(chuckieDna);
        while (i != -1) { // Sve dok ne uspemo da pronadjemo pojavljivanje podstringa
            // Ako smo usli u petlju, znamo da imamo barem jedno pojavljivanje,
            counter++;

            // Iz stringa koji pretrazujemo, odbacujemo deo koji smo pretrazili
            sequencedDna = sequencedDna.substring(i + chuckieDna.length());

            // Trazimo ponovo pojavljivanja podstringa u ostatku stringa
            i = sequencedDna.indexOf(chuckieDna);
        }
        return counter;
    }
}
