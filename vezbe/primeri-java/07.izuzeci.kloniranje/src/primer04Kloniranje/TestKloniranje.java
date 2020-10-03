package primer04Kloniranje;

public class TestKloniranje{
    public static void main(String[] args){
        try {

            /* Kloniranje u Javi je jednostavan nacin kopiranja objekata
            Koraci:
            - Implementirati Cloneable interfejs
            - Definisati clone() metod koji handluje ili baca CloneNotSupportedException
            - U vecini slucajeva, pozvati clone() metod natklase

            Lanac pozivanja super.clone() se nastavlja do Object.clone() koji vrsi "memcopy"

            Prednosti kloniranja:
            - Jednostavno, kratak kod
            - Najlaksi nacin za vec postojece hijerarhije - lako se dodaje metod clone
            - Najbrzi nacin za kopiranje nizova

            Mane kloniranja:
            - Dosta sintakse oko poziva clone() (videti ispod) - definisati metod, handlovati exception i kastovanje
            - Cloneable je marker interfejs i moramo rucno implementirati clone() - ne postoji deklaracija
            - Object.clone() je protected, ne public
            - Nemamo kontrolu nad konstrukcijom jer se ne pozivaju konstruktori
            - super.clone() lanac moze da se prekine ako jedna klasa u hijerarhiji ne implementira clone()
            - Object.clone() radi plitko kopiranje - sto ovaj primer ilustruje - inace moramo rucno pozvati clone za
              sve klase koje nasa klasa sadrzi - i one moraju implementirati Cloneable
            - i jos puno toga :)
            */

            PasLjubimac mojLjubimac = new PasLjubimac("Maza", "Mesanac");
            PasLjubimac vasLjubimac = (PasLjubimac) mojLjubimac.clone();

            // Menjamo ime kloniranog psa - ne menja se ime originalnog psa
            vasLjubimac.setIme("Lunja");

            // Menjamo ime buve kloniranog psa - posto je kopija plitka, menja se i
            // ime buve originanog psa
            vasLjubimac.getBuva().setIme("Buvica");

            System.out.println( "\n - Detalji o Vasem psu:\n" + vasLjubimac);
            System.out.println( "\n - Detalji o mom psu:\n" + mojLjubimac);

            // Ako hocemo da kloniramo i buvu, moramo to eksplicitno uraditi
            Buva klonBuva = (Buva) vasLjubimac.getBuva().clone();
            mojLjubimac.setBuva(klonBuva);

            mojLjubimac.getBuva().setIme("KloniranaBuva");

            System.out.println("\n--- Posle kloniranja buve: ---");

            System.out.println( "\n - Detalji o Vasem psu:\n" + vasLjubimac);
            System.out.println( "\n - Detalji o mom psu:\n" + mojLjubimac);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        } finally {

        }
    }
}
