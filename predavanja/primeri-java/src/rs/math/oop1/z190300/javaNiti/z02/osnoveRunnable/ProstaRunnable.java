package rs.math.oop1.z190300.javaNiti.z02.osnoveRunnable;


import static java.lang.Thread.sleep;

public class ProstaRunnable extends Imenovan implements Runnable
{
    public ProstaRunnable(String str)
    {
        super(str);
    }

    public void run()
    {
        for (int i = 0; i < 15; i++)
        {
            System.out.println(i + " " + vratiIme());
            try
            {
                sleep((long) (Math.random() * 1000));
            }
            catch (InterruptedException e)
            {
            }
        }
        System.out.println("GOTOVO! " + vratiIme());
    }
}