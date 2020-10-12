package rs.math.oop1.z070401.definicjeMetoda.z07.digitronPostfiksni;

class DigitronPostfiksni {
   StekNiski operatori;
   StekRealnihBrojeva argumenti;

   void init() {
      operatori = new StekNiski();
      argumenti = new StekRealnihBrojeva();
   }

   double izracunaj(String ulaz) {
      operatori.init();
      argumenti.init();
      java.util.Scanner skener = new java.util.Scanner(ulaz);
      while (skener.hasNext()) {
         String s = skener.next().trim();
         if (s.equals("+") || s.equals("-") || s.equals("*")
                  || s.equals("/") || s.equals("~"))
            operatori.push(s);
         else
            argumenti.push(Double.parseDouble(s));
         while (operatori.brojElemenata() > 0)
            operacija();
      }
      skener.close();
      while (operatori.brojElemenata() > 0)
         operacija();
      return argumenti.pop();
   }

   void operacija() {
      String operator = operatori.pop();
      double x;
      double y;
      switch (operator) {
      case "+":
         x = argumenti.pop();
         y = argumenti.pop();
         argumenti.push(y + x);
         break;
      case "-":
         x = argumenti.pop();
         y = argumenti.pop();
         argumenti.push(y - x);
         break;
      case "*":
         x = argumenti.pop();
         y = argumenti.pop();
         argumenti.push(y * x);
         break;
      case "/":
         x = argumenti.pop();
         y = argumenti.pop();
         argumenti.push(y / x);
         break;
      case "~":
         x = argumenti.pop();
         argumenti.push(-x);
         break;
      default:
         System.out.println("Doslo je do greske!");
      }
   }
}
