package p13;
//: c13:Timeout.java
// Set a time limit on the execution of a program
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.*;

public class Timeout extends Timer {
  public Timeout(int delay, final String msg) {
    super(true); // Daemon thread
    schedule(new TimerTask() {
      public void run() {
        System.out.println(msg);
        System.exit(0);
      }
    }, delay);
  }
} ///:~
