class PokretanjeVisedimenzionalniiNizPretaga {

   public static void main(String[] komandnaLinija) {
      int[][][] p = {{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, {{11, 12, 13, 14, 15}, {21, 22}},
            {{101, 102, 103}, {45, 56}}};
      System.out.print("Unesite broj koji se trazi");
      java.util.Scanner citac = new java.util.Scanner(System.in);
      int brojKojiSeTrazi = citac.nextInt();
      citac.close();
      boolean pronadjen = false;
      int i = 0, j = 0, k = 0;
      najspoljasnija:
      for (i = 0; i < p.length; i++)
         for (j = 0; j < p[i].length; j++)
            for (k = 0; k < p[i][j].length; k++)
               if (p[i][j][k] == brojKojiSeTrazi) {
                  pronadjen = true;
                  break najspoljasnija;
               }
      if (pronadjen)
         System.out.println("Pronadjen [" + i + "," + j + "," + k + "]");
      else
         System.out.println("Nije pronadjen");
   }
}
