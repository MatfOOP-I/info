package klasifikacija;

public class KSusedaPar implements Comparable<KSusedaPar>
{
    private int indeksUPodacima;
    private double rastojanje;

    public int getIndeksUPodacima()
    {
        return indeksUPodacima;
    }

    public double getRastojanje()
    {
        return rastojanje;
    }

    public KSusedaPar(int indeksUPodacima, double rastojanje)
    {

        this.indeksUPodacima = indeksUPodacima;
        this.rastojanje = rastojanje;
    }

    @Override
    public int compareTo(KSusedaPar o)
    {
        return Double.compare(getRastojanje(), o.getRastojanje());
//        return Double.compare(o.getRastojanje(), getRastojanje());
    }
}
