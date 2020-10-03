package ozvucenje;

public class Zvucnik {
    private String proizvodjac, model;
    private int snaga;
    private boolean ukljucen;

    public Zvucnik(String proizvodjac, String model, int snaga) {
        this.proizvodjac = proizvodjac;
        this.model = model;
        this.snaga = snaga;
        this.ukljucen = false;
    }

    public Zvucnik(Zvucnik z) {
        this.proizvodjac = z.getProizvodjac();
        this.model = z.getModel();
        this.snaga = z.getSnaga();
        this.ukljucen = z.isUkljucen();
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public String getModel() {
        return model;
    }

    public int getSnaga() {
        return snaga;
    }

    public boolean isUkljucen() {
        return ukljucen;
    }

    public void switchOnOff() {
        ukljucen = !ukljucen;
    }

    @Override
    public String toString() {
        return proizvodjac+" "+model+", snage "+snaga+"W je "+(ukljucen ? "ukljucen" : "iskljucen")+".";
    }

//    public static void main(String[] args) {
//        Zvucnik z = new Zvucnik("Yamaha", "HS8", 75);
//        Zvucnik t = new Zvucnik(z);
//        z.switchOnOff();
//        System.out.println(z);
//        System.out.println(t);
//    }
}
