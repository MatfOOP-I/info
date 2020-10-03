public class P050702DatumVremeZ01LocalTimePokretanje {
   public static void main(String[] args) {
      java.time.LocalTime vreme1 = java.time.LocalTime.now();
      java.time.LocalTime vreme2 = java.time.LocalTime.parse("23:15:45");
      java.time.LocalTime vreme3 = java.time.LocalTime.of( 23, 15, 45);

      System.out.println("vreme1: " + vreme1);
      System.out.println("vreme2: " + vreme2);
      System.out.println("vreme3: " + vreme3);

      java.time.format.DateTimeFormatter formater = java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss.n");
      System.out.printf("\nvreme1 (custom format): %s\n", vreme1.format(formater));
      System.out.printf("vreme2 (custom format): %s\n", vreme2.format(formater));
      System.out.printf("vreme3 (custom format): %s\n\n", vreme3.format(formater));

      java.time.format.DateTimeFormatter formater2 = java.time.format.DateTimeFormatter.ISO_TIME;
      System.out.printf("\nvreme1 (ISO format): %s\n", vreme1.format(formater2));
      System.out.printf("vreme2 (ISO format): %s\n", vreme2.format(formater2));
      System.out.printf("vreme3 (ISO format): %s\n\n", vreme3.format(formater2));

      if (vreme1.equals(vreme2))
         System.out.println("prva dva vremena su jednaka (equals)");
      else
         System.out.println("prva dva vremena nisu jednaka (equals)");
      if (vreme1.equals(vreme3))
         System.out.println("prvo i trece vreme su jednaki (equals)");
      else
         System.out.println("prvo i trece vreme nisu jednaki (equals)");
      if (vreme2.equals(vreme3))
         System.out.println("poslednja dva vremena su jednaka (equals)");
      else
         System.out.println("poslednja dva vremena nisu jednaka (equals)");

      System.out.println("\nporedjenje prvog i drugog vremena (compare) daje rezultat "
            + vreme1.compareTo(vreme2));
      System.out.println("poredjenje drugog i prvog vremena (compare) daje rezultat "
            + vreme2.compareTo(vreme1));
      System.out.println("poredjenje prvog i treceg vremena (compare) daje rezultat "
            + vreme1.compareTo(vreme3));
      System.out.println("poredjenje treceg i prvog vremena (compare) daje rezultat "
            + vreme3.compareTo(vreme1));
      System.out.println("poredjenje drugog i treceg vremena (compare) daje rezultat "
            + vreme2.compareTo(vreme3));
      System.out.println("poredjenje treceg i drugog vremena (compare) daje rezultat "
            + vreme3.compareTo(vreme2));

      if( vreme1.isBefore(vreme2))
         System.out.println("prvo vreme je pre drugog");
      else
         System.out.println("prvo vreme nije pre drugog");
      if( vreme1.isAfter(vreme2))
         System.out.println("prvo vreme je posle drugog");
      else
         System.out.println("prvo vreme nije posle drugog");

      System.out.printf("\ndva sata pre vreme1: %s\n", vreme1.minusHours(2).format(formater));
      System.out.printf("dva sata posle vreme1: %s\n", vreme1.plusHours(2).format(formater));
      System.out.printf("dva minuta pre vreme1: %s\n", vreme1.minusMinutes(2).format(formater));
      System.out.printf("dva minuta posle vreme1: %s\n", vreme1.plusMinutes(2).format(formater));
      System.out.printf("dva sekunda pre vreme1: %s\n", vreme1.minusSeconds(2).format(formater));
      System.out.printf("dve sekunda posle vreme1: %s\n", vreme1.plusSeconds(2).format(formater));
      System.out.printf("sto dve nanosekunde pre vreme1: %s\n", vreme1.minusNanos(102).format(formater));
      System.out.printf("sto dve nanosekunde posle vreme1: %s\n", vreme1.plusNanos(102).format(formater));

      System.out.printf("\nvreme1 sa sedamnaestim satom: %s\n",
            vreme1.withHour(17).format(formater));
      System.out.printf("vreme1 sa sedamnaestim minutom: %s\n",
            vreme1.withMinute(17).format(formater));
      System.out.printf("vreme1 sa sedmom sekundom: %s\n",
            vreme1.withSecond(7).format(formater));
      System.out.printf("vreme1 sa 2003-com nanosekundom: %s\n",
            vreme1.withNano(2003).format(formater));

      System.out.println("\nvreme1 sat: " + vreme1.getHour());
      System.out.println("vreme1 minut: " + vreme1.getMinute());
      System.out.printf("vreme1 sekunda: %d\n", vreme1.getSecond());
      System.out.println("vreme1 nanosekunda: " + vreme1.getNano());


      System.out.println("\nvreme1 broj sekundi u danu: " + vreme1.toSecondOfDay());
      System.out.println("vreme1 broj nanosekundi u danu: " + vreme1.toNanoOfDay());

      System.out.println("\nbroj sati od vreme2 do vreme1: "
            + vreme2.until(vreme1, java.time.temporal.ChronoUnit.HOURS));
      System.out.println("broj sati od vreme1 do vreme2: "
            + vreme1.until(vreme2, java.time.temporal.ChronoUnit.HOURS));
      System.out.println("broj minuta od vreme2 do vreme1: "
            + vreme2.until(vreme1, java.time.temporal.ChronoUnit.MINUTES));
      System.out.println("broj minuta od vreme1 do vreme2: "
            + vreme1.until(vreme2, java.time.temporal.ChronoUnit.MINUTES));
      System.out.println("broj sekundi od vreme2 do vreme1: "
            + vreme2.until(vreme1, java.time.temporal.ChronoUnit.SECONDS));
      System.out.println("broj sekundi od vreme1 do vreme2: "
            + vreme1.until(vreme2, java.time.temporal.ChronoUnit.SECONDS));
      System.out.println("broj nanosekundi od vreme2 do vreme1: "
            + vreme2.until(vreme1, java.time.temporal.ChronoUnit.NANOS));
      System.out.println("broj nanosekundi od vreme1 do vreme2: "
            + vreme1.until(vreme2, java.time.temporal.ChronoUnit.NANOS));
   }
}


