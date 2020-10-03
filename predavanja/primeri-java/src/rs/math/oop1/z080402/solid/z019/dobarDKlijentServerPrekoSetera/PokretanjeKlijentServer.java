package rs.math.oop1.z080402.solid.z019.dobarDKlijentServerPrekoSetera;

public class PokretanjeKlijentServer {

   public static void main(String[] args){
      Servis sB = new ServisB();
      Servis sC = new ServisC();
      Servis sD = new ServisD();

      KlijentA ka = new KlijentA(sB);
      ka.uradiNesto();

      ka.setServis(sC);
      ka.uradiNesto();

      ka.setServis(sD);
      ka.uradiNesto();
   }

}
