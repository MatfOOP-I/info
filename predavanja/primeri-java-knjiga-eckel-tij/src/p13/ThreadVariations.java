package p13;
//: c13:ThreadVariations.java
// Creating threads with inner classes.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

// Using a named inner class:
class InnerThread1 {
  private int countDown = 5;
  private Inner inner;
  private class Inner extends Thread {
    Inner(String name) {
      super(name);
      start();
    }
    public void run() {
      while(true) {
        System.out.println(this);
        if(--countDown == 0) return;
        try {
          sleep(10);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }
    public String toString() {
      return getName() + ": " + countDown;
    }
  }
  public InnerThread1(String name) {
    inner = new Inner(name);
  }
}

// Using an anonymous inner class:
class InnerThread2 {
  private int countDown = 5;
  private Thread t;
  public InnerThread2(String name) {
    t = new Thread(name) {
      public void run() {
        while(true) {
          System.out.println(this);
          if(--countDown == 0) return;
          try {
            sleep(10);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }
      public String toString() {
        return getName() + ": " + countDown;
      }
    };
    t.start();
  }
}

// Using a named Runnable implementation:
class InnerRunnable1 {
  private int countDown = 5;
  private Inner inner;
  private class Inner implements Runnable {
    Thread t;
    Inner(String name) {
      t = new Thread(this, name);
      t.start();
    }
    public void run() {
      while(true) {
        System.out.println(this);
        if(--countDown == 0) return;
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }
    public String toString() {
      return t.getName() + ": " + countDown;
    }
  }
  public InnerRunnable1(String name) {
    inner = new Inner(name);
  }
}

// Using an anonymous Runnable implementation:
class InnerRunnable2 {
  private int countDown = 5;
  private Thread t;
  public InnerRunnable2(String name) {
    t = new Thread(new Runnable() {
      public void run() {
        while(true) {
          System.out.println(this);
          if(--countDown == 0) return;
          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }
      public String toString() {
        return Thread.currentThread().getName() +
          ": " + countDown;
      }
    }, name);
    t.start();
  }
}

// A separate method to run some code as a thread:
class ThreadMethod {
  private int countDown = 5;
  private Thread t;
  private String name;
  public ThreadMethod(String name) { this.name = name; }
  public void runThread() {
    if(t == null) {
      t = new Thread(name) {
        public void run() {
          while(true) {
            System.out.println(this);
            if(--countDown == 0) return;
            try {
              sleep(10);
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
          }
        }
        public String toString() {
          return getName() + ": " + countDown;
        }
      };
      t.start();
    }
  }
}

public class ThreadVariations {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    new InnerThread1("InnerThread1");
    new InnerThread2("InnerThread2");
    new InnerRunnable1("InnerRunnable1");
    new InnerRunnable2("InnerRunnable2");
    new ThreadMethod("ThreadMethod").runThread();
    monitor.expect(new String[] {
      "InnerThread1: 5",
      "InnerThread2: 5",
      "InnerThread2: 4",
      "InnerRunnable1: 5",
      "InnerThread1: 4",
      "InnerRunnable2: 5",
      "ThreadMethod: 5",
      "InnerRunnable1: 4",
      "InnerThread2: 3",
      "InnerRunnable2: 4",
      "ThreadMethod: 4",
      "InnerThread1: 3",
      "InnerRunnable1: 3",
      "ThreadMethod: 3",
      "InnerThread1: 2",
      "InnerThread2: 2",
      "InnerRunnable2: 3",
      "InnerThread2: 1",
      "InnerRunnable2: 2",
      "InnerRunnable1: 2",
      "ThreadMethod: 2",
      "InnerThread1: 1",
      "InnerRunnable1: 1",
      "InnerRunnable2: 1",
      "ThreadMethod: 1"
    }, Test.IGNORE_ORDER + Test.WAIT);
  }
} ///:~
