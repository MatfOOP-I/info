public class P050703DatumVremeZ01LocalDateTimePokretanje {


   public static void main(String[] args) {
      java.time.LocalDateTime datumVreme1 = java.time.LocalDateTime.now();
      java.time.LocalDateTime datumVreme2 = java.time.LocalDateTime.parse("2019-02-03T23:15:45");
      java.time.LocalDateTime datumVreme3 =
            java.time.LocalDateTime.of( 2019,02,03,23,15,45);

      System.out.println("datumVreme1: " + datumVreme1);
      System.out.println("datumVreme2: " + datumVreme2);
      System.out.println("datumVreme3: " + datumVreme3);

      java.time.format.DateTimeFormatter formater =
            java.time.format.DateTimeFormatter.ofPattern("dd.MM.YYYY. HH:mm:ss.n");
      System.out.printf("\ndatumVreme1 (custom format): %s\n", datumVreme1.format(formater));
      System.out.printf("datumVreme2 (custom format): %s\n", datumVreme2.format(formater));
      System.out.printf("datumVreme3 (custom format): %s\n\n", datumVreme3.format(formater));

      java.time.format.DateTimeFormatter formater2 =
            java.time.format.DateTimeFormatter.ISO_DATE_TIME;
      System.out.printf("\ndatumVreme1 (ISO format): %s\n", datumVreme1.format(formater2));
      System.out.printf("datumVreme2 (ISO format): %s\n", datumVreme2.format(formater2));
      System.out.printf("datumVreme3 (ISO format): %s\n\n", datumVreme3.format(formater2));

      if (datumVreme1.equals(datumVreme2))
         System.out.println("datumVreme1 i datumVreme2 su jednaki (equals)");
      else
         System.out.println("datumVreme1 i datumVreme2 nisu jednaki (equals)");
      if (datumVreme1.equals(datumVreme3))
         System.out.println("datumVreme1 i datumVreme3 su jednaki (equals)");
      else
         System.out.println("datumVreme1 i datumVreme3 nisu jednaki (equals)");
      if (datumVreme2.equals(datumVreme3))
         System.out.println("datumVreme2 i datumVreme3 su jednaki (equals)");
      else
         System.out.println("datumVreme2 i datumVreme3 nisu jednaki (equals)");

      System.out.println("\nporedjenje datumVreme1 i datumVreme2 (compare) daje rezultat "
            + datumVreme1.compareTo(datumVreme2));
      System.out.println("poredjenje datumVreme2 i datumVreme1 (compare) daje rezultat "
            + datumVreme2.compareTo(datumVreme1));
      System.out.println("poredjenje datumVreme1 i datumVreme3 (compare) daje rezultat "
            + datumVreme1.compareTo(datumVreme3));
      System.out.println("poredjenje datumVreme3 i datumVreme1 (compare) daje rezultat "
            + datumVreme3.compareTo(datumVreme1));
      System.out.println("poredjenje datumVreme2 i datumVreme3 (compare) daje rezultat "
            + datumVreme2.compareTo(datumVreme3));
      System.out.println("poredjenje datumVreme3 i datumVreme2 (compare) daje rezultat "
            + datumVreme3.compareTo(datumVreme2));

      if( datumVreme1.isBefore(datumVreme2))
         System.out.println("prvo datumVreme je pre drugog");
      else
         System.out.println("prvo datumVreme nije pre drugog");
      if( datumVreme1.isAfter(datumVreme2))
         System.out.println("prvo datumVreme je posle drugog");
      else
         System.out.println("prvo datumVreme nije posle drugog");

      System.out.printf("\ndva dana pre datumVreme1: %s\n", datumVreme1.minusDays(2).format(formater));
      System.out.printf("dva dana posle datumVreme1: %s\n", datumVreme1.plusDays(2).format(formater));
      System.out.printf("dve nedelje pre datumVreme1: %s\n", datumVreme1.minusWeeks(2).format(formater));
      System.out.printf("dve nedelje posle datumVreme1: %s\n", datumVreme1.plusWeeks(2).format(formater));
      System.out.printf("dva meseca pre datumVreme1: %s\n", datumVreme1.minusMonths(2).format(formater));
      System.out.printf("dve meseca posle datumVreme1: %s\n", datumVreme1.plusMonths(2).format(formater));
      System.out.printf("dve godine pre datumVreme1: %s\n", datumVreme1.minusYears(2).format(formater));
      System.out.printf("dve godine posle datumVreme1: %s\n", datumVreme1.plusYears(2).format(formater));
      System.out.printf("dva sata pre datumVreme1: %s\n", datumVreme1.minusHours(2).format(formater));
      System.out.printf("dva sata posle datumVreme1: %s\n", datumVreme1.plusHours(2).format(formater));
      System.out.printf("dva minuta pre datumVreme1: %s\n", datumVreme1.minusMinutes(2).format(formater));
      System.out.printf("dva minuta posle datumVreme1: %s\n", datumVreme1.plusMinutes(2).format(formater));
      System.out.printf("dva sekunda pre datumVreme1: %s\n", datumVreme1.minusSeconds(2).format(formater));
      System.out.printf("dve sekunda posle datumVreme1: %s\n", datumVreme1.plusSeconds(2).format(formater));
      System.out.printf("sto dve nanosekunde pre datumVreme1: %s\n", datumVreme1.minusNanos(102).format(formater));
      System.out.printf("sto dve nanosekunde posle datumVreme1: %s\n", datumVreme1.plusNanos(102).format(formater));

      System.out.printf("\ndatumVreme1 sa sedamnaestim danom u mesecu: %s\n",
            datumVreme1.withDayOfMonth(17).format(formater));
      System.out.printf("datumVreme1 sa sto sedamnaestim danom u godini: %s\n",
            datumVreme1.withDayOfYear(117).format(formater));
      System.out.printf("datumVreme1 sa sedmim mesecom u godini: %s\n",
            datumVreme1.withMonth(7).format(formater));
      System.out.printf("datumVreme1 sa godinom 2003: %s\n",
            datumVreme1.withYear(2003).format(formater));
      System.out.printf("\ndatumVreme1 sa sedamnaestim satom: %s\n",
            datumVreme1.withHour(17).format(formater));
      System.out.printf("datumVreme1 sa sedamnaestim minutom: %s\n",
            datumVreme1.withMinute(17).format(formater));
      System.out.printf("datumVreme1 sa sedmom sekundom: %s\n",
            datumVreme1.withSecond(7).format(formater));
      System.out.printf("datumVreme1 sa 2003-com nanosekundom: %s\n",
            datumVreme1.withNano(2003).format(formater));

      System.out.println("\ndatumVreme1 dan u mesecu: " + datumVreme1.getDayOfMonth());
      System.out.println("datumVreme1 dan u nedelji: " + datumVreme1.getDayOfWeek());
      System.out.printf("datumVreme1 dan u nedelji (broj): %d\n", datumVreme1.getDayOfWeek().getValue());
      System.out.println("datumVreme1 dan u godini: " + datumVreme1.getDayOfYear());
      System.out.println("datumVreme1 mesec u godini: " + datumVreme1.getMonth());
      System.out.println("datumVreme1 mesec u godini (vrednost): " + datumVreme1.getMonth().getValue());
      System.out.println("datumVreme1 mesec u godini (vrednost2): " + datumVreme1.getMonthValue());
      System.out.println("datumVreme1 godina: " + datumVreme1.getYear());
      System.out.println("datumVreme1 sat: " + datumVreme1.getHour());
      System.out.println("datumVreme1 minut: " + datumVreme1.getMinute());
      System.out.println("datumVreme1 sekunda: " + datumVreme1.getSecond());
      System.out.println("datumVreme1 nanosekunda: " + datumVreme1.getNano());


      System.out.println("\nbroj dana od datumVreme2 do datumVreme1: "
            + datumVreme2.until(datumVreme1, java.time.temporal.ChronoUnit.DAYS));
      System.out.println("broj dana od datumVreme1 do datumVreme2: "
            + datumVreme1.until(datumVreme2, java.time.temporal.ChronoUnit.DAYS));
      System.out.println("broj meseci od datumVreme2 do datumVreme1: "
            + datumVreme2.until(datumVreme1, java.time.temporal.ChronoUnit.MONTHS));
      System.out.println("broj meseci od datumVreme1 do datumVreme2: "
            + datumVreme1.until(datumVreme2, java.time.temporal.ChronoUnit.MONTHS));
      System.out.println("broj godina od datumVreme2 do datumVreme1: "
            + datumVreme2.until(datumVreme1, java.time.temporal.ChronoUnit.YEARS));
      System.out.println("broj godina od datumVreme1 do datumVreme2: "
            + datumVreme1.until(datumVreme2, java.time.temporal.ChronoUnit.YEARS));
      System.out.println("broj sati od datumVreme2 do datumVreme1: "
            + datumVreme2.until(datumVreme1, java.time.temporal.ChronoUnit.HOURS));
      System.out.println("broj sati od datumVreme1 do datumVreme2: "
            + datumVreme1.until(datumVreme2, java.time.temporal.ChronoUnit.HOURS));
      System.out.println("broj minuta od datumVreme2 do datumVreme1: "
            + datumVreme2.until(datumVreme1, java.time.temporal.ChronoUnit.MINUTES));
      System.out.println("broj minuta od datumVreme1 do datumVreme2: "
            + datumVreme1.until(datumVreme2, java.time.temporal.ChronoUnit.MINUTES));
      System.out.println("broj sekundi od datumVreme2 do datumVreme1: "
            + datumVreme2.until(datumVreme1, java.time.temporal.ChronoUnit.SECONDS));
      System.out.println("broj sekundi od datumVreme1 do datumVreme2: "
            + datumVreme1.until(datumVreme2, java.time.temporal.ChronoUnit.SECONDS));
      System.out.println("broj nanosekundi od datumVreme2 do datumVreme1: "
            + datumVreme2.until(datumVreme1, java.time.temporal.ChronoUnit.NANOS));
      System.out.println("broj nanosekundi od datumVreme1 do datumVreme2: "
            + datumVreme1.until(datumVreme2, java.time.temporal.ChronoUnit.NANOS));
   }
}


