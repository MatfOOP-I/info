package primer05GenerickiStekDomaciResenje;

import primer05GenerickiStek.Tacka;

import java.util.Optional;

public class Main
{
    public static void main(String[] args)
    {
        int n = 5;
        MatfStek<Tacka> tacke = new MatfStek<>();

        for (int i = 0; i < n; i++) {
            tacke.push(new Tacka(i+1, (i+1)*10));
        }

        System.out.println(tacke);

        System.out.println("Tacka na vrhu steka: " + tacke.peek());
        Optional<Tacka> t = tacke.pop();
        System.out.println("Skinuta tacka " + t + " sa vrha steka.");
        System.out.println("Tacka na vrhu steka: " + tacke.peek());
    }
}
