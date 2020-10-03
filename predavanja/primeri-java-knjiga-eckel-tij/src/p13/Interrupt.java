package p13;
//: c13:Interrupt.java
// Using interrupt() to break out of a blocked thread.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.*;

class Blocked extends Thread {
  public Blocked() {
    System.out.println("Starting Blocked");
    start();
  }
  public void run() {
    try {
      synchronized(this) {
        wait(); // Blocks
      }
    } catch(InterruptedException e) {
      System.out.println("Interrupted");
    }
    System.out.println("Exiting run()");
  }
}

public class Interrupt {
  static Blocked blocked = new Blocked();
  public static void main(String[] args) {
    new Timer(true).schedule(new TimerTask() {
      public void run() {
        System.out.println("Preparing to interrupt");
        blocked.interrupt();
        blocked = null; // to release it
      }
    }, 2000); // run() after 2000 milliseconds
  }
} ///:~
