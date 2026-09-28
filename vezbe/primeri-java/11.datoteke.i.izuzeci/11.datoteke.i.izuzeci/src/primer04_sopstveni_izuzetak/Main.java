package primer04_sopstveni_izuzetak;

public class Main {
    public static void main(String[] args) {
        String[] redovi = {
                "Ana,Jovanovic,22,Rim",
                "Marko,Petrovic,abc,Pariz",
                "Milica,Ilic,31,Atina"
        };

        for (String red : redovi) {
            try {
                Rezervacija rezervacija =
                        ParserRezervacije.parsiraj(red);

                System.out.println(rezervacija.opis());
            } catch (NeispravanRedException e) {
                System.out.println(
                        "Preskačem red: " + e.getMessage()
                );
            }
        }
    }
}
