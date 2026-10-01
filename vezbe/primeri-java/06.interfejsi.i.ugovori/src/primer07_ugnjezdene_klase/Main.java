package primer07_ugnjezdene_klase;
public class Main {
    public static void main(String[] args) {
        Klub klub = new Klub("Čitaonica");
        Klub.ClanskaKartica kartica = new Klub.ClanskaKartica(12);
        Klub.Sluzba sluzba = klub.new Sluzba();
        System.out.println(kartica.getBroj());
        System.out.println(sluzba.pozdrav());
        System.out.println(klub.porukaZa("Ana"));
        Runnable obavestenje = new Runnable() {
            @Override public void run() { System.out.println("Sastanak u 18h."); }
        };
        obavestenje.run(); // Anonimna klasa; ne pokrećemo posebnu nit.
    }
}
