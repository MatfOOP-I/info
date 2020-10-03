/*

Написати Јава програм који омогућује погађање замишљеног псеудослучајног 
целог броја из датог интервала.

Крајеви интервала у ком се налази замишљени број се дају преко командне линије,
а ако нису дати на тај начин, онда се очитавају са улаза.

Одређивање броја који се погађа реализовати на више начина. Метод за одређивање
се такође даје преко командне линије, а ако није дат на тај начин, онда се 
очитавају са улаза.

*/

// Задатак илуструје рад са псеудослучајним бројевима, као и рад са аргументима
// командне линије

public class P050601MatematikaZ04ZamisljeniBrojPokretanje {

   static int zamisli(int a, int b, int metod) {
      switch (metod) {
         case 1:
            return (int) (a + Math.random() * (b - a));
         case 2:
            java.util.Random generator = new java.util.Random();
            return a + generator.nextInt(b - a);
         case 3:
            java.util.Random generator2 = new java.util.Random();
            return (int) ((b - a) / 2 + (b - a)
                  * generator2.nextGaussian() / 2);
         default:
            return -1;
      }
   }

   public static void main(String[] argumentiKomandneLinije) {
      int min = 0;
      int max = 1;
      int metod = 1;
      java.util.Scanner skener = new java.util.Scanner(
            System.in);
      if (argumentiKomandneLinije.length == 3) {
         min = Integer.parseInt(argumentiKomandneLinije[0]);
         max = Integer.parseInt(argumentiKomandneLinije[1]);
         metod = Integer.parseInt(argumentiKomandneLinije[2]);
      } else {
         System.out.print(
               "Unesi donju i gornju granicu intervala,");
         System.out.println("a potom metod izbora (1/3)");
         min = skener.nextInt();
         max = skener.nextInt();
         metod = skener.nextInt();
      }
      System.out.println("Zamislio sam broj u intervalu "
            + min + " - " + max);
      int zamisljenBroj = 0;
      while (!(zamisljenBroj >= min
            && zamisljenBroj <= max))
         zamisljenBroj = zamisli(min, max, metod);
      int pokusaj = 0;
      int brojPokusaja = 0;
      do {
         System.out.println("Tvoj broj:");
         pokusaj = skener.nextInt();
         brojPokusaja++;
         if (zamisljenBroj > pokusaj)
            System.out.println("Zamisljeni broj je veci!");
         if (zamisljenBroj < pokusaj)
            System.out.println("Zamisljeni broj je manji!");
      } while (pokusaj != zamisljenBroj);
      skener.close();
      System.out
            .println("Cestitamo! Pogodjen je zamisljen broj "
                  + zamisljenBroj + " u "
                  + brojPokusaja + " pokusaja.");
   }

}
