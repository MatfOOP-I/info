package rs.math.oop1.z090201.unutrasnje.z02.dogadjaji;

public class Radnik extends Covek {

   public Radnik(String ime, int status) {
      super(ime, status);
   }

   public Radnik(String ime) {
      this(ime, Status.SPAVANJE);
   }

   @Override
   public String toString() {
      return String.format("Radnik '%s' (%s)", getIme(), Status.opis(getStatus()));
   }

}