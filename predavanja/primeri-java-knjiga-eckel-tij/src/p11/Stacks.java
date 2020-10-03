package p11;
//: c11:Stacks.java
// Demonstration of Stack Class.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

import p08.Month;

import java.util.*;

public class Stacks {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    Stack stack = new Stack();
    for(int i = 0; i < Month.month.length; i++)
      stack.push(Month.month[i] + " ");
    System.out.println("stack = " + stack);
    // Treating a stack as a Vector:
    stack.addElement("The last line");
    System.out.println("element 5 = " +
      stack.elementAt(5));
    System.out.println("popping elements:");
    while(!stack.empty())
      System.out.println(stack.pop());
    monitor.expect(new String[] {
      "stack = [January , February , March , April , May "+
        ", June , July , August , September , October , " +
        "November , December ]",
      "element 5 = June ",
      "popping elements:",
      "The last line",
      "December ",
      "November ",
      "October ",
      "September ",
      "August ",
      "July ",
      "June ",
      "May ",
      "April ",
      "March ",
      "February ",
      "January "
    });
  }
} ///:~
