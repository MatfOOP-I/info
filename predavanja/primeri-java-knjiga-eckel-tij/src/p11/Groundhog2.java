package p11;
//: c11:Groundhog2.java
// A class that's used as a key in a HashMap
// must override hashCode() and equals().
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

public class Groundhog2 extends Groundhog {
  public Groundhog2(int n) { super(n); }
  public int hashCode() { return number; }
  public boolean equals(Object o) {
    return (o instanceof Groundhog2)
      && (number == ((Groundhog2)o).number);
  }
} ///:~
