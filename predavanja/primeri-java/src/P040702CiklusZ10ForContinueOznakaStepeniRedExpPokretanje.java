/*

Написати Јава програм који за дато x приближно рачуна exp(x) 
коришћењем степеног реда. 

Приликом рачунања степеног реда, сабрати не више brojSabiraka
чланова степеног реда.

У степени ред не додавати сабирке код којих је вредност имениоца сабирка
или бројиоца сабирка већа од унапред задате вредности max, али наставити
са поступком сабирања.

*/

// Задатак представља илустрацију коришћења обележене наредбе continue.

class PokretanjeForContinueOznakaStepeniRedExp {

   public static void main(String[] args) {
      double x = 1.00001;
      int brojSabiraka = 300;
      double max = 1e+7;
      double suma = 1;
      sumiranje: for (int n = 1; n <= brojSabiraka; n++) {
         double stepen = 1;
         for (int i = 1; i <= n; i++) {
            stepen *= x;
            if (stepen > max)
               continue sumiranje;
         }
         double faktorijel = 1;
         for (int i = 1; i <= n; i++) {
            faktorijel *= i;
            if (faktorijel > max)
               continue sumiranje;
         }
         double sabirak = stepen / faktorijel;
         suma += sabirak;
      }
      System.out.println(
               "Aproksimacija za exp(" + x + ")=" + suma);
   }
}
