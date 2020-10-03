package p12;
//: c12:FindDemo.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.regex.*;
import com.bruceeckel.simpletest.*;
import java.util.*;

public class FindDemo {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    Matcher m = Pattern.compile("\\w+")
      .matcher("Evening is full of the linnet's wings");
    while(m.find())
      System.out.println(m.group());
    int i = 0;
    while(m.find(i)) {
      System.out.print(m.group() + " ");
      i++;
    }
    monitor.expect(new String[] {
      "Evening",
      "is",
      "full",
      "of",
      "the",
      "linnet",
      "s",
      "wings",
      "Evening vening ening ning ing ng g is is s full " +
      "full ull ll l of of f the the he e linnet linnet " +
      "innet nnet net et t s s wings wings ings ngs gs s "
    });
  }
} ///:~
