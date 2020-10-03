package primer01GenerickaFunkcija;

public class GenerickaFunkcija
{
    // Parametar <T> navodimo kako bi naznacili da je u pitanju genericki tip T
    // koji se na dalje koristi u definiciji funkcije.
    public static <T> void print(T a)
    {
        System.out.println(a.toString());
    }

    public static void main(String[] args)
    {
        print(5);
        print("Hello world");
        print(new Tacka(2, 3));
    }
}
