package primer02_problem_identiteta;

public class Main {
    public static void main(String[] args) {
        Porudzbina originalnaReferenca = new NovaPorudzbina(1042);

        /*
         * Zamislimo da je drugi deo programa sačuvao istu referencu.
         */
        Porudzbina sacuvanaReferenca = originalnaReferenca;

        /*
         * "Plaćanje" vraća NOV objekat.
         */
        Porudzbina placena = originalnaReferenca.plati();

        System.out.println("Nova referenca: " + placena.stanje());
        System.out.println("Stara referenca: " + sacuvanaReferenca.stanje());

        /*
         * Domen kaže da je u pitanju ista porudžbina #1042.
         * Java model sada ima dva različita objekta sa različitim stanjem.
         */
        System.out.println(originalnaReferenca == placena);
    }
}
