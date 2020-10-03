package p13;
//: c13:EvenGenerator.java
// AlwaysEven.java using the invariance tester
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

public class EvenGenerator implements Invariant {
  private int i;
  public void next() { i++; i++; }
  public int getValue() { return i; }
  public InvariantState invariant() {
    int val = i; // Capture it in case it changes
    if(val % 2 == 0)
      return new InvariantOK();
    else
      return new InvariantFailure(new Integer(val));
  }
  public static void main(String[] args) {
    EvenGenerator gen = new EvenGenerator();
    new InvariantWatcher(gen);
    while(true)
      gen.next();
  }
} ///:~
