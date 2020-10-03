package racunari;

import java.util.List;

public class RacunarZaObradu extends Racunar {
    private int brojProcesora;

    public RacunarZaObradu(String ime, double cenovniKoef, int brojProcesora) {
        super(ime, cenovniKoef);
        this.brojProcesora = brojProcesora;
    }

    public int getBrojProcesora() {
        return brojProcesora;
    }

    @Override
    public double izracunajCenu(List<Integer> duzineKoriscenja) {
        double ukupnaCena = 0;
        for (int i : duzineKoriscenja) {
            ukupnaCena+=brojProcesora*Math.sqrt(i)*getCenovniKoef();
            //dodatna cena za hladjenje procesora kod sesija duzih od 1800sec
            if (i>1800) ukupnaCena+=(1800-i)*brojProcesora*0.2;
        }
        return ukupnaCena;
    }

    @Override
    public String toString() {
        return "[Obrada] "+getIme()+" sa "+brojProcesora+" procesora, koef. cene: "+getCenovniKoef();
    }
}
