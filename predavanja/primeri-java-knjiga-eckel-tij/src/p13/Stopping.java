package p13;
//: c13:Stopping.java
// The safe way to stop a thread.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.*;

class CanStop extends Thread {
  // Must be volatile:
  private volatile boolean stop = false;
  private int counter = 0;
  public void run() {
    while(!stop && counter < 10000) {
      System.out.println(counter++);
    }
    if(stop)
      System.out.println("Detected stop");
  }
  public void requestStop() { stop = true; }
}

public class Stopping {
  public static void main(String[] args) {
    final CanStop stoppable = new CanStop();
    stoppable.start();
    new Timer(true).schedule(new TimerTask() {
      public void run() {
        System.out.println("Requesting stop");
        stoppable.requestStop();
      }
    }, 500); // run() after 500 milliseconds
  }
} ///:~
