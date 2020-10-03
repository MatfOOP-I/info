// Програм илуструје запис логичких литерала. 

class PokretanjeLogickiTip {

   public static void main(String[] args) {
	  //dve moguće vrednosti za logički tip
      boolean b1 = true; //tačno
      boolean b2 = false; //netačno
      
      /*vrednost logičke promenlijve se može dobiti i posredno, 
       * putem računanja vrednosti logičkog izraza.
       */
      boolean b3 = 2 > 3;
      System.out.println(b3); //ispisuje false, jer 2 nije veće od 3
   }
}
