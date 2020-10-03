package p11;
//: c11:Mouse.java
// Overriding toString().
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

public class Mouse {
  private int mouseNumber;
  public Mouse(int i) { mouseNumber = i; }
  // Override Object.toString():
  public String toString() {
    return "This is Mouse #" + mouseNumber;
  }
  public int getNumber() { return mouseNumber; }
} ///:~
