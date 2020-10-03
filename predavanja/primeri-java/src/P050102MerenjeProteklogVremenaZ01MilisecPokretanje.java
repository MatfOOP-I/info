class PokretanjeMerenjeProteklogVremenaMiliSec {

    public static void main(String[] komandnaLinija) {

        int n = 10_000;
        long vremePocetka = System.currentTimeMillis();
        double s = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                s++;
        }
        long trajanje = System.currentTimeMillis() - vremePocetka;
        System.out.println("Argument: " + n);
        System.out.println("Rezultat: " + s);
        System.out.println("Trajanje racunanja (s): " + trajanje / 1e3);
    }

}
