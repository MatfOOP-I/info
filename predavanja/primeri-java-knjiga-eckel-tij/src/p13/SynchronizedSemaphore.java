package p13;
//: c13:SynchronizedSemaphore.java
// Colliding over shared resources
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

public class SynchronizedSemaphore extends Semaphore {
  private volatile int semaphore = 0;
  public synchronized boolean available() {
    return semaphore == 0;
  }
  public synchronized void acquire() { ++semaphore; }
  public synchronized void release() { --semaphore; }
  public InvariantState invariant() {
    int val = semaphore;
    if(val == 0 || val == 1)
      return new InvariantOK();
    else
      return new InvariantFailure(new Integer(val));
  }
  public static void main(String[] args) throws Exception {
    SynchronizedSemaphore sem =new SynchronizedSemaphore();
    new SemaphoreTester(sem);
    new SemaphoreTester(sem);
    new InvariantWatcher(sem).join();
  }
} ///:~
