package d_stringovi;

public class Primer01 {
    public static void main(String[] args) {
        // Pravimo promenljivu tipa String
        // Mozemo koristiti i sintaksu za pravljenje objekata.
        // String t = new String("hello world how are you today");
        String t = "hello world how are you today";

        // Ispisujemo nas string
        show("t", t);

        // Stringove poredimo koristeci metod 'equals'
        // ili metod 'equalsIgnoreCase'
        // -----------------------------------------------
        // NAPOMENA 1:
        // -----------------------------------------------
        // Stringove NE SMEMO porediti koristeci operator
        // == (osim u slucaju navedenom u napomeni 2)
        // jer on "ne cita" sta pise u stringovima nego
        // poredi da li su jednake reference promenljivih
        // (String je klasni tip)
        // -----------------------------------------------

        String s = t + "?";
        show("s", s);
        if (s.equals(t))
            System.out.println("s == t");
        else
            System.out.println("s != t");

        String s1 = "Hello world how are you TODAY" + "?";
        show("s1", s1);
        if(s1.equals(s))
            System.out.println("s1 == s");
        else
            System.out.println("s1 != s");

        if(s.equalsIgnoreCase(s1))
            System.out.println("s1 == s (ignore case)");
        else
            System.out.println("s1 != s (ignore case)");

        // Leksikografsko (alfabetsko) poredjenje stringova
        int i = s.compareTo(s1);
        if(i == 0)
            System.out.println("s1 == s");
        else if(i < 0)
            System.out.println("s1 > s");
        else
            System.out.println("s1 < s");

        // -----------------------------------------------
        // NAPOMENA 2:
        // -----------------------------------------------
        // ako u programu postoje dve ili vise istovetnih
        // String konstanti, za njih se nece praviti zasebni objekti,
        // vec ce postojati samo jedan
        // zbog toga == za njih vraca true

        String s2 = "hello world how are you today";
        show("s2", s2);
        if(s2 == t)
            System.out.println("s2 i t su jedan isti string");
        else if(t.equals(s2))
            System.out.println("t == s2");
        else
            System.out.println("s2 != t");

    }

    static void show(String name, String value) {
        System.out.println(name + " = \"" + value + "\"");
    }
}
