package primer04Par;

public class Main
{
    public static void main(String[] args)
    {
        UredjeniPar<String, Integer> p = new UredjeniPar<>("Python", 100);
        UredjeniPar<String, Integer> q = dveVrednosti();
        System.out.println(p);
        System.out.println(q);
    }

    // Vracanje dve vrednosti iz funkcije?
    private static UredjeniPar<String, Integer> dveVrednosti()
    {
        return new UredjeniPar<>("Java", 80);
    }
}
