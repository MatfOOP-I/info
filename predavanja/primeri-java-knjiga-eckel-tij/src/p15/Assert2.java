package p15;
//: c15:Assert2.java
// Assert with an informative message
// {JVMArgs: -ea}
// {ThrowsException}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

public class Assert2 {
  public static void main(String[] args) {
    assert false: "Here's a message saying what happened";
  }
} ///:~
