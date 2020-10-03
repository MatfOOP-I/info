class Automobil {
   int brojTockova;
   int brojPutnika;
   float zapreminaMotora;
}

public class P050302NiskeiZ02ToStringPokretanje {
   public static void main(String[] args) {
      Object o = new Object();
      String s = o.toString();
      System.out.printf("\nniska reprezentacija objekta: %s\n", s);

      Automobil a = new Automobil();
      a.brojPutnika = 5;
      a.brojTockova = 4;
      a.zapreminaMotora = 2000;
      s = a.toString();
      System.out.printf("niska reprezentacija automobila (podrazumevana):\t%s\n", s);

      String niskaAutmobil = String.format("Automobil(putnika:%d,tockova:%d,zapremina:%f)",
            a.brojPutnika, a.brojTockova, a.zapreminaMotora);
      System.out.printf("niska reprezentacija automobila (nova):\t%s\n", niskaAutmobil);

   }

}
