/*
  
Написати Јава програм који пребројава елементе у низу бројева из интервала 1-10
и приказује их у бројчаном облику и у облику хистограма.
    
*/

// Програм илуструје пренос вредности између позивајућег и позваног метода  преко
// глобалних променљивих.

class PokretanjeJednodimenzionalniNizFrekfencijeGlobalnePromenlive {

    static int[] rezultati =
            {1, 2, 4, 0, 7, 6, 3, -4, 5, 6, 4, 3, 7, 3, 2, 5, 7, 8,
                    5, 11, 11};
    static int[] brojPojava;
    static int min;
    static int max;

    static void izracunajFrekfencije() {
        min = rezultati[0];
        max = rezultati[0];
        for (int x : rezultati)
            if (x > max)
                max = x;
            else if (x < min)
                min = x;
        brojPojava = new int[max - min + 1];
        for (int i = 0; i < brojPojava.length; i++)
            brojPojava[i] = 0;
        for (int x : rezultati)
            brojPojava[x - min]++;
    }

    static void prikaziFrekfencijeNumericki() {
        for (int i = 0; i < brojPojava.length; i++)
            System.out.printf("%d:%d %s", (i + min),
                    brojPojava[i],
                    ((i + 1) % 8 == 0) ? "\n" : "\t");
    }

    static void prikaziFrekfencijeGraficki() {
        for (int i = 0; i < brojPojava.length; i++) {
            System.out.printf("%3d:", i + min);
            for (int j = 0; j < brojPojava[i]; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Niz brojeva:");
        for (int x : rezultati)
            System.out.printf("%4d", x);
        izracunajFrekfencije();
        System.out.println(
                "\nBroj pojava (numericki prikaz):");
        prikaziFrekfencijeNumericki();
        System.out.println("\nBroj pojava (histogram):");
        prikaziFrekfencijeGraficki();
    }
}
