/*

Написати Јава програм који одређује степен датог
реалног броја (основе) датим природним изложиоцем.

*/

// Задатак представља илустрацију коришћења наредбе циклуса do while

class PokretanjeDoWhileStepenovanje {

   public static void main(String[] args) {
      int n = 10;
      double x = 2;
      double stepen = 1;
      int i = 1;
      do {
         stepen *= x;
         i++;
      } while (i <= n);
      System.out.println(x + "^" + n + "=" + stepen);
   }
}
