public class P050402OmotacZnakaZ01CharacterPokretanje {
   public static void main(String[] args) {
      Character znak1 = '*';
      Character znak2 = 42;
      Character znak3 = Character.forDigit(11, 16);

      System.out.printf("znak1: %s\n", znak1);
      System.out.printf("znak2: %s\n", znak2);
      System.out.printf("znak3: %s\n", znak3);

      System.out.printf("\nznak1 hashCode() - dec: %d\n", znak1.hashCode());
      System.out.printf("znak2 hashCode() - hex: %x\n", znak1.hashCode());
      System.out.printf("znak2 hashCode() - char: %c\n", znak1.hashCode());
      System.out.printf("znak2 hashCode(): %d\n", znak2.hashCode());
      System.out.printf("znak3 hashCode(): %d\n\n", znak3.hashCode());


      if (znak1.equals(znak2))
         System.out.printf("prva dva znaka su jednaki (equals)\n");
      else
         System.out.printf("prva dva znaka nisu jednaki (equals)\n");
      if (znak1.equals(znak3))
         System.out.printf("prva i treci znak su jednaki (equals)\n");
      else
         System.out.printf("prva i treci znak nisu jednaki (equals)\n");
      if (znak2.equals(znak3))
         System.out.printf("poslednja dva znaka su jednaki (equals)\n");
      else
         System.out.printf("poslednja dva znaka nisu jednaki (equals)\n");

      int poredjenje = znak1.compareTo(znak2);
      if (poredjenje > 0)
         System.out.printf("znak1('%s') > znak2('%s')\n", znak1, znak2);
      else if (poredjenje < 0)
         System.out.printf("znak1('%s') < znak2('%s')\n", znak1, znak2);
      else
         System.out.printf("znak1('%s') == znak2('%s')\n", znak1, znak2);
      poredjenje = znak1.compareTo(znak3);
      if (poredjenje > 0)
         System.out.printf("znak1('%s') > znak3('%s')\n", znak1, znak3);
      else if (poredjenje < 0)
         System.out.printf("znak1('%s') < znak3('%s')\n", znak1, znak3);
      else
         System.out.printf("znak1('%s') == znak3('%s')\n", znak1, znak3);
      poredjenje = znak2.compareTo(znak3);
      if (poredjenje > 0)
         System.out.printf("znak2('%s') > znak3('%s')\n", znak2, znak3);
      else if (poredjenje < 0)
         System.out.printf("znak2('%s') < znak3('%s')\n", znak2, znak3);
      else
         System.out.printf("znak2('%s') == znak3('%s')\n", znak2, znak3);

      char ch1 = '7';
      char ch2 = 'a';
      char ch3 = 'B';
      System.out.printf("\nCharacter.getNumericValue('%c'): %d\n", ch1, Character.getNumericValue(ch1));
      System.out.printf("Character.getNumericValue('%c'): %d\n", ch2, Character.getNumericValue(ch2));
      System.out.printf("Character.getNumericValue('%c'): %d\n", ch3, Character.getNumericValue(ch3));
      System.out.printf("Character.digit('%c', 16): %d\n", ch1, Character.digit(ch1, 16));
      System.out.printf("Character.digit('%c', 16): %d\n", ch2, Character.digit(ch2, 16));
      System.out.printf("Character.digit('%c', 16): %d\n", ch3, Character.digit(ch3, 16));

      char ch4 = ' ';
      char ch5 = 'ж';
      System.out.printf("\nCharacter.isAlphabetic('%c'): %b\n", ch1, Character.isAlphabetic(ch1));
      System.out.printf("Character.isAlphabetic('%c'): %b\n", ch2, Character.isAlphabetic(ch2));
      System.out.printf("Character.isAlphabetic('%c'): %b\n", ch3, Character.isAlphabetic(ch3));
      System.out.printf("Character.isAlphabetic('%c'): %b\n", ch4, Character.isAlphabetic(ch4));
      System.out.printf("Character.isAlphabetic('%c'): %b\n", ch5, Character.isAlphabetic(ch5));
      System.out.printf("Character.isDigit('%c'): %b\n", ch1, Character.isDigit(ch1));
      System.out.printf("Character.isDigit('%c'): %b\n", ch2, Character.isDigit(ch2));
      System.out.printf("Character.isDigit('%c'): %b\n", ch3, Character.isDigit(ch3));
      System.out.printf("Character.isDigit('%c'): %b\n", ch4, Character.isDigit(ch4));
      System.out.printf("Character.isDigit('%c'): %b\n", ch5, Character.isDigit(ch5));
      System.out.printf("Character.isLetter('%c'): %b\n", ch1, Character.isLetter(ch1));
      System.out.printf("Character.isLetter('%c'): %b\n", ch2, Character.isLetter(ch2));
      System.out.printf("Character.isLetter('%c'): %b\n", ch3, Character.isLetter(ch3));
      System.out.printf("Character.isLetter('%c'): %b\n", ch4, Character.isLetter(ch4));
      System.out.printf("Character.isLetter('%c'): %b\n", ch5, Character.isLetter(ch5));
      System.out.printf("Character.isLetterOrDigit('%c'): %b\n", ch1, Character.isLetterOrDigit(ch1));
      System.out.printf("Character.isLetterOrDigit('%c'): %b\n", ch2, Character.isLetterOrDigit(ch2));
      System.out.printf("Character.isLetterOrDigit('%c'): %b\n", ch3, Character.isLetterOrDigit(ch3));
      System.out.printf("Character.isLetterOrDigit('%c'): %b\n", ch4, Character.isLetterOrDigit(ch4));
      System.out.printf("Character.isLetterOrDigit('%c'): %b\n", ch5, Character.isLetterOrDigit(ch5));
      System.out.printf("Character.isLowerCase('%c'): %b\n", ch1, Character.isLowerCase(ch1));
      System.out.printf("Character.isLowerCase('%c'): %b\n", ch2, Character.isLowerCase(ch2));
      System.out.printf("Character.isLowerCase('%c'): %b\n", ch3, Character.isLowerCase(ch3));
      System.out.printf("Character.isLowerCase('%c'): %b\n", ch4, Character.isLowerCase(ch4));
      System.out.printf("Character.isLowerCase('%c'): %b\n", ch5, Character.isLowerCase(ch5));
      System.out.printf("Character.isUpperCase('%c'): %b\n", ch1, Character.isUpperCase(ch1));
      System.out.printf("Character.isUpperCase('%c'): %b\n", ch2, Character.isUpperCase(ch2));
      System.out.printf("Character.isUpperCase('%c'): %b\n", ch3, Character.isUpperCase(ch3));
      System.out.printf("Character.isUpperCase('%c'): %b\n", ch4, Character.isUpperCase(ch4));
      System.out.printf("Character.isUpperCase('%c'): %b\n", ch5, Character.isUpperCase(ch5));
      System.out.printf("Character.isWhitespace('%c'): %b\n", ch1, Character.isWhitespace(ch1));
      System.out.printf("Character.isWhitespace('%c'): %b\n", ch2, Character.isWhitespace(ch2));
      System.out.printf("Character.isWhitespace('%c'): %b\n", ch3, Character.isWhitespace(ch3));
      System.out.printf("Character.isWhitespace('%c'): %b\n", ch4, Character.isWhitespace(ch4));
      System.out.printf("Character.isWhitespace('%c'): %b\n", ch5, Character.isWhitespace(ch5));

      System.out.printf("\nCharacter.toLowerCase('%c'): '%c'\n", ch1, Character.toLowerCase(ch1));
      System.out.printf("Character.toLowerCase('%c'): '%c'\n", ch2, Character.toLowerCase(ch2));
      System.out.printf("Character.toLowerCase('%c'): '%c'\n", ch3, Character.toLowerCase(ch3));
      System.out.printf("Character.toLowerCase('%c'): '%c'\n", ch4, Character.toLowerCase(ch4));
      System.out.printf("Character.toLowerCase('%c'): '%c'\n", ch5, Character.toLowerCase(ch5));
      System.out.printf("Character.toUpperCase('%c'): '%c'\n", ch1, Character.toUpperCase(ch1));
      System.out.printf("Character.toUpperCase('%c'): '%c'\n", ch2, Character.toUpperCase(ch2));
      System.out.printf("Character.toUpperCase('%c'): '%c'\n", ch3, Character.toUpperCase(ch3));
      System.out.printf("Character.toUpperCase('%c'): '%c'\n", ch4, Character.toUpperCase(ch4));
      System.out.printf("Character.toUpperCase('%c'): '%c'\n", ch5, Character.toUpperCase(ch5));
   }

}
