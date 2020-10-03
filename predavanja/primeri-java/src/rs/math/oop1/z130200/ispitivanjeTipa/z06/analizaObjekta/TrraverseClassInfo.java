package rs.math.oop1.z130200.ispitivanjeTipa.z06.analizaObjekta;

import java.util.Scanner;

public class TrraverseClassInfo {

    public static void main(String[] args)
    {
        traverse( "Miki Maus");
        System.out.println("---");
        traverse(new Scanner(System.in));
    }

    public static void traverse(Object o){
        for (int n = 0; ; o = o.getClass())
        {
            System.out.println("L"+ ++n + ": " + o + ".getClass() = " + o.getClass());
            if (o == o.getClass())
                break;
        }
    }
}
