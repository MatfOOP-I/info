package racunari;

import java.util.List;

public class RacunarZaCuvanje extends Racunar {
    private int velicinaDiska;
    private boolean backup;

    public RacunarZaCuvanje(String naziv, double cenovniKoef, int velicinaDiska, boolean backup) {
        super(naziv, cenovniKoef);
        this.velicinaDiska = velicinaDiska;
        this.backup = backup;
    }

    public int getVelicinaDiska() {
        return velicinaDiska;
    }


    @Override
    public double izracunajCenu(List<Integer> duzineKoriscenja) {
        double ukupnaCena = 0;
        for (int i : duzineKoriscenja)
            ukupnaCena+=velicinaDiska*0.000001*i*getCenovniKoef();
        ukupnaCena *= backup ? 1.5 : 1;
        return ukupnaCena;
    }

    @Override
    public String toString() {
        return "[Cuvanje] "+getIme()+" sa "+velicinaDiska+"MB diska(" + (backup?"":"no") + "backup), koef. cene: "+getCenovniKoef();
    }
}
