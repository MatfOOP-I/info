package p11;
//: c11:StackL.java
// Making a stack from a LinkedList.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.*;
import com.bruceeckel.util.*;

public class StackL {
  private static Test monitor = new Test();
  private LinkedList list = new LinkedList();
  public void push(Object v) { list.addFirst(v); }
  public Object top() { return list.getFirst(); }
  public Object pop() { return list.removeFirst(); }
  public static void main(String[] args) {
    StackL stack = new StackL();
    for(int i = 0; i < 10; i++)
      stack.push(Collections2.countries.next());
    System.out.println(stack.top());
    System.out.println(stack.top());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    monitor.expect(new String[] {
      "CHAD",
      "CHAD",
      "CHAD",
      "CENTRAL AFRICAN REPUBLIC",
      "CAPE VERDE"
    });
  }
} ///:~
