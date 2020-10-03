package p13;
//: c13:SimpleThread.java
// Very simple Threading example.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class SimpleThread extends Thread {
  private static Test monitor = new Test();
  private int countDown = 5;
  private static int threadCount = 0;
  public SimpleThread() {
    super("" + ++threadCount); // Store the thread name
    start();
  }
  public String toString() {
    return "#" + getName() + ": " + countDown;
  }
  public void run() {
    while(true) {
      System.out.println(this);
      if(--countDown == 0) return;
    }
  }
  public static void main(String[] args) {
    for(int i = 0; i < 5; i++)
      new SimpleThread();
    monitor.expect(new String[] {
      "#1: 5",
      "#2: 5",
      "#3: 5",
      "#5: 5",
      "#1: 4",
      "#4: 5",
      "#2: 4",
      "#3: 4",
      "#5: 4",
      "#1: 3",
      "#4: 4",
      "#2: 3",
      "#3: 3",
      "#5: 3",
      "#1: 2",
      "#4: 3",
      "#2: 2",
      "#3: 2",
      "#5: 2",
      "#1: 1",
      "#4: 2",
      "#2: 1",
      "#3: 1",
      "#5: 1",
      "#4: 1"
    }, Test.IGNORE_ORDER + Test.WAIT);
  }
} ///:~
