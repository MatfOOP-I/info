package p12;
//: c12:SplitDemo.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.regex.*;
import com.bruceeckel.simpletest.*;
import java.util.*;

public class SplitDemo {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    String input =
      "This!!unusual use!!of exclamation!!points";
    System.out.println(Arrays.asList(
      Pattern.compile("!!").split(input)));
    // Only do the first three:
    System.out.println(Arrays.asList(
      Pattern.compile("!!").split(input, 3)));
    System.out.println(Arrays.asList(
      "Aha! String has a split() built in!".split(" ")));
    monitor.expect(new String[] {
      "[This, unusual use, of exclamation, points]",
      "[This, unusual use, of exclamation!!points]",
      "[Aha!, String, has, a, split(), built, in!]"
    });
  }
} ///:~
