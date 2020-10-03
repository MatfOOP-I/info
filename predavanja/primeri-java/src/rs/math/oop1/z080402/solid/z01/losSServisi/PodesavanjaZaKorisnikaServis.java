package rs.math.oop1.z080402.solid.z01.losSServisi;

public class PodesavanjaZaKorisnikaServis {

   public void promeniEmailAdresu(Korisnik korisnik) {
      if (proveriPristup(korisnik)) {
         // Korisnik ima pravo da promeni e-mail,
         // pa se realizuje promena
      }
   }

   public boolean proveriPristup(Korisnik korisnik) {
      // Proverava se da li kosrinik ima pristup
      return true;
   }
}
