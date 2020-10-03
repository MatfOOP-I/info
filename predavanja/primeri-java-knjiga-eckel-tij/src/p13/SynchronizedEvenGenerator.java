package p13;
//: c13:SynchronizedEvenGenerator.java
// Using "synchronized" to prevent thread collisions
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

public
class SynchronizedEvenGenerator implements Invariant {
  private int i;
  public synchronized void next() { i++; i++; }
  public synchronized int getValue() { return i; }
  // Not synchronized so it can run at
  // any time and thus be a genuine test:
  public InvariantState invariant() {
    int val = getValue();
    if(val % 2 == 0)
      return new InvariantOK();
    else
      return new InvariantFailure(new Integer(val));
  }
  public static void main(String[] args) {
    SynchronizedEvenGenerator gen =
      new SynchronizedEvenGenerator();
    new InvariantWatcher(gen, 4000); // 4-second timeout
    while(true)
      gen.next();
  }
} ///:~
