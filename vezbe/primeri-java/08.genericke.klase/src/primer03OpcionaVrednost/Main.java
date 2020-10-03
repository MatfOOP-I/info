package primer03OpcionaVrednost;

public class Main
{
    public static void main(String[] args)
    {
        primer01();
        System.out.println("\n------------------------\n");
        primer02();
    }

    private static void primer01() {
        OpcionaVrednost<String> result = Poruka.procitajPoverljivuPoruku();
        // Kada nam funkcija vraca opcionu vrednost, to je jasan indikator da njen poziv
        // moze biti neuspesan i da je vrlo vazno da proverimo dobijeni rezultat.
        // PITANJE za vas? Koja je mana nase klase OpcionaVrednost?
        // HINT: Kako cete saznati do kakve greske je doslo?
        // DOMACI: Napravite klasu OpcionaVrednostSaGreskom koja dodatno sadrzi informaciju
        // o gresci koja se desila -> Na primer ima metod error() koje vraca poruku o gresci.

        if (result.postoji()) {
            System.out.println("Citanje je proslo uspesno! Sadrzaj:\n\n" + result.getVrednost());
        } else {
            System.out.println("Neuspelo citanje...");
        }
    }

    private static void primer02()
    {
        Integer[] xs = {1, 2, 3, 4, 100, 40, 20};
        OpcionaVrednost<Integer> maksX = nadjiMaksimum(xs);
        if (maksX.postoji()) {
            System.out.println("maksimum(xs) = " + maksX);
        } else {
            System.out.println("Prosledjen je prazan niz!");
        }

        Integer[] ys = {};
        OpcionaVrednost<Integer> maksY = nadjiMaksimum(ys);
        if (maksX.postoji()) {
            System.out.println("maksimum(ys) = " + maksY);
        } else {
            System.out.println("Prosledjen je prazan niz!");
        }
    }

    // Ako zelimo da nametnemo uslov da je T nesto sto moze da se poredi,
    // mozemo zahtevati da je T primerak interfejsa Comparable<T> koji nudi
    // metod a.compareTo(b) koji vraca:
    // < 0 ako je a < b
    // = 0 ako je a == b
    // > 0 ako je a > b
    private static <T extends Comparable<T>> OpcionaVrednost<T> nadjiMaksimum(T[] xs)
    {
        // Ako je prosledjen prazan niz, maksimum ne postoji
        // pa vracamo praznu opcionu vrednost.
        if (xs.length == 0)
            return OpcionaVrednost.prazan();

        T maksimum = null;
        boolean first = true;
        for (T x: xs) {
            if (first) {
               maksimum = x;
               first = false;
            } else if (x.compareTo(maksimum) > 0) {
                maksimum = x;
            }
        }

        return OpcionaVrednost.od(maksimum);
    }
}
