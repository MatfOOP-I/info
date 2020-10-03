package rs.math.oop1.z080402.solid.z018.dobarDKlijentServerPrekoKonstruktora;

public class PokretanjeKlijentServer {

   public static void main(String[] args){
      Servis sB = new ServisB();
      Servis sC = new ServisC();
      Servis sD = new ServisD();

      Klijent ka = new KlijentA(sB);
      ka.uradiNesto();

      ka = new KlijentA(sC);
      ka.uradiNesto();

      ka = new KlijentA(sD);
      ka.uradiNesto();
   }

}
