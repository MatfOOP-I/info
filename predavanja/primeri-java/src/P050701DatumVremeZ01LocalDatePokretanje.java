import java.time.format.DateTimeFormatter;

public class P050701DatumVremeZ01LocalDatePokretanje {
   public static void main(String[] args) {
      java.time.LocalDate datum1 = java.time.LocalDate.now();
      java.time.LocalDate datum2 = java.time.LocalDate.parse("2019-02-03");
      java.time.LocalDate datum3 = java.time.LocalDate.of(2019, 2, 3);

      System.out.println("datum1: " + datum1);
      System.out.println("datum2: " + datum2);
      System.out.println("datum3: " + datum3);

      java.time.format.DateTimeFormatter formater = java.time.format.DateTimeFormatter.ofPattern("dd.MM.YYYY.");
      System.out.printf("\ndatum1 (custom format): %s\n", datum1.format(formater));
      System.out.printf("datum2 (custom format): %s\n", datum2.format(formater));
      System.out.printf("datum3 (custom format): %s\n\n", datum3.format(formater));

      java.time.format.DateTimeFormatter formater2 = DateTimeFormatter.ISO_DATE;
      System.out.printf("\ndatum1 (ISO format): %s\n", datum1.format(formater2));
      System.out.printf("datum2 (ISO format): %s\n", datum2.format(formater2));
      System.out.printf("datum3 (ISO format): %s\n\n", datum3.format(formater2));

      if (datum1.equals(datum2))
         System.out.println("prva dva datuma su jednaki (equals)");
      else
         System.out.println("prva dva datuma nisu jednaki (equals)");
      if (datum1.equals(datum3))
         System.out.println("prvi i treci datum su jednaki (equals)");
      else
         System.out.println("prvi i treci datum nisu jednaki (equals)");
      if (datum2.equals(datum3))
         System.out.println("poslednja dva datuma su jednaki (equals)");
      else
         System.out.println("poslednja dva datuma nisu jednaki (equals)");

      System.out.println("\nporedjenje prvog i drugog datuma (compare) daje rezultat "
            + datum1.compareTo(datum2));
      System.out.println("poredjenje drugog i prvog datuma (compare) daje rezultat "
            + datum2.compareTo(datum1));
      System.out.println("poredjenje prvog i treceg datuma (compare) daje rezultat "
            + datum1.compareTo(datum3));
      System.out.println("poredjenje treceg i prvog datuma (compare) daje rezultat "
            + datum3.compareTo(datum1));
      System.out.println("poredjenje drugog i treceg datuma (compare) daje rezultat "
            + datum2.compareTo(datum3));
      System.out.println("poredjenje treceg i drugog datuma (compare) daje rezultat "
            + datum3.compareTo(datum2));

      if( datum1.isBefore(datum2))
         System.out.println("prvi datum je pre drugog");
      else
         System.out.println("prvi datum nije pre drugog");
      if( datum1.isAfter(datum2))
         System.out.println("prvi datum je posle drugog");
      else
         System.out.println("prvi datum nije posle drugog");
      if( datum1.isEqual(datum2))
         System.out.println("prvi datum je jednak sa drugim");
      else
         System.out.println("prvi datum nije jednak sa drugim");

      System.out.printf("\ndva dana pre datum1: %s\n", datum1.minusDays(2).format(formater));
      System.out.printf("dva dana posle datum1: %s\n", datum1.plusDays(2).format(formater));
      System.out.printf("dve nedelje pre datum1: %s\n", datum1.minusWeeks(2).format(formater));
      System.out.printf("dve nedelje posle datum1: %s\n", datum1.plusWeeks(2).format(formater));
      System.out.printf("dva meseca pre datum1: %s\n", datum1.minusMonths(2).format(formater));
      System.out.printf("dve meseca posle datum1: %s\n", datum1.plusMonths(2).format(formater));
      System.out.printf("dve godine pre datum1: %s\n", datum1.minusYears(2).format(formater));
      System.out.printf("dve godine posle datum1: %s\n", datum1.plusYears(2).format(formater));

      System.out.printf("\ndatum1 sa sedamnaestim danom u mesecu: %s\n",
            datum1.withDayOfMonth(17).format(formater));
      System.out.printf("datum1 sa sto sedamnaestim danom u godini: %s\n",
            datum1.withDayOfYear(117).format(formater));
      System.out.printf("datum1 sa sedmim mesecom u godini: %s\n",
            datum1.withMonth(7).format(formater));
      System.out.printf("datum1 sa godinom 2003: %s\n",
            datum1.withYear(2003).format(formater));

      System.out.println("\ndatum1 dan u mesecu: " + datum1.getDayOfMonth());
      System.out.println("datum1 dan u nedelji: " + datum1.getDayOfWeek());
      System.out.printf("datum1 dan u nedelji (broj): %d\n", datum1.getDayOfWeek().getValue());
      System.out.println("datum1 dan u godini: " + datum1.getDayOfYear());
      System.out.println("datum1 mesec u godini: " + datum1.getMonth());
      System.out.println("datum1 mesec u godini (vrednost): " + datum1.getMonth().getValue());
      System.out.println("datum1 mesec u godini (vrednost2): " + datum1.getMonthValue());
      System.out.println("datum1 godina: " + datum1.getYear());
      System.out.println("datum1 epoha: " + datum1.getEra());
      System.out.println("datum1 epoha (vrednost): " + datum1.getEra().getValue());

      System.out.println("\ndatum1 broj dana u mesecu: " + datum1.lengthOfMonth());
      System.out.println("datum1 broj dana u godini: " + datum1.lengthOfYear());
      System.out.println("datum1 godina je prestupna: " + datum1.isLeapYear());
      System.out.println("datum1 broj dana u epohi: " + datum1.toEpochDay());

      System.out.println("\nbroj dana od datum2 do datum1: "
            + datum2.until(datum1, java.time.temporal.ChronoUnit.DAYS));
      System.out.println("broj dana od datum1 do datum2: "
            + datum1.until(datum2, java.time.temporal.ChronoUnit.DAYS));
      System.out.println("broj meseci od datum2 do datum1: "
            + datum2.until(datum1, java.time.temporal.ChronoUnit.MONTHS));
      System.out.println("broj meseci od datum1 do datum2: "
            + datum1.until(datum2, java.time.temporal.ChronoUnit.MONTHS));
      System.out.println("broj godina od datum2 do datum1: "
            + datum2.until(datum1, java.time.temporal.ChronoUnit.YEARS));
      System.out.println("broj godina od datum1 do datum2: "
            + datum1.until(datum2, java.time.temporal.ChronoUnit.YEARS));
   }
}


