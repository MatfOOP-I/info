package rs.math.oop1.z090201.unutrasnje.z02.dogadjaji;

import rs.math.oop1.z080501.dogadjaji.z03.koriscenje.Cvet;

public class NocnaFrajla extends Cvet  {
   @Override
   public String toString() {
      return String.format("Noćna frajla{%x}", this.hashCode()) ;
   }
}
