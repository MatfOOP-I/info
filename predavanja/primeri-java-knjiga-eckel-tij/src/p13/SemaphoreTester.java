package p13;
//: c13:SemaphoreTester.java
// Colliding over shared resources
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

public class SemaphoreTester extends Thread {
  private volatile Semaphore semaphore;
  public SemaphoreTester(Semaphore semaphore) {
    this.semaphore = semaphore;
    setDaemon(true);
    start();
  }
  public void run() {
    while(true)
      if(semaphore.available()) {
        yield(); // Makes it fail faster
        semaphore.acquire();
        yield();
        semaphore.release();
        yield();
      }
  }
  public static void main(String[] args) throws Exception {
    Semaphore sem = new Semaphore();
    new SemaphoreTester(sem);
    new SemaphoreTester(sem);
    new InvariantWatcher(sem).join();
  }
} ///:~
