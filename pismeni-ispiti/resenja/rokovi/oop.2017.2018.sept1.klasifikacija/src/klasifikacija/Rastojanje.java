package klasifikacija;

public class Rastojanje
{
    public static double izracunajRastojanje(Podatak p1, Podatak p2)
    {
        return Math.sqrt((p1.getVisina()-p2.getVisina())*(p1.getVisina()-p2.getVisina()) +
                (p1.getTezina()-p2.getTezina())*(p1.getTezina()-p2.getTezina()));
    }

}
