class PokretanjeMerenjeProteklogVremenananoSec {

    public static void main(String[] komandnaLinija) {

        int n = 100_000;
        long vremePocetka = System.nanoTime();
        double s = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                s++;
        }
        long trajanje = System.nanoTime() - vremePocetka;
        System.out.println("Argument: " + n);
        System.out.println("Rezultat: " + s);
        System.out.println("Trajanje racunanja (s): " + trajanje / 1e9);
    }

}