package primer06_wildcard;

public class Main {
    public static void main(String[] args) {
        Paket<Telefon> telefon =
                new Paket<>(new Telefon(90000));

        Paket<Sat> sat =
                new Paket<>(new Sat(30000));

        System.out.println(ProcenaPaketa.proceni(telefon));
        System.out.println(ProcenaPaketa.proceni(sat));
    }
}
