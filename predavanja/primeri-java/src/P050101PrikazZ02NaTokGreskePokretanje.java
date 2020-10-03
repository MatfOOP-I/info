public class P050101PrikazZ02NaTokGreskePokretanje {

    public static void main(String[] komandnaLinija)
    {
        double x  = zbir(40, 2.0);
        System.err.print(x);
        System.err.println();
        System.err.println( x );
        System.err.printf( "%6.0f\n", x );
        System.err.printf( "%6.2f\n", x );

        System.err.println( "Suma je " + x + "!" );
        System.err.printf( "Suma je %8.0f!\n", x );

    }

    static double zbir(int x, double y)
    {
        return x+y;
    }
}
