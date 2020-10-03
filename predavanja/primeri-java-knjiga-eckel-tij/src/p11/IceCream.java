package p11;
//: c11:IceCream.java
// Returning arrays from methods.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.*;

public class IceCream {
  private static Test monitor = new Test();
  private static Random rand = new Random();
  public static final String[] flavors = {
    "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
    "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
    "Praline Cream", "Mud Pie"
  };
  public static String[] flavorSet(int n) {
    String[] results = new String[n];
    boolean[] picked = new boolean[flavors.length];
    for(int i = 0; i < n; i++) {
      int t;
      do
        t = rand.nextInt(flavors.length);
      while(picked[t]);
      results[i] = flavors[t];
      picked[t] = true;
    }
    return results;
  }
  public static void main(String[] args) {
    for(int i = 0; i < 20; i++) {
      System.out.println(
        "flavorSet(" + i + ") = ");
      String[] fl = flavorSet(flavors.length);
      for(int j = 0; j < fl.length; j++)
        System.out.println("\t" + fl[j]);
      monitor.expect(new Object[] {
        "%% flavorSet\\(\\d+\\) = ",
        new TestExpression("%% \\t(Chocolate|Strawberry|"
          + "Vanilla Fudge Swirl|Mint Chip|Mocha Almond "
          + "Fudge|Rum Raisin|Praline Cream|Mud Pie)", 8)
      });
    }
  }
} ///:~
