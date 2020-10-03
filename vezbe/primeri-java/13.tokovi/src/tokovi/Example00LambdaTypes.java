package tokovi;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Example00LambdaTypes {

    static Integer square_f(Integer x)
    {
        return x*x;
    }

    static Boolean even_f(Integer x)
    {
        return x % 2 == 0;
    }

    static Integer add_f(Integer x, Integer y)
    {
        return x + y;
    }

    public static void main(String[] args) {
        // Sintaksa za lambde omogucava konstrukciju anonimnih funkcija,
        // a tip u koji kompilator prevodi lambdu zavisi od konteksta u kojem
        // je iskoriscena.
        // Ovo ne treba da nas preterano interesuje jer je namena lambdi da
        // budu kratke (izraz umesto bloka naredbi), i da se najcesce konstruisu
        // pri pozivu metoda.

        Function<Integer, Integer> square = x -> x*x;
        Function<Integer, Boolean> even = x -> x % 2 == 0;
        BinaryOperator<Integer> add = (x, y) -> x + y;

        System.out.println("2*2 = " + square.apply(2));
        System.out.println("2 is even: " + even.apply(2));
        System.out.println("2 + 3 = " + add.apply(2, 3));

        System.out.println();

        System.out.println("2*2 = " + square_f(2));
        System.out.println("2 is even: " + even_f(2));
        System.out.println("2 + 3 = " + add_f(2, 3));

    }
}
