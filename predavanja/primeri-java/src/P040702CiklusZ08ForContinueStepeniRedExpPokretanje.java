/*

Написати Јава програм који за дато x приближно рачуна exp(x) 
коришћењем степеног реда. 

Приликом рачунања степеног реда, сабрати не више brojSabiraka
чланова степеног реда.

Ако је вредност сабирака мања од унапред задате вредности epsilon,
тада се тај сабирак не треба додати, али треба наставити са 
додавањем елемената у степени ред.

*/

// Задатак представља илустрацију коришћења необележене наредбе continue.

class PokretanjeForContinueStepeniRedExp {

   public static void main(String[] args) {
      double x = 1.00001;
      int brojSabiraka = 300;
      double epsilon = 1e-7;
      double suma = 1;
      for (int n = 1;; n++) {
         double stepen = 1;
         for (int i = 1; i <= n; i++)
            stepen *= x;
         double faktorijel = 1;
         for (int i = 1; i <= n; i++)
            faktorijel *= i;
         double sabirak = stepen / faktorijel;
         if (n > brojSabiraka)
            break;
         if (sabirak < epsilon)
            continue;
         suma += sabirak;
      }
      System.out.println(
               "Aproksimacija za exp(" + x + ")=" + suma);
   }
}
