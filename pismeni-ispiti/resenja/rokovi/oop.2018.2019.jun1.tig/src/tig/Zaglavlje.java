package tig;

public class Zaglavlje {
    private String autor;
    private String vremenskaOznaka;

    public String getVremenskaOznaka() {
        return vremenskaOznaka;
    }

    public Zaglavlje(String autor, String vremenskaOznaka) {
        this.autor = autor;
        this.vremenskaOznaka = vremenskaOznaka;
    }

    public String getAutor() {
        return autor;
    }

    public static void main(String[] args) {
        Zaglavlje z = new Zaglavlje("nemanja", "31.05.2019 14:31");
        System.out.println(z);
    }

    @Override
    public String toString() {
        return autor + " " + vremenskaOznaka;
    }
}
