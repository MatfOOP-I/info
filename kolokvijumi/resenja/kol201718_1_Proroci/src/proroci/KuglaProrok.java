package proroci;

public class KuglaProrok extends Prorok {
    private String tipKristala;

    private static String[] reciProrocanstvo = {
            "Godine 2020. bice 2020. godina!",
            "Sledece godine iPhone ce biti jos skuplji.",
            "Sutra ce biti vrucina.",
            "Godine 2018. na kolokvijumu iz OOP-a nece biti polimorfizma"
    };

    private static int i;

    public KuglaProrok(String ime, int ostvarenoProrocanstava, int ukupnoProrocanstava, String tipKristala) {
        super(ime, ostvarenoProrocanstava, ukupnoProrocanstava);
        if (!tipKristala.equals("monociklicni") && !tipKristala.equals("tetragonalni") && !tipKristala.equals("kineski"))
            this.tipKristala = "kineski";
        else
            this.tipKristala = tipKristala;
    }

    public KuglaProrok(Prorok p) {
        super(p);
    }

    public String getTipKristala() { return tipKristala; }

    public String proreci() {
        String prorocanstvo = reciProrocanstvo[i];

        i = (i+1)%reciProrocanstvo.length;

        return prorocanstvo;
    }

    @Override
    public String toString() {
        return "[kugla prorok] " + super.toString() + " tip kristala: " + tipKristala;
    }
}
