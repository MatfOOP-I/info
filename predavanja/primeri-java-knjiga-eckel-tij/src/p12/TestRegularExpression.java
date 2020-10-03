package p12;
//: c12:TestRegularExpression.java
// Allows you to easly try out regular expressions.
// {Args: abcabcabcdefabc "abc+" "(abc)+" "(abc){2,}" }
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.regex.*;

public class TestRegularExpression {
  public static void main(String[] args) {
    if(args.length < 2) {
      System.out.println("Usage:\n" +
        "java TestRegularExpression " +
        "characterSequence regularExpression+");
      System.exit(0);
    }
    System.out.println("Input: \"" + args[0] + "\"");
    for(int i = 1; i < args.length; i++) {
      System.out.println(
        "Regular expression: \"" + args[i] + "\"");
      Pattern p = Pattern.compile(args[i]);
      Matcher m = p.matcher(args[0]);
      while(m.find()) {
        System.out.println("Match \"" + m.group() +
          "\" at positions " +
          m.start() + "-" + (m.end() - 1));
      }
    }
  }
} ///:~
