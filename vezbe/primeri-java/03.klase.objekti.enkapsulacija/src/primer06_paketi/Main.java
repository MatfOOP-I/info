package primer06_paketi;
import primer06_paketi.model.Brojac;
import primer06_paketi.model.Odrzavanje;
public class Main {
    public static void main(String[] args) {
        Brojac brojac = new Brojac();
        brojac.uvecaj();
        System.out.println(brojac.getVrednost()); // 1
        // brojac.vrednost = 5; // private: ne kompajlira se.
        // brojac.resetuj();   // drugi paket: ne kompajlira se.
        Odrzavanje.pripremi(brojac);
        System.out.println(brojac.getVrednost()); // 0
    }
}
