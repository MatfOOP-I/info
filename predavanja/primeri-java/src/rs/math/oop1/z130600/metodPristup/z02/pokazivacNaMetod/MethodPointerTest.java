package rs.math.oop1.z130600.metodPristup.z02.pokazivacNaMetod;

import java.lang.reflect.*;

public class MethodPointerTest {

    public static double kvadrat(double x) {
        return x * x;
    }

    public static double eNaXminus3(double x) {
        return Math.pow(Math.E, x - 3);
    }

    public static void printTable(double from, double to, int n, Method f) {
        // print out the method as table header
        System.out.println(f);
        double dx = (to - from) / (n - 1);
        for (double x = from; x <= to; x += dx) {
            try {
                double y = (Double) f.invoke(null, x);
                System.out.printf("%10.4f | %10.4f\n", x, y);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Method square = MethodPointerTest.class.getMethod("kvadrat",
                double.class);
        System.out.println("------------------------------");
        printTable(-5, 5, 50, square);
        Method sqrt = Math.class.getMethod("sqrt", double.class);
        System.out.println("------------------------------");
        printTable(1, 10, 50, sqrt);
        Method sin = Math.class.getMethod("sin", double.class);
        System.out.println("------------------------------");
        printTable(1, 10, 50, sin);
        Method nesto = MethodPointerTest.class.getMethod("eNaXminus3",
                double.class);
        System.out.println("------------------------------");
        printTable(-5, 5, 50, nesto);
    }

}
