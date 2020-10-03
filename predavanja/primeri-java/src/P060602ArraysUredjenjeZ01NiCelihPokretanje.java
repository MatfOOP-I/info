
class PokretanjeArraysUredjenjeNiCelih {

    public static void main(String[] args) {
        int[] niz = {23, -7, 5, 6, 4, 34, -3};
        for (int x : niz)
            System.out.print(x + " ");
        System.out.println();

        java.util.Arrays.sort(niz);

        for (int x : niz)
            System.out.print(x + " ");
        System.out.println();

    }

}
