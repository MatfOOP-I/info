package primer02_kasa_zavisi_od_ugovora;

public class Main {
    public static void main(String[] args) {
        Kasa prvaKasa = new Kasa(new PlacanjeGotovinom(2000));
        Kasa drugaKasa = new Kasa(new PlacanjeKarticom(4000));

        System.out.println(prvaKasa.naplati(1500));
        System.out.println(drugaKasa.naplati(1500));
    }
}
