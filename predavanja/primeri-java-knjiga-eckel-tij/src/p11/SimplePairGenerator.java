package p11;
//: c11:SimplePairGenerator.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.util.*;
//import java.util.*;

public class SimplePairGenerator implements MapGenerator {
  public Pair[] items = {
    new Pair("one", "A"), new Pair("two", "B"),
    new Pair("three", "C"), new Pair("four", "D"),
    new Pair("five", "E"), new Pair("six", "F"),
    new Pair("seven", "G"), new Pair("eight", "H"),
    new Pair("nine", "I"), new Pair("ten", "J")
  };
  private int index = -1;
  public Pair next() {
    index = (index + 1) % items.length;
    return items[index];
  }
  public static SimplePairGenerator gen =
    new SimplePairGenerator();
} ///:~
