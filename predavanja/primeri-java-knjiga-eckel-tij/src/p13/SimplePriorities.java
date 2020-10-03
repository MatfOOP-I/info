package p13;
//: c13:SimplePriorities.java
// Shows the use of thread priorities.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class SimplePriorities extends Thread {
  private static Test monitor = new Test();
  private int countDown = 5;
  private volatile double d = 0; // No optimization
  public SimplePriorities(int priority) {
    setPriority(priority);
    start();
  }
  public String toString() {
    return super.toString() + ": " + countDown;
  }
  public void run() {
    while(true) {
      // An expensive, interruptable operation:
      for(int i = 1; i < 100000; i++)
        d = d + (Math.PI + Math.E) / (double)i;
      System.out.println(this);
      if(--countDown == 0) return;
    }
  }
  public static void main(String[] args) {
    new SimplePriorities(Thread.MAX_PRIORITY);
    for(int i = 0; i < 5; i++)
      new SimplePriorities(Thread.MIN_PRIORITY);
    monitor.expect(new String[] {
      "Thread[Thread-1,10,main]: 5",
      "Thread[Thread-1,10,main]: 4",
      "Thread[Thread-1,10,main]: 3",
      "Thread[Thread-1,10,main]: 2",
      "Thread[Thread-1,10,main]: 1",
      "Thread[Thread-2,1,main]: 5",
      "Thread[Thread-2,1,main]: 4",
      "Thread[Thread-2,1,main]: 3",
      "Thread[Thread-2,1,main]: 2",
      "Thread[Thread-2,1,main]: 1",
      "Thread[Thread-3,1,main]: 5",
      "Thread[Thread-4,1,main]: 5",
      "Thread[Thread-5,1,main]: 5",
      "Thread[Thread-6,1,main]: 5",
      "Thread[Thread-3,1,main]: 4",
      "Thread[Thread-4,1,main]: 4",
      "Thread[Thread-5,1,main]: 4",
      "Thread[Thread-6,1,main]: 4",
      "Thread[Thread-3,1,main]: 3",
      "Thread[Thread-4,1,main]: 3",
      "Thread[Thread-5,1,main]: 3",
      "Thread[Thread-6,1,main]: 3",
      "Thread[Thread-3,1,main]: 2",
      "Thread[Thread-4,1,main]: 2",
      "Thread[Thread-5,1,main]: 2",
      "Thread[Thread-6,1,main]: 2",
      "Thread[Thread-4,1,main]: 1",
      "Thread[Thread-3,1,main]: 1",
      "Thread[Thread-6,1,main]: 1",
      "Thread[Thread-5,1,main]: 1"
    }, Test.IGNORE_ORDER + Test.WAIT);
  }
} ///:~
