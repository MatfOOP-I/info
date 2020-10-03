package p13;
//: c13:YieldingThread.java
// Suggesting when to switch threads with yield().
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class YieldingThread extends Thread {
  private static Test monitor = new Test();
  private int countDown = 5;
  private static int threadCount = 0;
  public YieldingThread() {
    super("" + ++threadCount);
    start();
  }
  public String toString() {
    return "#" + getName() + ": " + countDown;
  }
  public void run() {
    while(true) {
      System.out.println(this);
      if(--countDown == 0) return;
      yield();
    }
  }
  public static void main(String[] args) {
    for(int i = 0; i < 5; i++)
      new YieldingThread();
    monitor.expect(new String[] {
      "#1: 5",
      "#2: 5",
      "#4: 5",
      "#5: 5",
      "#3: 5",
      "#1: 4",
      "#2: 4",
      "#4: 4",
      "#5: 4",
      "#3: 4",
      "#1: 3",
      "#2: 3",
      "#4: 3",
      "#5: 3",
      "#3: 3",
      "#1: 2",
      "#2: 2",
      "#4: 2",
      "#5: 2",
      "#3: 2",
      "#1: 1",
      "#2: 1",
      "#4: 1",
      "#5: 1",
      "#3: 1"
    }, Test.IGNORE_ORDER + Test.WAIT);
  }
} ///:~
