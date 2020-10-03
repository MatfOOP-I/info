package ozvucenje;

public class Skladiste extends Prostorija {
    private double preostaloMestaZaPalete, dimenzijaPalete;

    public Skladiste(String naziv, double duzina, double sirina, double dimenzijaPalete) {
        super(naziv, duzina, sirina);
        this.dimenzijaPalete = dimenzijaPalete;
        this.preostaloMestaZaPalete = sirina*duzina;
    }

    public double getPreostaloMestaZaPalete() {
        return preostaloMestaZaPalete;
    }

    public double getDimenzijaPalete() {
        return dimenzijaPalete;
    }

    public void setPreostaloMestaZaPalete(double preostaloMestaZaPalete) {
        this.preostaloMestaZaPalete = preostaloMestaZaPalete;
    }

    public void setDimenzijaPalete(double dimenzijaPalete) {
        this.dimenzijaPalete = dimenzijaPalete;
    }

    // pogledati da li je formulacija u zadatku jasna (3. zadatak 3. bullet)
//    void dodajPalete(int brojPaleta) {
//        int mozeSeUbaciti = (int)((povrsina - zauzetaPovrsina)/velicinaPalete);
//
//        if (brojPaleta <= mozeSeUbaciti) {
//            zauzetaPovrsina += brojPaleta * velicinaPalete;
//            System.out.println("Uspesno su smestene sve palete!");
//        } else if (mozeSeUbaciti != 0) {
//            zauzetaPovrsina += mozeSeUbaciti * velicinaPalete;
//            System.out.println("Uspesno je smesteno " + mozeSeUbaciti + " od " + brojPaleta + " paleta.");
//        } else {
//            System.out.println("Neuspesno smestanje, skladiste je puno!");
//        }
//
//    }

    void dodajPalete(int brojPaleta) {
        int maksimalnoPaleta = (int)(duzina/dimenzijaPalete) * (int)(sirina/dimenzijaPalete);
        int popunjenoPaleta = (int)((duzina*sirina - preostaloMestaZaPalete)/(dimenzijaPalete*dimenzijaPalete));
        int mozeSeUbaciti = maksimalnoPaleta - popunjenoPaleta;

        if (brojPaleta <= mozeSeUbaciti) {
            preostaloMestaZaPalete -= brojPaleta * dimenzijaPalete*dimenzijaPalete;
            System.out.println("Uspesno su smestene sve palete!");
        } else if (mozeSeUbaciti != 0) {
            preostaloMestaZaPalete -= mozeSeUbaciti * dimenzijaPalete*dimenzijaPalete;
            System.out.println("Uspesno je smesteno " + mozeSeUbaciti + " od " + brojPaleta + " paleta.");
        } else {
            System.out.println("Neuspesno smestanje, skladiste je puno!");
        }
    }

    void iznesiPaletu() {
        if (preostaloMestaZaPalete != duzina*sirina) {
            preostaloMestaZaPalete += dimenzijaPalete*dimenzijaPalete;
            System.out.println("Uspesno izneta paleta.");
        } else {
            System.out.println("Neuspesno iznosenje, skladiste je prazno.");
        }
    }

    @Override
    public String toString() {
        return "Skladiste "+naziv+" povrsine "+(duzina*sirina)+"m^2 (slobodno "+ (preostaloMestaZaPalete) +"m^2).";
    }
}
