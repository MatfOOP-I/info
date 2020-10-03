
class PokretanjeArraysUredjenjeNizNiski {

    public static void main(String[] args) {
//        String[] niz = {"23", "-7", "5", "54", "6", "4", "34", "-23"};
//        for (String x : niz)
//            System.out.print(x + " ");
//        System.out.println();
//        java.util.Arrays.sort(niz);
//        for (String x : niz)
//            System.out.print(x + " ");
//        System.out.println();

        String[] niz2 = {"Miki", "Paja", "Mini", "Silja", "Mirko", "Slavko"};
        System.out.println("Pre sortiranja");
        for (String s : niz2)
            System.out.print(s + " ");
        System.out.println();
        java.util.Arrays.sort(niz2);
        System.out.println("Posle sortiranja");
        for (String s : niz2)
            System.out.print(s + " ");
        System.out.println();
    }

}
