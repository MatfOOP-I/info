package p12;
//: c12:ReplacingStringTokenizer.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.regex.*;
import com.bruceeckel.simpletest.*;
import java.util.*;

public class ReplacingStringTokenizer {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    String input = "But I'm not dead yet! I feel happy!";
    StringTokenizer stoke = new StringTokenizer(input);
    while(stoke.hasMoreElements())
      System.out.println(stoke.nextToken());
    System.out.println(Arrays.asList(input.split(" ")));
    monitor.expect(new String[] {
      "But",
      "I'm",
      "not",
      "dead",
      "yet!",
      "I",
      "feel",
      "happy!",
      "[But, I'm, not, dead, yet!, I, feel, happy!]"
    });
  }
} ///:~
