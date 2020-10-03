package d_stringovi;

public class Primer05Podstring {
    public static void main(String[] args) {
        String t = "    hello world, how are you today ";
        show("t", t);

        // Proveravamo da li t sadrzi string "hello world"
        if (t.contains("hello world"))
            System.out.println("t sadrzi: \"hello world\"");
        else
            System.out.println("t ne sadrzi: \"hello world\"");

        // Izdvajamo podstring iz t za date indekse
        show("t.substring(17)", t.substring(17));
        show("t.substring(10, 15)", t.substring(10, 15));

        // Proveravamo da li je niska "hello" prefiks, a
        // niska "today" sufiks za t.
        prefix(t, "hello");
        sufix(t, "today");

        // Uklanjamo vodece/zavrsne beline iz t i opet proveravamo prefiks i sufiks
        t = t.trim();
        prefix(t, "hello");
        sufix(t, "today");

    }
    static void show(String name, String value) {
        System.out.println(name + " = \"" + value + "\"");
    }
    static void prefix(String t, String p){
        if(t.startsWith(p))
            System.out.println("\"" + p + "\" je prefiks za " + "\"" + t + "\"");
        else
            System.out.println("\"" + p + "\" nije prefiks za " + "\"" + t + "\"");

    }
    static void sufix(String t, String s) {
        if(t.endsWith(s))
            System.out.println("\"" + s + "\" je sufiks za " + "\"" + t + "\"");
        else
            System.out.println("\"" + s + "\" nije sufiks za " + "\"" + t + "\"");
    }
}
