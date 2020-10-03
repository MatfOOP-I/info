package rs.math.oop1.z080402.solid.z02.dobarSServisi;

public class PodesavanjaZaKorisnikaServis {

   public void promeniEmailAdresu(Korisnik korisnik) {
      if (SigurnostServis.proveriPristup(korisnik)) {
         // Korisnik ima pravo da promeni e-mail,
         // pa se realizuje promena
      }
   }

}
