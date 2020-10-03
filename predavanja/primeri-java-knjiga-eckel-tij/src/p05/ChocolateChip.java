package p05;
//: c05:ChocolateChip.java
// Can't use package-access member from another package.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

import p05.dessert.*;

public class ChocolateChip extends Cookie {
  private static Test monitor = new Test();
  public ChocolateChip() {
   System.out.println("ChocolateChip constructor");
  }
  public static void main(String[] args) {
    ChocolateChip x = new ChocolateChip();
    //! x.bite(); // Can't access bite
    monitor.expect(new String[] {
      "Cookie constructor",
      "ChocolateChip constructor"
    });
  }
} ///:~
