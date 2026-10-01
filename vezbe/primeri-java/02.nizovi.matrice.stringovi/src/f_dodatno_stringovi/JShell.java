package f_dodatno_stringovi;
import java.util.Scanner;
/** Mini petlja za rad sa tekstom; nije JDK alat jshell i ne pokreće OS komande. */
public class JShell {
    public static void main(String[] args) {
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unosite tekst; exit završava program.");
        while (true) {
            System.out.print("> ");
            if (!ulaz.hasNextLine()) break;
            String red = ulaz.nextLine();
            if (red.equalsIgnoreCase("exit")) break;
            System.out.println(new StringBuilder(red).reverse());
        }
    }
}
