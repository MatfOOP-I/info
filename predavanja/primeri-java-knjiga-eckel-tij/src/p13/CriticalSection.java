package p13;
//: c13:CriticalSection.java
// Synchronizing blocks instead of entire methods. Also
// demonstrates protection of a non-thread-safe class
// with a thread-safe one.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.*;

class Pair { // Not thread-safe
  private int x, y;
  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
  public Pair() { this(0, 0); }
  public int getX() { return x; }
  public int getY() { return y; }
  public void incrementX() { x++; }
  public void incrementY() { y++; }
  public String toString() {
    return "x: " + x + ", y: " + y;
  }
  public class PairValuesNotEqualException
  extends RuntimeException {
    public PairValuesNotEqualException() {
      super("Pair values not equal: " + Pair.this);
    }
  }
  // Arbitrary invariant -- both variables must be equal:
  public void checkState() {
    if(x != y)
      throw new PairValuesNotEqualException();
  }
}

// Protect a Pair inside a thread-safe class:
abstract class PairManager {
  protected Pair p = new Pair();
  private List storage = new ArrayList();
  public synchronized Pair getPair() {
    // Make a copy to keep the original safe:
    return new Pair(p.getX(), p.getY());
  }
  protected void store() { storage.add(getPair()); }
  // A "template method":
  public abstract void doTask();
}

// Synchronize the entire method:
class PairManager1 extends PairManager {
  public synchronized void doTask() {
    p.incrementX();
    p.incrementY();
    store();
  }
}

// Use a critical section:
class PairManager2 extends PairManager {
  public void doTask() {
    synchronized(this) {
      p.incrementX();
      p.incrementY();
    }
    store();
  }
}

class PairManipulator extends Thread {
  private PairManager pm;
  private int checkCounter = 0;
  private class PairChecker extends Thread {
    PairChecker() { start(); }
    public void run() {
      while(true) {
        checkCounter++;
        pm.getPair().checkState();
      }
    }
  }
  public PairManipulator(PairManager pm) {
    this.pm = pm;
    start();
    new PairChecker();
  }
  public void run() {
    while(true) {
      pm.doTask();
    }
  }
  public String toString() {
    return "Pair: " + pm.getPair() +
      " checkCounter = " + checkCounter;
  }
}

public class CriticalSection {
  public static void main(String[] args) {
    // Test the two different approaches:
    final PairManipulator
      pm1 = new PairManipulator(new PairManager1()),
      pm2 = new PairManipulator(new PairManager2());
    new Timer(true).schedule(new TimerTask() {
      public void run() {
        System.out.println("pm1: " + pm1);
        System.out.println("pm2: " + pm2);
        System.exit(0);
      }
    }, 500); // run() after 500 milliseconds
  }
} ///:~
