/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package rs.math.oop1.z180201.funkcionalniInterfejsi.z01.koriscenje;

public class FunkcionalniInterfejs {
    public interface Sample1 {
        boolean test(int input);
    }

    @FunctionalInterface
    public interface Sample2 {
        boolean test(int input);

        //int increment(int argument);
    }

    @FunctionalInterface
    public interface Sample3 {
        boolean test(int input);

        default int increment(int argument) {
            return (argument + 1);
        }
    }

    public static void main(final String[] args) {
        Sample1 sample1 = input -> true;
        System.out.println(sample1.test(42));

        Sample2 sample2 = input -> (input < 10);
        System.out.println(sample2.test(42));

        Sample3 sample3 = input -> (input > 10);
        System.out.println(sample3.test(42));
        System.out.println(sample3.increment(42));
    }
}
