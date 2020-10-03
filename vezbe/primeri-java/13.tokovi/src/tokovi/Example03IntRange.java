package tokovi;

import java.util.stream.IntStream;

public class Example03IntRange {

    public static void main(String[] args) {
        // Trazimo kvadrate svih parnih brojeva do n.
        int n = 16;
        IntStream.range(1, n)
                .filter(x -> x % 2 == 0)
                .map(x -> x*x)
                .forEach(System.out::println);
    }
}
