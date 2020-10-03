package p13;
//: c13:InvariantFailure.java
// Indicates that the invariant test failed
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

public class InvariantFailure implements InvariantState {
  public Object value;
  public InvariantFailure(Object value) {
    this.value = value;
  }
} ///:~
