/*
 
 Написати Јава програм који мери време протекло између два 
 узастопна притиска на тастер <Enter>.
 
 */

public class P050502SkenerUlazZ04UzastopniPritisakProtekloVremei {

   public static void main(String[] args) {
      java.util.Scanner skener = new java.util.Scanner(System.in);
      System.out.println("Pritisni dva puta taster <Enter> !!!");
      skener.nextLine();
      long vremePocetka = System.nanoTime();
      System.out.println("Jos jednom pritisni taster <Enter> !!!");
      skener.nextLine();
      double trajanje = (System.nanoTime() - vremePocetka) / 1e9;
      System.out.printf("Izmedju dva pritiska je proteklo %f sekundi!", trajanje);
      skener.close();
   }

}
