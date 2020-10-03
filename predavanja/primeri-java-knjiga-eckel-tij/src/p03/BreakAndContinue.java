package p03;
//: c03:BreakAndContinue.java
// Demonstrates break and continue keywords.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class BreakAndContinue {
  static Test monitor = new Test();
  public static void main(String[] args) {
    for(int i = 0; i < 100; i++) {
      if(i == 74) break; // Out of for loop
      if(i % 9 != 0) continue; // Next iteration
      System.out.println(i);
    }
    int i = 0;
    // An "infinite loop":
    while(true) {
      i++;
      int j = i * 27;
      if(j == 1269) break; // Out of loop
      if(i % 10 != 0) continue; // Top of loop
      System.out.println(i);
    }
    monitor.expect(new String[] {
      "0",
      "9",
      "18",
      "27",
      "36",
      "45",
      "54",
      "63",
      "72",
      "10",
      "20",
      "30",
      "40"
    });
  }
} ///:~
