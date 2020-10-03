
class Knjiga {
   int godinaIzdavanja;
   String naslov;
   String autor;
}

public class P070101KlasaDefinicijaZ01KnjigePokretanje {

   public static void main(String[] args) {
      Knjiga k1;

      k1 = new Knjiga();
      k1.autor = "Petar Petrović Njegoš";
      k1.godinaIzdavanja = 1976;
      k1.naslov = "Gorski vijenac";

   }
}
