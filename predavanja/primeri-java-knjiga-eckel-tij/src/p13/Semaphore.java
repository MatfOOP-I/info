package p13;
//: c13:Semaphore.java
// A simple threading flag
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

public class Semaphore implements Invariant {
  private volatile int semaphore = 0;
  public boolean available() { return semaphore == 0; }
  public void acquire() { ++semaphore; }
  public void release() { --semaphore; }
  public InvariantState invariant() {
    int val = semaphore;
    if(val == 0 || val == 1)
      return new InvariantOK();
    else
      return new InvariantFailure(new Integer(val));
  }
} ///:~
