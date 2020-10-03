package p11;
//: c11:Queue.java
// Making a queue from a LinkedList.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.*;

public class Queue {
  private static Test monitor = new Test();
  private LinkedList list = new LinkedList();
  public void put(Object v) { list.addFirst(v); }
  public Object get() { return list.removeLast(); }
  public boolean isEmpty() { return list.isEmpty(); }
  public static void main(String[] args) {
    Queue queue = new Queue();
    for(int i = 0; i < 10; i++)
      queue.put(Integer.toString(i));
    while(!queue.isEmpty())
      System.out.println(queue.get());
    monitor.expect(new String[] {
      "0",
      "1",
      "2",
      "3",
      "4",
      "5",
      "6",
      "7",
      "8",
      "9"
    });
  }
} ///:~
