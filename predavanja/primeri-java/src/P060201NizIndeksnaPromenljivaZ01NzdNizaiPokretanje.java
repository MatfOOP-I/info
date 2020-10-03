class PokretanjeNzdNiza {
   // одређивање НЗД за два броја
   static int NZD(int prvi, int drugi) {
      while (true)
         if (prvi > drugi)
            // први је већи
            if (prvi % drugi == 0)
               return drugi;
            else
               prvi %= drugi;
         else
            // први је мањи или једнак
            if (drugi % prvi == 0)
               return prvi;
            else
               drugi %= prvi;
   }

   // улазна тачка програма
   public static void main(String[] argumenti) {
      // низ чији се НЗД тражи
      int[] niz = {24, 48, 96, 192, 36, 72, 144,
            (int) (Math.random() * 56) * 4};
      // приказ низа
      System.out.print("Низ: ");
      for (int i = 0; i < niz.length; i++)
         System.out.print(niz[i] + " ");
      System.out.println();
      // одређивање НЗД-а коришћењем бројачког for циклуса
      int nzd = niz[0];
      for (int i = 1; i < niz.length; i++)
         nzd = NZD(nzd, niz[i]);
      // приказ резултата
      System.out.print("НЗД низа: " + nzd);
   }
}
