import java.util.Scanner;

class PokretanjeDvodimenzionalniiNizSistemJednacina {

    static double[][] ucitajMatricuSistema(Scanner ulaz, int n) {
        System.out.println("Elementi matrice sistema su");
        double mat[][] = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = ulaz.nextDouble();
        return mat;
    }

    static double[] ucitajSlobodneClanoveSistema(Scanner ulaz, int n) {
        System.out.println("Elementi vektora slobodnih clanova su");
        double mat[] = new double[n];
        for (int i = 0; i < n; i++)
            mat[i] = ulaz.nextDouble();
        return mat;
    }

    static void prikazi(double[][] a, double[] b) {
        System.out.println("Sistem jednacina je");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                System.out.printf("%15.4f", a[i][j]);
            System.out.printf(" - %15.4f", b[i]);
            System.out.println();
        }
    }

    static double[][] iskljuci(double[][] a, int i, int j) {
        int n = a.length;
        double[][] mat = new double[n - 1][n - 1];
        for (int ii = 0; ii < i; ii++)
            for (int jj = 0; jj < j; jj++)
                mat[ii][jj] = a[ii][jj];
        for (int ii = i; ii < n - 1; ii++)
            for (int jj = 0; jj < j; jj++)
                mat[ii][jj] = a[ii + 1][jj];
        for (int ii = 0; ii < i; ii++)
            for (int jj = j; jj < n - 1; jj++)
                mat[ii][jj] = a[ii][jj + 1];
        for (int ii = i; ii < n - 1; ii++)
            for (int jj = j; jj < n - 1; jj++)
                mat[ii][jj] = a[ii + 1][jj + 1];
        return mat;
    }

    static double determinanta(double[][] a) {
        int n = a.length;
        if (n == 1)
            return a[0][0];
        if (n == 2)
            return a[0][0] * a[1][1] - a[1][0] * a[0][1];
        double det = 0;
        double znak = 1;
        for (int j = 0; j < n; j++) {
            double[][] aa = iskljuci(a, 0, j);
            det += znak * a[0][j] * determinanta(aa);
            znak = -znak;
        }
        return det;
    }

    public static double[][] zameni(double[][] a, double[] b, int kolona) {
        int n = a.length;
        double[][] rezultat = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                rezultat[i][j] = a[i][j];
        for (int i = 0; i < n; i++)
            rezultat[i][kolona] = b[i];
        return rezultat;
    }

    private static void resiPrikazi(int n, double[][] a, double[] b) {
        double det = determinanta(a);
        for (int j = 0; j < n; j++)
            System.out.println("x_" + (j + 1) + "="
                    + determinanta(zameni(a, b, j)) / det);
    }

    public static void main(String[] args) {
        Scanner ulaz = new Scanner( "3 1 2 3 1 1 -1 2 3 8 0 1 2" );
        //Scanner ulaz = new Scanner(System.in);
        System.out.println("Dimenzija kvadratne matrice");
        int n = ulaz.nextInt();
        double[][] a = ucitajMatricuSistema(ulaz, n);
        double[] b = ucitajSlobodneClanoveSistema(ulaz, n);
        prikazi(a, b);
        resiPrikazi(n, a, b);
        ulaz.close();
    }

}
