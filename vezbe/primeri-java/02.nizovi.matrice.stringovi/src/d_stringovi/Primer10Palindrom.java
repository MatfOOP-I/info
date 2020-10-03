package d_stringovi;

import java.util.Scanner;

/**
 * Program proverava da li je uneti string palindrom
 * ako se zanemari velicina slova i beline.
 */
public class Primer10Palindrom {

    public static boolean palindrom(String str){
        // svaki razmak zamenimo praznim stringom
        // i smanjimo sva velika slova:
        String bezBelinaMalaSlova = str.replace(" ", "").toLowerCase();
        // jos jedna ilustracija kako se pozivi metoda za StringBuilder mogu ulancavati
        return new StringBuilder(bezBelinaMalaSlova).reverse().toString().equals(bezBelinaMalaSlova);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite string za proveru: ");
        String kandidat = sc.nextLine();

        if(palindrom(kandidat))
            System.out.println("String \"" + kandidat + "\" je palindrom.");
        else
            System.out.println("String \"" + kandidat + "\" nije palindrom.");

        sc.close();
    }
}
