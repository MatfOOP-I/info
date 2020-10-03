package p03;
//: c03:VowelsAndConsonants.java
// Demonstrates the switch statement.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class VowelsAndConsonants {
  static Test monitor = new Test();
  public static void main(String[] args) {
    for(int i = 0; i < 100; i++) {
      char c = (char)(Math.random() * 26 + 'a');
      System.out.print(c + ": ");
      switch(c) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u': System.out.println("vowel");
                  break;
        case 'y':
        case 'w': System.out.println("Sometimes a vowel");
                  break;
        default:  System.out.println("consonant");
      }
      monitor.expect(new String[] {
        "%% [aeiou]: vowel|[yw]: Sometimes a vowel|" +
          "[^aeiouyw]: consonant"
      }, Test.AT_LEAST);
    }
  }
} ///:~
