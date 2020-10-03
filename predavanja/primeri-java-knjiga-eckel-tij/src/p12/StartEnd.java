package p12;
//: c12:StartEnd.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.regex.*;
import com.bruceeckel.simpletest.*;

public class StartEnd {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    String[] input = new String[] {
      "Java has regular expressions in 1.4",
      "regular expressions now expressing in Java",
      "Java represses oracular expressions"
    };
    Pattern
      p1 = Pattern.compile("re\\w*"),
      p2 = Pattern.compile("Java.*");
    for(int i = 0; i < input.length; i++) {
      System.out.println("input " + i + ": " + input[i]);
      Matcher
        m1 = p1.matcher(input[i]),
        m2 = p2.matcher(input[i]);
      while(m1.find())
        System.out.println("m1.find() '" + m1.group() +
          "' start = "+ m1.start() + " end = " + m1.end());
      while(m2.find())
        System.out.println("m2.find() '" + m2.group() +
          "' start = "+ m2.start() + " end = " + m2.end());
      if(m1.lookingAt()) // No reset() necessary
        System.out.println("m1.lookingAt() start = "
          + m1.start() + " end = " + m1.end());
      if(m2.lookingAt())
        System.out.println("m2.lookingAt() start = "
          + m2.start() + " end = " + m2.end());
      if(m1.matches()) // No reset() necessary
        System.out.println("m1.matches() start = "
          + m1.start() + " end = " + m1.end());
      if(m2.matches())
        System.out.println("m2.matches() start = "
          + m2.start() + " end = " + m2.end());
    }
    monitor.expect(new String[] {
      "input 0: Java has regular expressions in 1.4",
      "m1.find() 'regular' start = 9 end = 16",
      "m1.find() 'ressions' start = 20 end = 28",
      "m2.find() 'Java has regular expressions in 1.4'" +
      " start = 0 end = 35",
      "m2.lookingAt() start = 0 end = 35",
      "m2.matches() start = 0 end = 35",
      "input 1: regular expressions now " +
      "expressing in Java",
      "m1.find() 'regular' start = 0 end = 7",
      "m1.find() 'ressions' start = 11 end = 19",
      "m1.find() 'ressing' start = 27 end = 34",
      "m2.find() 'Java' start = 38 end = 42",
      "m1.lookingAt() start = 0 end = 7",
      "input 2: Java represses oracular expressions",
      "m1.find() 'represses' start = 5 end = 14",
      "m1.find() 'ressions' start = 27 end = 35",
      "m2.find() 'Java represses oracular expressions' " +
      "start = 0 end = 35",
      "m2.lookingAt() start = 0 end = 35",
      "m2.matches() start = 0 end = 35"
    });
  }
} ///:~