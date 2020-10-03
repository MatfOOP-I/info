package p12;
//: c12:ReFlags.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.regex.*;
import com.bruceeckel.simpletest.*;

public class ReFlags {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    Pattern p =  Pattern.compile("^java",
      Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
    Matcher m = p.matcher(
      "java has regex\nJava has regex\n" +
      "JAVA has pretty good regular expressions\n" +
      "Regular expressions are in Java");
    while(m.find())
      System.out.println(m.group());
    monitor.expect(new String[] {
      "java",
      "Java",
      "JAVA"
    });
  }
} ///:~
