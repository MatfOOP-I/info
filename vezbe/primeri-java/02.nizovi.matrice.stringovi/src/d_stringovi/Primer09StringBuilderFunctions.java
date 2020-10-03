package d_stringovi;

public class Primer09StringBuilderFunctions {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        // Metod append vraca referencu na StringBuilder nad kojim je pozvan,
        // tako da mozemo ulancavati pozive (ovaj nacin rada koriste i neki drugi jezici)
        sb.append("Hello").append(" ").append("word, how are you today?");

        // Sadrzaj StringBuildera obrce u mestu.
        sb.reverse();

        System.out.println("Obrnuti string: " + sb);

        System.out.println("Broj karaktera: " + sb.length());

        // Mozemo da modifikujemo i-ti karakter.
        sb.setCharAt(0, '!');
        System.out.println("Modifikovani string: " + sb);

        // Kako ocistiti StringBuilder? Postavljamo mu duzinu na 0 :)
        sb.setLength(0);
        sb.append("Hello world.");

        // Mozemo ubacivati i brisati podstringove
        sb.insert(6, "dear ");
        System.out.println("After inserting \"dear\": " + sb);
        sb.delete(6, 11);
        System.out.println("After deleting \"dear\": " + sb);
    }

}
