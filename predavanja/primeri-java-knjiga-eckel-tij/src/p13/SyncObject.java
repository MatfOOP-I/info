package p13;
//: c13:SyncObject.java
// Synchronizing on another object
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class DualSynch {
  private Object syncObject = new Object();
  public synchronized void f() {
    System.out.println("Inside f()");
    // Doesn't release lock:
    try {
      Thread.sleep(500);
    } catch(InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Leaving f()");
  }
  public void g() {
    synchronized(syncObject) {
      System.out.println("Inside g()");
      try {
        Thread.sleep(500);
      } catch(InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println("Leaving g()");
    }
  }
}

public class SyncObject {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    final DualSynch ds = new DualSynch();
    new Thread() {
      public void run() {
        ds.f();
      }
    }.start();
    ds.g();
    monitor.expect(new String[] {
      "Inside g()",
      "Inside f()",
      "Leaving g()",
      "Leaving f()"
    }, Test.WAIT + Test.IGNORE_ORDER);
  }
} ///:~
